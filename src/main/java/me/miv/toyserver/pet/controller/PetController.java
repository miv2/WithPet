package me.miv.toyserver.pet.controller;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.pet.dto.request.PetAddRequest;
import me.miv.toyserver.pet.service.PetService;
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
    public ApplicationResponse getPetInfo(@PathVariable Long memberId) {
        return ApplicationResponse.ok("반려견 정보 조회", "");
    }

    @PostMapping
    public ApplicationResponse addPetInformation(@RequestPart(value = "size") PetAddRequest petAddRequest,
                                                 @RequestPart(value = "profileImage") MultipartFile profileImage) {
        petService.addUserPetInto(petAddRequest, profileImage);
        return ApplicationResponse.ok("반려견 정보 저장", "");
    }

}
