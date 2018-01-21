package net.siekiera.kafkaproducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class KafkaproducerApplicationTests {
//    @Autowired
//    EncryptService encryptService;

    private final String toEncrypt1 = "test";
    private final String toEncrypt2 = "testtestrrr";
    private final String toEncrypt3 = "dlugi ciag znakow!";
    private final String toEncrypt4 = "externally encrypted string";

    private final String encrypted1 = "098f6bcd4621d373cade4e832627b4f6";
    private final String encrypted2 = "a168d70ced5d3f1fed60578c47784075";
    private final String encrypted3 = "7acea3a8a75d5012917e58dd06a238fc";
    private final String encrypted4 = "12f5d6f6d25e8649f6f481ec0b23df2a";

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void encryptServiceCheck() {
//
//        assertTrue(encryptService.encrypt(toEncrypt1).equals(encrypted1));
//        assertTrue(encryptService.encrypt(toEncrypt2).equals(encrypted2));
//        assertTrue(encryptService.encrypt(toEncrypt3).equals(encrypted3));
//        assertTrue(encryptService.encrypt(toEncrypt4).equals(encrypted4));
//    }
//
//    @Test
//    public void decryptCheck() {
//        assertTrue(encryptService.checkMD5Hash(encrypted1, toEncrypt1));
//        assertTrue(encryptService.checkMD5Hash(encrypted2, toEncrypt2));
//        assertTrue(encryptService.checkMD5Hash(encrypted3, toEncrypt3));
//        assertTrue(encryptService.checkMD5Hash(encrypted4, toEncrypt4));
//    }
}
