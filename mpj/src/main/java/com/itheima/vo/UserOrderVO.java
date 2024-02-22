package com.itheima.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author Administrator
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data   //动态生成get/set/toString/equals等方法
@Accessors(chain = true) //开启链式加载结构 重构了set方法可以连续.
@NoArgsConstructor  //无参构造 必须添加
@AllArgsConstructor //全参构造
@TableName("user")
public class UserOrderVO  extends User {
    private static final long serialVersionUID = 1L;

    // 不太懂的可以看看TableField注解,源码里写的明明白白
    @TableField(exist = false)
    private String orderId;
    /**
     * 因为在类中用的是这个名字，所以我在sql语句里用了as
     */
    @TableField(exist = false)
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserOrderVO{" +
                "userId='" + userId + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", online=" + online +
                ", deleted=" + deleted +
                '}';
    }
}
