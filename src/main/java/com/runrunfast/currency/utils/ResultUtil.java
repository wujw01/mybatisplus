package com.runrunfast.currency.utils;

import com.runrunfast.currency.entity.Result;
import com.runrunfast.currency.enums.ResultEnum;

/**
 * @Author: james
 * @Description: This is description
 * @Date: created in 10:44 2018/8/30
 * @Modified By:
 **/
public class ResultUtil {

    /**
     * 用途：例如分页查询，返回格式要有data
     * @param object
     * @return
     */
    public static Result success(Object object,String msg) {
        Result<Object> result = new Result<>();
        result.setData(object);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(msg+ResultEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 用途：新增、删除、修改无须返回data
     * @param resultEnum
     * @return
     */
    public static Result success(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMessage());
        return result;
    }

    /**
     * 用途：同一新增、删除、修改错误提示
     * @return
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.FILE.getCode());
        result.setMsg(msg+ResultEnum.FILE.getMessage());
        return result;
    }

    /**
     * 用途：新增、删除、修改错误提示，但是这个提示要自己自定义哦，不能再枚举中进行选择
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
