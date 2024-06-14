package me.miv.toyserver.pet.repository;

import me.miv.toyserver.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<Pet, Long> {
    Boolean existsByMemberId(Long memberId);

    Pet findByMemberId(Long memberId);
}
