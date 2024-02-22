package com.itheima.controller;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.User;
import com.itheima.feign.ProductFeignService;
import com.itheima.feign.StockFeignService;
import com.itheima.secform.annotation.Log;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.annotation.CheckForNull;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired(required=false)
    StockFeignService stockFeignService;
    @Autowired(required=false)
    ProductFeignService productFeignService;

//    @Autowired
//    RocketMQTemplate rocketMQTemplate;

    @Autowired
    IUserService iUserService;

    @RequestMapping("/sendMsg")
    public String sendMsg(HttpServletRequest request) {
        String user_id = request.getParameter("user_id");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",user_id);
//      rocketMQTemplate.convertAndSend("simple-topic", "Hi");
        return JSON.toJSONString(iUserService.getById_self(map));
    }

//    @RequestMapping("/list")
//    public String list() throws InterruptedException {
//        String reduceResult = stockFeignService.reduce();
//        String productResult = productFeignService.get(1);
//        System.out.println(reduceResult);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put(reduceResult,productResult);
//        return JSON.toJSONString(map);
//    }
//    @RequestMapping("/selectUserList2")
//    public String selectUserList2(){
//       return  JSON.toJSONString(iUserService.selectUserList2());
//    }

    /**
     * 用mybatisplus 自带的功能 实现单表分页
//     * @param pageNo
//     * @param pageSize
//     * @param model
//     * @param updatetimeSpace
//     * @param aboutusHomepage
     * @return
     */
    @RequestMapping("/myPage")
//    public String index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
//                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
//                        Model model, String updatetimeSpace, User user) {
    public String index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,HttpServletRequest request) {
        Page<User> page = new Page<User>(pageNo, pageSize);
        //接收参数 测试用省去验证
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        //用QueryWrapper做条件查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(username)) {
            queryWrapper = queryWrapper.like("name",username);
        }
        if(!ObjectUtils.isEmpty(age)) {
            queryWrapper = queryWrapper.eq("age",age);
        }
        //使用MybatisPlus自带的page方法做有条件的分页查询
        IPage<User> pageInfo = iUserService.page(page, queryWrapper);
        //model.addAttribute("updatetimeSpace", updatetimeSpace);
        //model.addAttribute("searchInfo", aboutusHomepage);
        //model.addAttribute("pageInfo", new PageInfo(pageInfo));

        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少条数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());
        return "list";
    }
    @GetMapping("/query")
    public String queryUserInfo(@NotNull(message = "你搞事，是不是sdfdsf？") String name,
                                @Max(value = 100, message = "请输入数字,最大值100") Integer age) {
        System.out.println("是啥啊");
        return name;
    }
}
