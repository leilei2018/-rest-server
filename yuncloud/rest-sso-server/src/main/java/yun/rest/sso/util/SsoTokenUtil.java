package yun.rest.sso.util;

import yun.rest.common.util.TokenUtil;
import yun.rest.common.util.encrypt.Base64Util;
import yun.rest.sso.config.SsoConstant;
import yun.rest.sso.vo.SsoToken;

public class SsoTokenUtil {
    public static SsoToken  parseSsoToken(String ssoToken){
        String origin = Base64Util.encrypt(ssoToken);
        String userCode = origin.split("_")[0];
        String clientId = origin.split("_")[1];
        String redirectUrl = origin.split("_")[2];
        SsoToken st = new SsoToken(userCode,clientId,redirectUrl);
        return st;
    }

    public static void main(String[] args) {

        String ks001 = TokenUtil.generate("ks001", "application-tydic-oa");
        System.out.println(ks001);

    }


    public static String createRedisKey( SsoToken stoken ){
        StringBuffer keyBuffer = new StringBuffer(SsoConstant.sso_prefix)
                .append(":").append(stoken.getClientId())
                .append(":").append(stoken.getUserCode());
        String key = keyBuffer.toString();
        return key;
    }

}
