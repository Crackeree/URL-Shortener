package com.myworld.adamant;

import com.myworld.adamant.service.CryptoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crypto")
@Slf4j
public class CryptoOperationController {

    private final CryptoService cryptoService;

    public CryptoOperationController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostMapping(value = "/hash", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String hash(@RequestBody String plainText) {

        return cryptoService.hash(plainText);
    }
}

