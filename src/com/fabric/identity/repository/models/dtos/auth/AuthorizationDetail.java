package com.fabric.identity.repository.models.dtos.auth;

import java.util.Map;

public class AuthorizationDetail {
    private String authorizationId;
    private AuthorizationType type;
    private String token;
    private Map<String, String> config;

    public AuthorizationDetail() {
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }

    public AuthorizationType getType() {
        return type;
    }

    public void setType(AuthorizationType type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
