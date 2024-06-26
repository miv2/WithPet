package me.miv.toyserver.pet.controller;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.pet.dto.request.PetAddRequest;
import me.miv.toyserver.pet.service.PetService;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/pet-info")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ApplicationResponse getPetInfo(@AuthenticationPrincipal MemberDetails memberDetails) {
        Member member = memberDetails.getMember();
        return ApplicationResponse.ok("반려견 정보 조회", petService.getUserPetInfo(member.getId()));
    }

    @PostMapping("/save")
    public ApplicationResponse addPetInformation(@RequestPart(value = "petAddRequest") PetAddRequest petAddRequest,
                                                 @RequestPart(value = "profileImage") MultipartFile profileImage) throws Exception {
        return ApplicationResponse.ok("반려견 정보 저장", petService.addUserPetInto(petAddRequest, profileImage));
    }

}
