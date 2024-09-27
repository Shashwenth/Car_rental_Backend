package com.CarRental.Backend.Controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRental.Backend.Security.RsaKeyProperties;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

@RestController
@RequestMapping("/formlogin")
public class PublicKeyController {
	
    private final RsaKeyProperties rsaKeys;

    public PublicKeyController(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    @GetMapping("/.well-known/jwks.json")
    public Map<String, Object> getPublicKey() {
        RSAKey jwk = new RSAKey.Builder(rsaKeys.getPublicKey()).build();
        return new JWKSet(jwk).toJSONObject();
    }
}