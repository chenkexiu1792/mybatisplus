package com.itheima.ext;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * 扩展baseMapper中 getAll
 *
 * @param <T>
 */
public interface MyBaseMapper<T>  extends BaseMapper<T> {
    public List<T> getAll();
}
