package me.miv.toyserver.provider.kakao.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    private int total_count;

    public Meta() {}

    @JsonCreator
    public Meta(@JsonProperty("total_count") int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_count() {
        return total_count;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "total_count=" + total_count +
                '}';
    }
}
