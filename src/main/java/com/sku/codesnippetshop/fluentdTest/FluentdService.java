// FluentdService.java

package com.sku.codesnippetshop.fluentdTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@Transactional
@Service
public class FluentdService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void sendDataToExternalURL(String jsonData) throws JsonProcessingException {
        // JSON 데이터를 해시로 변환
        Map<String, Object> jsonMap = objectMapper.readValue(jsonData, new TypeReference<>() {});

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 엔터티 생성
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(jsonMap, headers);

        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // 외부 URL 설정(Fluentd 주소)
        String externalUrl = "http://localhost:9880/http.msg";  // 실제 Fluentd 서버의 주소로 변경

        // POST 요청 및 응답 처리
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(externalUrl, requestEntity, String.class);
    }
}
