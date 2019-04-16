package org.basic.common.utils;
import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>AES加解密</br>
 *
 * @author menghao
 */
public abstract class AESUtil {
    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String UTF8 = "UTF-8";

    private static final Logger LOG = LoggerFactory.getLogger(AESUtil.class);

    /**
     * 执行加密
     *
     * @param plainText    待加密字符串
     * @param keyStrHexStr 密钥字符串
     * @return 加密后的字符串，如果返回null说明加密异常
     */
    public static String encrypt(String plainText, String keyStrHexStr) {
        String cipherTextHexStr = null;
        try {
            byte[] keyArray = Hex.decodeHex(keyStrHexStr.toCharArray());
            byte[] cipherTextArray = encrypt(plainText.getBytes(UTF8), keyArray);
            cipherTextHexStr = Hex.encodeHexString(cipherTextArray);
        } catch (UnsupportedEncodingException e) {
            LOG.error("AESCoder encrypt data occur ", e);
        } catch (DecoderException e) {
            LOG.error("AESCoder encrypt data occur ", e);
        }
        return cipherTextHexStr;
    }

    /**
     * 执行加密
     *
     * @param data     待加密字节数组
     * @param keyArray 密钥字节数组
     * @return 加密后的字节数组，如果返回null说明加密异常
     */
    public static byte[] encrypt(byte[] data, byte[] keyArray) {
        try {
            byte[] key = keyArray;
            Key k = toKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            // 初始化，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, k);
            return cipher.doFinal(data);
        } catch (Exception e) {
            LOG.error("AESCoder encrypt data occur ", e);
        }
        return null;
    }

    /**
     * 执行解密
     *
     * @param cipherTextHexStr 待解密字符串
     * @param keyStrHexStr     密钥字符串
     * @return 解密后的字符串，如果返回null说明加密异常
     */
    public static String decrypt(String cipherTextHexStr, String keyStrHexStr) {
        String plainText = null;
        try {
            byte[] cipherTextArray = Hex.decodeHex(cipherTextHexStr.toCharArray());
            byte[] keyArray = Hex.decodeHex(keyStrHexStr.toCharArray());
            plainText = new String(decrypt(cipherTextArray, keyArray), UTF8);
        } catch (UnsupportedEncodingException e) {
            LOG.error("AESCoder decrypt data occur ", e);
        } catch (DecoderException e) {
            LOG.error("AESCoder decrypt data occur ", e);
        }
        return plainText;
    }

    /**
     * 执行解密
     *
     * @param data     待解密字节数组
     * @param keyArray 密钥字节数组
     * @return 解密后的字节数组，如果返回null说明加密异常
     */
    public static byte[] decrypt(byte[] data, byte[] keyArray) {
        try {
            byte[] key = keyArray;
            Key k = toKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, k);
            return cipher.doFinal(data);
        } catch (Exception e) {
            LOG.error("AESCoder decrypt data occur ", e);
        }
        return null;
    }

    private static Key toKey(byte[] key) {
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    /**
     * Demo
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
    	
    	
        String source = "{\n" +
                "\t\"appKey\" : \"679aae6591a602cb1f5fba0cc26c6230\",\n" +
                "\t\"token\" : \"cBWEpE36MBz8E540OED6cCw9AF612955D7ECE264F9A2//B341537A98BFA084F5F2E5A9F4DEF779\"\n" +
                "\t\"userId\" : \"ANpKGcuYm13ELfEIR5qNI+Cb34U5TBGPOxY75zIZSlYBTLU6byR7yDvUuietVjS4VO4JwKbogezjKzPYaodBJEitWeU2OegN7BOmS20vuLb5HoB9QnuxY7kZYGkgs2GBD+dWde2rXqYNT0DUdrmmEHotv4t74pR2cSFlErJTaOg=\",\n" +
                "}";
        // appSecret
        String appSecret = "5580ce3f3a2e8928a20cf113abfa48fb";
        String encryptMsg = AESUtil.encrypt(source, appSecret);
        System.out.println(encryptMsg);
//        for(int i=0;i<2;i++) {
//        	
//            String decryptMsg = AESUtil.decrypt(encryptMsg, appSecret);
//            
//            //System.out.println(decryptMsg.equals(source));
//            System.out.println(decryptMsg);
//            Thread.sleep(500);
//        }
        
    }
}
