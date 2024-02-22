package com.itheima.filter;
import com.alibaba.fastjson2.JSON;
import com.itheima.util.JwtUitls;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Herman
 * @Version 1.0
 */
public class AuthFilter implements Filter {

    private JwtUitls jwtUitls=new JwtUitls();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String,String> map=new HashMap<>();
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
//        if(requestURI!=null){
//            if(StringUtils.equalsIgnoreCase("/login",requestURI)){
//                filterChain.doFilter(servletRequest,servletResponse);
//                return;
//            }else{
//                String token = ((HttpServletRequest) servletRequest).getHeader("token");
//                if(StringUtils.isNotBlank(token)){
//                    //token验证结果
//                    int verify  = JwtUitls.verify(token,(HttpServletRequest) servletRequest);
//                    if(verify != 1){
//                        //验证失败
//                        if(verify == 2){
//                            map.put("500","token已过期");
//                        }else if(verify == 0){
//                            map.put("500","用户信息验证失败");
//                        }
//                    }else if(verify  == 1){
//                        //验证成功，放行
//                        filterChain.doFilter(servletRequest,servletResponse);
//                        return;
//                    }
//                }else {
//                    map.put("500","未携带token信息");
//                }
//            }
//        }
        String token = ((HttpServletRequest) servletRequest).getHeader("token");
        if(StringUtils.isNotBlank(token)){
            //验证成功，放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else{
            map.put("500","未携带token信息");
        }
        servletResponse.setContentType("application/json");
        servletResponse.setCharacterEncoding("utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.write(JSON.toJSONString(map));
        writer.flush();
        writer.close();
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
