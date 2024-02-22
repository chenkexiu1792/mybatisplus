package com.itheima.transfer.vo;

import com.itheima.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Administrator
 * @Version 1.0
 */
@Data
@NoArgsConstructor  //无参构造 必须添加
public class UserVO implements Serializable {
    private long id;
    private String vo_name;

    private Integer gender;

    private String dis;
    private List<String> list;

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", vo_name='" + vo_name + '\'' +
                ", gender=" + gender +
                ", dis='" + dis + '\'' +
                ", list=" + list +
                '}';
    }
}
