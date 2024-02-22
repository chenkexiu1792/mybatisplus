package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;

public interface IUserService extends IService<User> {

    /**
     *原始mybatis写法，兜底方案
     */
    public List<Map<String,Object>> getById_self(Map<String,Object> map);


}
