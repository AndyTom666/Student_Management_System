package com.yanzhuang.util;


import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.*;




public class RSAUtils {
    // KeyPair is a simple holder for a key pair.
    private static final KeyPair keyPair = initKey();
    public static String encryptWithDES(String input, String key) throws Exception {
        // Decode the hexadecimal key string to a SecretKey
        SecretKey secretKey = new SecretKeySpec(DatatypeConverter.parseHexBinary(key), "DES");

        // Create a DES cipher instance in ECB mode with PKCS5 padding
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        // Initialize the cipher for encryption with the DES key
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Perform the encryption and get the resulting ciphertext bytes
        byte[] cipherText = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));

        // Convert the ciphertext bytes to a Base64 string and return it
        return java.util.Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decryptWithDES(String input, String key) throws Exception {
        // Decode the hexadecimal key string to a SecretKey
        SecretKey secretKey = new SecretKeySpec(DatatypeConverter.parseHexBinary(key), "DES");

        // Create a DES cipher instance in ECB mode with PKCS5 padding
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        // Initialize the cipher for decryption with the DES key
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Perform the decryption and get the resulting plaintext bytes
        byte[] plainText = cipher.doFinal(java.util.Base64.getDecoder().decode(input));

        // Convert the plaintext bytes to a string and return it
        return new String(plainText, StandardCharsets.UTF_8);
    }





    /**
     * 初始化方法，产生key pair，提供provider和random
     * @return KeyPair instance
     */
    private static KeyPair initKey() {
        try
        {
            // 添加provider
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            // 产生用于安全加密的随机数
            SecureRandom random = new SecureRandom();
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", provider);
            generator.initialize(1024, random);
            return generator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 解密数据
     * @param string 需要解密的字符串
     * @return 破解之后的字符串
     */
    public static String decryptBase64(String string) {
        // decodeBase64():将Base64数据解码为"八位字节”数据
        return new String(decrypt(Base64.decodeBase64(string)));
    }

    private static byte[] decrypt(byte[] byteArray) {
        try {
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            // Cipher: 提供加密和解密功能的实例
            // transformation: "algorithm/mode/padding"
            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", provider);
            PrivateKey privateKey = keyPair.getPrivate();
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            // doFinal(): 加密或者解密数据
            byte[] plainText = cipher.doFinal(byteArray);
            return plainText;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
