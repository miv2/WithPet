package me.miv.toyserver.region.service;

import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.region.dto.response.RegionResponse;
import me.miv.toyserver.region.domain.Region;
import me.miv.toyserver.region.repository.RegionJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionService {

    private final RegionJpaRepository regionJpaRepository;

    public RegionService(RegionJpaRepository regionJpaRepository) {
        this.regionJpaRepository = regionJpaRepository;
    }

    public Region getUserRegionInfo(Long memberId) {
        return regionJpaRepository.findByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("저장된 지역이 없습니다."));
    }

    public void saveUserRegionInfo(RegionResponse regionResponse, Member member) {
        Region region = new Region(regionResponse, member.getId());
        regionJpaRepository.save(region);
    }

}
