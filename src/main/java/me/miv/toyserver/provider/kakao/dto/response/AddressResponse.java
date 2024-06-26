package me.miv.toyserver.provider.kakao.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.miv.toyserver.provider.kakao.dto.Documents;
import me.miv.toyserver.provider.kakao.dto.Meta;

import java.util.List;

public class AddressResponse {
    private Meta meta;
    private List<Documents> documents;

    public AddressResponse() {}

    @JsonCreator
    public AddressResponse(@JsonProperty("meta") Meta meta, @JsonProperty("documents") List<Documents> documents) {
        this.meta = meta;
        this.documents = documents;
    }

    public Meta getMeta() {
        return meta;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "AddressResponse{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
