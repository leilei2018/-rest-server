package app.server.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Getter
@Setter
public class SysUser implements Serializable {

    private String id;
    @NotNull(message = "${user.empty}")
    private String name;

    private Integer age;
    public SysUser() {

    }
    public SysUser(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}

