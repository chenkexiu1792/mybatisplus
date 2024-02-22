package com.itheima;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.enums.SexEnum;
import com.itheima.transfer.vo.UserConvertMapper;
import com.itheima.transfer.vo.UserVO;
import com.itheima.vo.UserOrderVO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootTest
class T03 {

    @Autowired
    UserDao userDao;

    @Test
    public void inserUser(){
        User user = new User();
        user.setName("yangjing");
        user.setAge(56);
        //user.setPassword("123456");
        user.setGender(SexEnum.WOMAN);
        user.setEmail("110@qq.com");
        //user.setId(889l);

        //推荐使用这种方式
        java.util.Date date = new Date();//获得当前时间
        Timestamp update_time_1 = new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date date2 = new Date();//获得当前时间
        String update_time_2 = df.format(date2);//将当前时间转换成特定格式的时间字符串，这样便可以插入到数据库中
        user.setUpdate_time(date2);
        userDao.insert(user);

    }

    @Test
    void delete(){
        //userDao.deleteById(2l);
        User user = userDao.selectById(3l);
        user.setAge(100);
        userDao.insert(user);
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }
    @Test
    void update(){
//        User user = new User();
//        user.setId(3l);
//        user.setAge(100);
//        user.setVersion(12);
//        userDao.updateById(user);
        User user = userDao.selectById(3l);
        user.setAge(100);
        userDao.updateById(user);

    }

    @Test
    void getAll(){
        List<User> all = userDao.getAll();
        System.out.println(all);
    }


    @Test
    void selectById(){
        User user = userDao.selectById(1665913141769281537L);
        System.out.println(user);
    }

    @Test
    void testGetByPage(){
        IPage page = new Page(1,2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("age",100);
        userDao.selectPage(page,queryWrapper);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少条数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());
    }

    @Test
    void getById_self(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",1);
        List<Map<String,Object>> byId_self_list = userDao.getById_self(map);
        System.out.println(byId_self_list);
    }

    /**
     * 还可以使用MyBatis-Plus的SQL构建器进行多表关联查询，例如：
     */
    @Test
    void multiTableJoin(){
//        QueryWrapper<UserOrderVO> wrapper = new QueryWrapper<>();
//        wrapper.select("user.user_id", "user.user_name", "order.order_id", "order.order_name")
//                .leftJoin("order", "user.user_id = order.user_id")
//                .groupBy("user.user_id", "user.user_name", "order.order_id", "order.order_name");
//        List<UserOrderVO> list = userOrderMapper.selectList(wrapper);
    }

    @Test
    void getById_self_page(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",1);
        List<Map<String,Object>> byId_self_list = userDao.getById_self(map);
        System.out.println(byId_self_list);

    }
    @Test
    public void getList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        System.out.println(userDao.selectList(queryWrapper));
    }

    @Test
    public void updateByMyWrapper(){
        //条件构建器
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("name","Jone");

        // 修改后的对象
        User user = new User();
        user.setEmail("Test@email.com");

        userDao.updateUserByMyWrapper(queryWrapper,user);
    }

    @Test
    void test_page(){
        IPage page = new Page(1,2);
        QueryWrapper<UserOrderVO> queryWrapper = new QueryWrapper<UserOrderVO>();
        queryWrapper.eq("age",100);
        userDao.page(page,queryWrapper);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少条数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());

    }

    @Test
    void r1(){
        Map map =  new HashMap<String,Object>();
//        map.put("id",1);
//        map.put("age",100);
        IPage page = new Page(1,2);
        userDao.getID(page,map);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少条数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());
    }

    @Test
    void userToUserVO(){
        User user = new User();
        user.setId(1L);
        user.setName("chenyang");
        user.setGender(SexEnum.WOMAN);
        user.setList("123$&345");
        System.out.println(user.getList());
        UserConvertMapper userConvertMapper = Mappers.getMapper(UserConvertMapper.class);
        UserVO userVO = userConvertMapper.userToUserVO(user);
        System.out.println(userVO);
    }
}
