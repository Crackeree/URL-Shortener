package com.myworld.adamant.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Component
@Slf4j
public class DigestImpl implements Digest {

    private static final String ALGORITHM = "SHA-256";

    @Override
    public byte[] digest(byte[] data) {

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return digest.digest(data);
    }
}
