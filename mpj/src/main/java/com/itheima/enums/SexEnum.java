package com.itheima.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import org.springframework.stereotype.Component;

public enum SexEnum implements IEnum<Integer> {
    MAN(1,"男"),
    WOMAN(2,"女");
    private int value;
    private String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SexEnum{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
