package com.example.authsample.wrapper;

import java.util.Date;

public class RequestTokenWrapper {
    private String token;
    private Long idUser;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
