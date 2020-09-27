package com.sun.recite.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable{
	
	private final int code = 20000;
	
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
    
    public int getCode() {
		return code;
	}

	public String getJwt() {
        return jwt;
    }
}
