package me.miv.toyserver;

import me.miv.toyserver.like.repository.MemberLikeJpaRepository;
import me.miv.toyserver.like.repository.MemberLikeRepository;
import me.miv.toyserver.like.service.MemberLikeService;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.member.repository.MemberJpaRepository;
import me.miv.toyserver.pet.domain.Pet;
import me.miv.toyserver.pet.repository.PetJpaRepository;
import me.miv.toyserver.region.domain.Region;
import me.miv.toyserver.region.repository.RegionJpaRepository;
import me.miv.toyserver.region.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final RegionJpaRepository regionJpaRepository;
    private final PetJpaRepository petJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final RegionRepository regionRepository;
    private final MemberLikeJpaRepository memberLikeJpaRepository;
    private final MemberLikeService memberLikeService;
    private final MemberLikeRepository memberLikeRepository;

    public TestService(RegionJpaRepository regionJpaRepository, PetJpaRepository petJpaRepository, MemberJpaRepository memberJpaRepository, RegionRepository regionRepository, MemberLikeJpaRepository memberLikeJpaRepository, MemberLikeService memberLikeService, MemberLikeRepository memberLikeRepository) {
        this.regionJpaRepository = regionJpaRepository;
        this.petJpaRepository = petJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.regionRepository = regionRepository;
        this.memberLikeJpaRepository = memberLikeJpaRepository;
        this.memberLikeService = memberLikeService;
        this.memberLikeRepository = memberLikeRepository;
    }

    public List<MatchingInfoResponse> test() {
        List<Region> regionList = regionRepository.findByMemberId(17L);
//        Boolean isLike = memberLikeJpaRepository.existsByMemberId(54L);
//        List<Region> regionList = regionJpaRepository.findAll();

        int size = regionList.size();
        System.out.println("검색된 회원 숫자 : " + size);

        List<MatchingInfoResponse> matchingInfoResponses = new ArrayList<>(size);

        for (Region region : regionList) {
            String regionName = region.getRegionName();
            Long memberId = region.getMemberId();
            // 이름, 나이, 성별, 닉네임
            Optional<Member> member = memberJpaRepository.findById(memberId);
            // 프로필 이미지, 펫 상세정보
            Pet memberPet = petJpaRepository.findByMemberId(memberId);
            // like
            Boolean isLike = memberLikeJpaRepository.existsByMemberIdAndLikeProfileId(17L, memberId);

            MatchingInfoResponse response = new MatchingInfoResponse(
                    member.get().getId(),
                    member.get().getNickName(),
                    member.get().getAge(),
                    member.get().getSexType(),
                    regionName,

                    memberPet.getProfileImage(),
                    memberPet.getIntroduction(),
                    memberPet.getSize(),
                    memberPet.getSex(),
                    memberPet.getAge(),
                    isLike

            );

            matchingInfoResponses.add(response);

        }

        return matchingInfoResponses;
    }


}
