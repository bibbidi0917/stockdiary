package com.koscom.stockdiary.domain;

import com.koscom.stockdiary.web.dto.KoscomProperties;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class ApiRepositoryImpl implements ApiRepository {
    private final RestTemplate restTemplate;
    private final KoscomProperties koscomProperties;

    @Override
    public String findByQuery(String marketcode, String issuecode) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("apikey", koscomProperties.getApikey());

        String url = koscomProperties.getUrl() + "/" + marketcode + "/" + issuecode + "/price";
        String response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class).getBody().toString();
        JSONObject jObject = new JSONObject(response);
        JSONObject p1 = jObject.getJSONObject("result");
        return Double.toString(p1.getDouble("trdPrc"));
    }
}
