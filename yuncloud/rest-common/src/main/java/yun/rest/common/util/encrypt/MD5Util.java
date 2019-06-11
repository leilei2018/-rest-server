package yun.rest.common.util.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    static void encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(str.getBytes());
        System.out.println(digest.length);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
    }

}
