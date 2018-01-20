package net.siekiera.kafkaproducer;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by W. Siekiera on 20.01.2018
 */
@Service
public class EncryptService {
    /**
     * Creates md5 hash from plain text
     * @param textToEncrypt
     * @return
     */
    public String encrypt(String textToEncrypt) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md.digest(textToEncrypt.getBytes());
            result = String.format("%032x", new BigInteger(1, md5Hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * Checks if md5Hash matches provided plainText
     * @param md5Hash
     * @param plainText
     * @return
     */
    public boolean checkMD5Hash(String md5Hash, String plainText) {
        return encrypt(plainText).equals(md5Hash);
    }
}
