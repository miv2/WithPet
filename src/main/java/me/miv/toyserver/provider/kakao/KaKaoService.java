package me.miv.toyserver.provider.kakao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.miv.toyserver.provider.kakao.dto.Documents;
import me.miv.toyserver.provider.kakao.dto.response.AddressResponse;
import me.miv.toyserver.region.dto.request.CoordinatesRequest;
import me.miv.toyserver.region.dto.response.RegionResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class KaKaoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public RegionResponse getRegionName(CoordinatesRequest coordinatesRequest) {
        String url = String.format("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=%f&y=%f", coordinatesRequest.getX(), coordinatesRequest.getY());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + "64c6acd44cea1a238c412a5cb6af2dbd");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String body = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            AddressResponse addressResponse = objectMapper.readValue(body, AddressResponse.class);
            List<Documents> documents = addressResponse.getDocuments();

            String region_1depth_name = documents.get(0).getRegion_1depth_name();
            String region_2depth_name = documents.get(0).getRegion_2depth_name();
            double x = documents.get(0).getX();
            double y = documents.get(0).getY();

            RegionResponse regionResponse = new RegionResponse(region_1depth_name + " " + region_2depth_name, x, y);
            return regionResponse;

        } catch (JsonProcessingException e) {
            System.err.println("JSON 파싱 오류: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }





}
