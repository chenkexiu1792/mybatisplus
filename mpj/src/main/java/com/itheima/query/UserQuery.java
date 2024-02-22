package com.itheima.query;

import com.itheima.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserQuery  extends User {
    //年龄有上下限，此属性描述年龄的上限，父类User中 age属性，描述年龄的上限
    private Integer age2;

    public Integer getAge2() {
        return age2;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }
}
