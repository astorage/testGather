package com.example.demo.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boris
 * @date 2020/3/17 13:45
 */
public class TestEncrypt {

    private static BasicTextEncryptor textEncryptor;

    private static  List<String> decode(List<String> ciphertextList, String salt) {
        //加密所需的salt(盐)，在调用decrypt(ciphertext)方法后不可再加盐。不然会报错 Encryption entity already initialized
            textEncryptor.setPassword(salt);
        List<String> cleartextList = new ArrayList<>();
        for (String ciphertext : ciphertextList) {
            String cleartext = decode(ciphertext);
            cleartextList.add(cleartext);
        }
        return cleartextList;
    }

    private static  String decode(String ciphertext) {
        String cleartext = textEncryptor.decrypt(ciphertext);
        return cleartext;
    }

    /**
     * 多次加密操作，相同的salt 相同的明文，加密后的密文不一样
     * @param cleartextList
     * @param salt
     * @return
     */
    private static  List<String> encode(List<String>  cleartextList, String salt) {
        //加密所需的salt(盐)，在调用decrypt(ciphertext)方法后不可再加盐。不然会报错 Encryption entity already initialized
        textEncryptor.setPassword(salt);
        List<String> ciphertextList = new ArrayList<>();
        for (String cleartext : cleartextList) {
            String ciphertext = encode(cleartext);
            ciphertextList.add(ciphertext);
        }
        return ciphertextList;
    }

    private static  String encode(String cleartext) {
        String ciphertext = textEncryptor.encrypt(cleartext);
        return ciphertext;
    }


    public static void main(String[] args) {
//        encodeApp();
//        decodeApp();
        baomi();
    }

    /**
     * 每次加密的密文都不一样啊
     */
    private static  void encodeApp() {
        String mysqlUrl_cleartext = "";
        String userName_cleartext = "root";
        String password_cleartext = "123456";

        String salt = "";
        List<String> cleartextList = new ArrayList();
        cleartextList.add(mysqlUrl_cleartext);
        cleartextList.add(userName_cleartext);
        cleartextList.add(password_cleartext);
        textEncryptor = new BasicTextEncryptor();
        List<String> ciphertextList = encode(cleartextList, salt);
        ciphertextList.stream().forEach(str -> System.out.println(str));
    }

    private static void decodeApp() {
        String mysqlUrl_ciphertext = "";
        String userName_ciphertext = "";
        String password_ciphertext = "";

        String salt = "";
        List<String> ciphertextList = new ArrayList();
        ciphertextList.add(mysqlUrl_ciphertext);
        ciphertextList.add(userName_ciphertext);
        ciphertextList.add(password_ciphertext);
        textEncryptor = new BasicTextEncryptor();
        List<String> cleartextList = decode(ciphertextList, salt);
        cleartextList.stream().forEach(str -> System.out.println(str));
    }


    private static void baomi() {
        String mysqlUrl_ciphertext = "";
        String userName_ciphertext = "";
        String password_ciphertext = "";

        String salt = "";
        List<String> ciphertextList = new ArrayList();
        ciphertextList.add(mysqlUrl_ciphertext);
//        ciphertextList.add(userName_ciphertext);
//        ciphertextList.add(password_ciphertext);
        textEncryptor = new BasicTextEncryptor();
        List<String> cleartextList = decode(ciphertextList, salt);
        cleartextList.stream().forEach(str -> System.out.println(str));
    }





}
