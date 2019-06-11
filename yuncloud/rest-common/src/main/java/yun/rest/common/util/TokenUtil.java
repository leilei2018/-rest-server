package yun.rest.common.util;

import com.alibaba.fastjson.JSON;
import yun.rest.common.enums.TokenStateEnum;
import yun.rest.common.util.IPUtil;
import yun.rest.common.util.encrypt.Base64Util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TokenUtil {

    //数字签名，
    //网站A向CA认证机构提交自己的(网站信息和公钥)
    public static String  generateSsoToken(String userId,String clientId){
        return Base64Util.encrypt(userId+"_"+clientId);
    }

    public static String  parseSsoToken(String ssoToken){
        String encrypt = Base64Util.encrypt(ssoToken);
        return encrypt;
    }

    public static String  generate(String userId,String userName){
        return generate(userId,userName,30,TimeUnit.MINUTES);
    }

    public static String generate(String userId, String userName, long time, TimeUnit unit){
        long future = System.currentTimeMillis()+unit.toMicros(time);
        String token = userId+"_"+userName+"_"+ IPUtil.getInetAddress()+"_"+future;
        return Base64Util.encrypt(token);
    }

    public static TokenStateEnum check(String string) throws IOException {
        String decrypt = Base64Util.decrypt(string);
        if (!decrypt.matches(".+_.+_.+_.+"))
            return TokenStateEnum.UNKONW;
        String[] arr = decrypt.split("_");
        String timestampStr = arr[arr.length - 1];

        long timestamp = 0;
        try {
            timestamp = Long.parseLong(timestampStr);
            if (timestamp<=System.currentTimeMillis()){
                return TokenStateEnum.EXPIRED;
            }
            return TokenStateEnum.NORMAL;
        } catch (NumberFormatException e) {
            return TokenStateEnum.ERROR;
        }
    }
}
