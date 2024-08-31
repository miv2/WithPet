package me.miv.toyserver.pet.service;

import me.miv.toyserver.file.FileUploadService;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.member.domain.Role;
import me.miv.toyserver.member.enumeration.RoleType;
import me.miv.toyserver.member.repository.MemberJpaRepository;
import me.miv.toyserver.member.repository.MemberRepository;
import me.miv.toyserver.member.repository.RoleRepository;
import me.miv.toyserver.pet.domain.Pet;
import me.miv.toyserver.pet.dto.request.PetAddRequest;
import me.miv.toyserver.pet.dto.request.PetUpdateRequest;
import me.miv.toyserver.pet.repository.PetJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PetService {
    private final PetJpaRepository petJpaRepository;
    private final FileUploadService fileUploadService;
    private final RoleRepository roleRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;

    public PetService(PetJpaRepository petJpaRepository, FileUploadService fileUploadService, RoleRepository roleRepository, MemberJpaRepository memberJpaRepository, MemberRepository memberRepository) {
        this.petJpaRepository = petJpaRepository;
        this.fileUploadService = fileUploadService;
        this.roleRepository = roleRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.memberRepository = memberRepository;
    }

    public Pet getUserPetInfo(Long memberId) {
        return petJpaRepository.findByMemberId(memberId);
    }

    public Pet get(Long userPetInfoId) {
        return petJpaRepository.findById(userPetInfoId).orElseThrow(() -> new IllegalArgumentException("pet doesn't exist"));
    }

    @Transactional
    public String addUserPetInto(PetAddRequest petAddRequest, MultipartFile profileImage) {
        Boolean existsByMemberId = petJpaRepository.existsByMemberId(petAddRequest.getMemberId());

        if(existsByMemberId) {
            Exception exception = new Exception("이미 등록된 반려견 정보가 있습니다.");
            return exception.getMessage();
        }

        String imageFileName = "";

        if(profileImage != null && !profileImage.isEmpty()) {
            imageFileName = fileUploadService.fileUpload(profileImage);
        }

        Pet pet = new Pet(petAddRequest, imageFileName);
        petJpaRepository.save(pet);

        // 등급 변경
        Role roleByType = roleRepository.findRoleByType(RoleType.ROLE_NORMAL);
        Member member = memberRepository.findByMemberId(petAddRequest.getMemberId());
        member.setRole(roleByType);
        memberJpaRepository.save(member);

        return "반려견 정보가 입력되었습니다.";
    }

    @Transactional
    public String updateUserPetInfo(PetUpdateRequest petUpdateRequest, MultipartFile profileImage) {
        Pet pet = get(petUpdateRequest.getUserPetInfoId());

        if(ObjectUtils.isEmpty(pet)) {
            Exception exception = new Exception("등록된 반려견 정보가 없습니다.");
            return exception.getMessage();
        }

        String imageFileName = "";

        if(!profileImage.isEmpty()) {
            imageFileName = fileUploadService.fileUpload(profileImage);
        }

        pet.setAge(petUpdateRequest.getAge());
        pet.setIntroduction(petUpdateRequest.getIntroduction());
        pet.setSex(petUpdateRequest.getSex());
        pet.setSize(petUpdateRequest.getSize());
        pet.setProfileImage(imageFileName);
        petJpaRepository.save(pet);

        return "반려견 정보가 수정되었습니다.";
    }
}
