package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.itheima.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data   //动态生成get/set/toString/equals等方法
@Accessors(chain = true) //开启链式加载结构 重构了set方法可以连续.
@NoArgsConstructor  //无参构造 必须添加
@AllArgsConstructor //全参构造
public class User {
    protected Long id;
    protected String name;
    //查询不返回，插入数据时，进行填充
    @TableField(value = "pwd",select = false,fill = FieldFill.INSERT)
    protected String password;
    protected Integer age;
    protected String email;

    @TableField(value = "gender")
    protected SexEnum gender;
    @TableField(exist = false)
    protected Integer online;
    //0未删除，1 已经删除
    @TableLogic(value="0",delval = "1")
    protected Integer deleted;

    //更新时间
    protected Date update_time;

    @Version
    private Integer version;


    //临时测试用
    @TableField(exist = false)
    private String list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public SexEnum getGender() {
        return gender;
    }

    public void setGender(SexEnum gender) {
        this.gender = gender;
    }


    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
