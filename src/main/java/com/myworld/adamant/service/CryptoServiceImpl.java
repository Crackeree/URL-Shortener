package com.myworld.adamant.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CryptoServiceImpl implements CryptoService {

    private final CryptoOperation cryptoOperation;

    public CryptoServiceImpl(CryptoOperation cryptoOperation) {
        this.cryptoOperation = cryptoOperation;
    }

    @Override
    public String hash(String plainText) {

        return cryptoOperation.hash(plainText);
    }
}
