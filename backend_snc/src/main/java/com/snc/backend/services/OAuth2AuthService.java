package com.snc.backend.services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;
import java.util.HashMap;

@Service
public class OAuth2AuthService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${keycloak.auth-server-url}")
    private String keycloakAuthUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    public Map<String, Object> authenticate(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        private final String keycloakUrl = "http://localhost:8080/realms/"+realm+"/protocol/openid-connect/token";
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String requestBody = UriComponentsBuilder.newInstance()
                .queryParam("grant_type", "password")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("username", username)
                .queryParam("password", password)
                .queryParam("scope", "openid profile email")
                .build()
                .encode()
                .toString().substring(1); 

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                keycloakUrl, HttpMethod.POST, request, Map.class
            );
            return response.getBody();
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials or server error");
            return errorResponse;
        }
    }
}

