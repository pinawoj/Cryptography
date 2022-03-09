package com.pwojcik;

import com.pwojcik.encryption.CaesarCipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static final int SHIFT = 3;

    public static void main(String[] args) {

        LOGGER.info("Running Caesar Cipher...");

        CaesarCipher caesarCipher = new CaesarCipher(SHIFT);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message to encrypt: ");
        String message = scanner.nextLine().toLowerCase();
        System.out.println(caesarCipher.encrypt(message));


        System.out.println("Enter a message to decrypt: ");
        message = scanner.nextLine().toLowerCase();
        System.out.println(caesarCipher.decrypt(message));

    }
}
