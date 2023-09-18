package com.zuitt.wdc044.models;

import java.io.Serializable;
public class JwtResponse {

    private static final long serialVersionUID = 7566815519555087892L;
    private final String jwtToken;

    //constructor parameterized
    public JwtResponse(String jwtToken){
        this.jwtToken = jwtToken;
    }

    //getter
    public String getJwtToken(){
        return this.jwtToken;
    }
}
