package com.myworld.adamant.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

@Component
@Slf4j
public class CryptoOperationImpl implements CryptoOperation {

    private final Digest digest;

    public CryptoOperationImpl(Digest digest) {
        this.digest = digest;
    }

    @Override
    public String hash(String plainText) {

        return HexFormat.of().formatHex(digest.digest(plainText.getBytes(StandardCharsets.UTF_8)));
    }
}
