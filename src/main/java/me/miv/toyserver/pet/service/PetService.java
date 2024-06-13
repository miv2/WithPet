package me.miv.toyserver.pet.service;

import io.jsonwebtoken.lang.Objects;
import me.miv.toyserver.file.FileUploadService;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.pet.domain.Pet;
import me.miv.toyserver.pet.dto.request.PetAddRequest;
import me.miv.toyserver.pet.repository.PetJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PetService {
    private final PetJpaRepository petJpaRepository;
    private final FileUploadService fileUploadService;

    public PetService(PetJpaRepository petJpaRepository, FileUploadService fileUploadService) {
        this.petJpaRepository = petJpaRepository;
        this.fileUploadService = fileUploadService;
    }

    @Transactional
    public void addUserPetInto(PetAddRequest petAddRequest, MultipartFile profileImage) {

        String imageFileName = "";

        if(!profileImage.isEmpty()) {
            imageFileName = fileUploadService.fileUpload(profileImage);
        }

        Pet pet = new Pet(petAddRequest, imageFileName);

        petJpaRepository.save(pet);
    }
}
