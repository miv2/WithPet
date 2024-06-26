package me.miv.toyserver.region.domain;

import jakarta.persistence.*;
import me.miv.toyserver.common.TimeAuditingBaseEntity;
import me.miv.toyserver.region.dto.response.RegionResponse;

@Entity
@Table(name = "region")
public class Region extends TimeAuditingBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @Column(name = "member_id")
    private Long memberId;

    public Region() {}

    public Region(RegionResponse regionResponse, Long memberId) {
        this.regionName = regionResponse.getRegion_name();
        this.x = regionResponse.getX();
        this.y = regionResponse.getY();
        this.memberId = memberId;
    }

    public Long getId() {
        return id;
    }

    public String getRegionName() {
        return regionName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Long getMemberId() {
        return memberId;
    }
}
