package yun.rest.sso.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SsoToken {

    private String userCode;
    private String clientId;
    private String redirectUrl;

    public SsoToken() {
    }

    public SsoToken(String userCode, String clientId, String redirectUrl) {
        this.userCode = userCode;
        this.clientId = clientId;
        this.redirectUrl = redirectUrl;
    }
}
