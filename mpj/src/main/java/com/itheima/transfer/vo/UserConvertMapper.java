package com.itheima.transfer.vo;

import com.itheima.domain.User;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Herman
 * @Version 1.0
 */
//注意此mapper是 mapstruct 下的
//@Mapper(componentModel = "spring")
public interface UserConvertMapper {

    @Mappings({
            @Mapping(source = "name" , target = "vo_name"),
            @Mapping(target = "gender",ignore = true),
            @Mapping(target = "dis",ignore = true)
    })
    UserVO userToUserVO(User user);
    /**
     * 当需要String转List时，MapStruct会自动调用str2List。
     * @param src
     */
    // str转list
    default List<String> str2List(String src){
        //暂时省略了参数判断
        String[] split = src.split("\\$\\&");
        List<String> result = Arrays.asList(split);
        return result;
    }

    /**
     * 当需要list转string时，会自动调用list2Str
     * @param src
     */
    // list转str
    default String list2Str(List<String> src){
        //不引入其他包，直接判断
        if (src ==null ||src.equals("")) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        src.stream().forEach(item -> sb.append(item).append("&$"));
        return sb.toString();
    }
}
