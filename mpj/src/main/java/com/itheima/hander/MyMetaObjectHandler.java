package com.itheima.hander;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
       //1、先获取password 的值，如果为空 ，则填充
        Object password = getFieldValByName("password",metaObject);
        if(null == password){
            setFieldValByName("password","888888",metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
