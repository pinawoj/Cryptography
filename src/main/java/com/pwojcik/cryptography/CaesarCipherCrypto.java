package com.pwojcik.cryptography;

import com.pwojcik.FileManager;
import com.pwojcik.ciphers.CaesarCipher;

import java.util.Scanner;

public class CaesarCipherCrypto {

    private static final String CIPHER_FILE = "caesar_cipher.txt";
    private static final String TEXT_FILE = "plain_text.txt";

    private final CaesarCipher caesarCipher;
    private final FileManager fileManager;

    public CaesarCipherCrypto(int shift) {
        this.caesarCipher = new CaesarCipher(shift);
        this.fileManager = new FileManager();
    }

    public void encryptFromConsole() {

        Scanner scanner = new Scanner(System.in);
        String encrypted = caesarCipher.encrypt(scanner.nextLine());

        System.out.println(encrypted);

        fileManager.writeToFile(encrypted, CIPHER_FILE);

    }

    public void encryptFromFile() {

        String encrypted = caesarCipher.encrypt(fileManager.readFromFile(TEXT_FILE));

        System.out.println(encrypted);

        fileManager.writeToFile(encrypted, CIPHER_FILE);

    }

    public void decryptFromFile() {

        String decrypted = caesarCipher.decrypt(fileManager.readFromFile(CIPHER_FILE));

        System.out.println(decrypted);

        fileManager.writeToFile(decrypted, TEXT_FILE);

    }

}
