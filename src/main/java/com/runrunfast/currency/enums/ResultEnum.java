package com.runrunfast.currency.enums;

import lombok.Getter;

/**
 * @Author: james
 * @Description: 同一返回结果
 * @Date: created in 10:38 2018/8/30
 * @Modified By:
 **/
@Getter
public enum ResultEnum {

    /*--------------*/

    SUCCESS(1, "成功"),

    FILE(-1,"失败"),

    ADD(10001,"新增"),

    UPDATE(10002,"修改"),

    DELETE(10003,"删除"),

    SELECT(10004,"查询"),

    exist(10005,"已存在")
            ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
