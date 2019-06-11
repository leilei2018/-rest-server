package yun.rest.common.util.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Base64Util {

    public static Charset charset = Charset.forName("utf-8");

    public static String encrypt(String string){
        BASE64Encoder en = new BASE64Encoder();
        String encode = en.encode(string.getBytes(charset));
        return encode;
    }
    public static byte[] decryptBytes(String string) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(string);
        return bytes;
    }
    public static String decrypt(String string) throws IOException {
        byte[] bytes = decryptBytes(string);
        return new String(bytes,charset);
    }
}
