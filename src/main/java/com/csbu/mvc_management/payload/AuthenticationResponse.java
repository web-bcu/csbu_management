package com.csbu.mvc_management.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
//@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String id;
    private String fullname;
    private List<String> roles;

    public AuthenticationResponse(String token, String id, String fullname, List<String> roles) {
        this.token = token;
        this.id = id;
        this.fullname = fullname;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getRoles() {
        return roles;
    }
}
