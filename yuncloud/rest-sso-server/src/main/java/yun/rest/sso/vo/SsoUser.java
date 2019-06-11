package yun.rest.sso.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Hello world!
 *
 */
@Getter
@Setter
public class SsoUser implements Serializable {

      private String useId;
      private String useCode;
      private String password;

}
