package com.runrunfast.currency.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: james
 * @Description: This is description
 * @Date: created in 10:40 2018/8/30
 * @Modified By:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {
    /** 错误码 */
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /** 提示信息 */
    @ApiModelProperty(value = "返回信息")
    private String msg;

    /** 具体内容 */
    @ApiModelProperty(value = "返回数据")
    private T data;
}
