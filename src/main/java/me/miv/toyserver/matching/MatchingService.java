package me.miv.toyserver.matching;

import me.miv.toyserver.MatchingInfoResponse;
import me.miv.toyserver.like.repository.MemberLikeJpaRepository;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.member.repository.MemberJpaRepository;
import me.miv.toyserver.pet.domain.Pet;
import me.miv.toyserver.pet.repository.PetJpaRepository;
import me.miv.toyserver.region.domain.Region;
import me.miv.toyserver.region.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchingService {

    private final RegionRepository regionRepository;
    private final PetJpaRepository petJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final MemberLikeJpaRepository memberLikeJpaRepository;

    public MatchingService(RegionRepository regionRepository, PetJpaRepository petJpaRepository, MemberJpaRepository memberJpaRepository, MemberLikeJpaRepository memberLikeJpaRepository) {
        this.regionRepository = regionRepository;
        this.petJpaRepository = petJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.memberLikeJpaRepository = memberLikeJpaRepository;
    }

    public List<MatchingInfoResponse> getMatchingList(Long id) {
        List<Region> regionList = regionRepository.findByMemberId(id);
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
            Boolean isLike = memberLikeJpaRepository.existsByMemberIdAndLikeProfileId(id, memberId);

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
