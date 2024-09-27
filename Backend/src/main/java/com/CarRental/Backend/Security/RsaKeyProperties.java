package com.CarRental.Backend.Security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.stereotype.Component;


public class RsaKeyProperties {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    public RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }
}
