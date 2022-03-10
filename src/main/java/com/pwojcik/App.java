package com.pwojcik;

import com.pwojcik.cryptography.CaesarCipherCrypto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static final int SHIFT = 3;

    public static void main(String[] args) {

        LOGGER.info("Running Caesar Cipher...");

        CaesarCipherCrypto caesarCipher = new CaesarCipherCrypto(SHIFT);
        caesarCipher.encryptFromConsole();

    }
}
