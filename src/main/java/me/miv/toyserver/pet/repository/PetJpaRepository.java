package me.miv.toyserver.pet.repository;

import me.miv.toyserver.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetJpaRepository extends JpaRepository<Pet, Long> {
    Boolean existsByMemberId(Long memberId);

    Pet findByMemberId(Long memberId);

    Optional<Pet> findById(Long userPetInfoId);
}
