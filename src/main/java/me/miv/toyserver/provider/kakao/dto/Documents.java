package me.miv.toyserver.provider.kakao.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Documents {
    private String region_type;
    private String code;
    private String address_name;
    private String region_1depth_name;
    private String region_2depth_name;
    private String region_3depth_name;
    private String region_4depth_name;
    private double x;
    private double y;

    public Documents() {}

    @JsonCreator
    public Documents(@JsonProperty("region_type") String region_type, @JsonProperty("code") String code,
                     @JsonProperty("address_name") String address_name, @JsonProperty("region_1depth_name") String region_1depth_name,
                     @JsonProperty("region_2depth_name") String region_2depth_name, @JsonProperty("region_3depth_name") String region_3depth_name,
                     @JsonProperty("region_4depth_name") String region_4depth_name, @JsonProperty("x") double x,
                     @JsonProperty("y") double y) {
        this.region_type = region_type;
        this.code = code;
        this.address_name = address_name;
        this.region_1depth_name = region_1depth_name;
        this.region_2depth_name = region_2depth_name;
        this.region_3depth_name = region_3depth_name;
        this.region_4depth_name = region_4depth_name;
        this.x = x;
        this.y = y;
    }

    public String getRegion_type() {
        return region_type;
    }

    public String getCode() {
        return code;
    }

    public String getAddress_name() {
        return address_name;
    }

    public String getRegion_1depth_name() {
        return region_1depth_name;
    }

    public String getRegion_2depth_name() {
        return region_2depth_name;
    }

    public String getRegion_3depth_name() {
        return region_3depth_name;
    }

    public String getRegion_4depth_name() {
        return region_4depth_name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "region_type='" + region_type + '\'' +
                ", code='" + code + '\'' +
                ", address_name='" + address_name + '\'' +
                ", region_1depth_name='" + region_1depth_name + '\'' +
                ", region_2depth_name='" + region_2depth_name + '\'' +
                ", region_3depth_name='" + region_3depth_name + '\'' +
                ", region_4depth_name='" + region_4depth_name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
