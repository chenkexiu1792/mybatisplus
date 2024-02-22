package com.itheima.inject;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.ArrayList;
import java.util.List;

public class MySqlInject extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> list = new ArrayList<AbstractMethod>() ;
        //先增加 DefaultSqlInjector 中所有 statement 方法
        list.addAll(super.getMethodList(mapperClass));
        //再增加自定义方法
        list.add(new GetAll());
        return list;
    }
}
