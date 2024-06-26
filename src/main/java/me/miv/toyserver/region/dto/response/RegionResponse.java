package me.miv.toyserver.region.dto.response;

public class RegionResponse {
    private String region_name;
    private double x;
    private double y;

    public RegionResponse(String region_name, double x, double y) {
        this.region_name = region_name;
        this.x = x;
        this.y = y;
    }

    public String getRegion_name() {
        return region_name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
