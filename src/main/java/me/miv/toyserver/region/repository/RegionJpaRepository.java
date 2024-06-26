package me.miv.toyserver.region.repository;

import me.miv.toyserver.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionJpaRepository extends JpaRepository<Region, Long> {
    Optional<Region> findByMemberId(Long memberId);
}
