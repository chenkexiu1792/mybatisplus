package com.itheima.common.process.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Administrator
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends  Exception {
    private Integer code;

}
