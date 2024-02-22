package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.domain.User;
import com.itheima.ext.MyBaseMapper;
import com.itheima.vo.UserOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
//public interface UserDao extends BaseMapper<User> {
//
//}

public interface UserDao extends MyBaseMapper<User> {

    /**
     * 如果自定义的方法还希望能够使用MP提供的Wrapper条件构造器，则需要如下写法
     * @param userWrapper
     */
    @Select("select * from user {ew.customSqlSegment}")
    public List<User> getAll_byWrapper(@Param (Constants.WRAPPER) Wrapper<User> userWrapper);


    /**
     * 原始mybatis 方式传入 map ，返回 map
     * @param map
     */
    public List<Map<String,Object>> getById_self( Map<String,Object> map);


    /**
     * 自定Wrapper修改
     * @param userWrapper 条件构造器
     * @param user        修改的对象参数
     * @return
     */
    int updateUserByMyWrapper(@Param(Constants.WRAPPER) Wrapper<User> userWrapper,@Param("user") User user);


    /**
     * @param page
     * @param userWrapper
     * @return
     */
    IPage<UserOrderVO> page(@Param("page") IPage<UserOrderVO> page, @Param (Constants.WRAPPER) Wrapper<UserOrderVO> userWrapper);


    IPage<List<Map<String,Object>>> getID(@Param("page") IPage<List<Map<String,Object>>> page,@Param("map") Map<String,Object> map);
}