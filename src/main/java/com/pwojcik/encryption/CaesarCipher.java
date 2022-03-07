package com.pwojcik.encryption;

public class CaesarCipher extends Cipher {

    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encryption(String message) {

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                encrypted.append(message.charAt(i));
            } else {
                encrypted.append((char) ('a' + (((message.charAt(i) - 'a') + shift) % 26)));
            }
        }

        return encrypted.toString();
    }

    @Override
    public String decryption(String message) {

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                decrypted.append(message.charAt(i));
            } else {
                decrypted.append((char) ('a' + (((message.charAt(i) - 'a') - shift) % 26)));
            }
        }

        return decrypted.toString();
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

}
