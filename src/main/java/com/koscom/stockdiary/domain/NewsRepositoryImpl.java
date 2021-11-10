package com.koscom.stockdiary.domain;

import com.koscom.stockdiary.web.dto.NaverProperties;
import com.koscom.stockdiary.web.dto.ResponseNews;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NewsRepositoryImpl implements NewsRepository {
    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    @Override
    public List<News> findByQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getNewsUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseNews.class)
                .getBody()
                .getItems()
                .stream()
                .map(m -> News.builder()
                        .title(m.getTitle())
                        .build())
                .collect(Collectors.toList());
    }
}
