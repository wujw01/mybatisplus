package com.runrunfast.currency.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 邹智敏
 * @since 2018-11-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Features implements Serializable {

    @ApiModelProperty(value = "编号")
    @NotBlank(message = "编号 不允许为空")
    @Length(min = 1, max = 40, message = "编号 长度必须在 {min} - {max} 之间")
    private String id;

    @ApiModelProperty(value = "身高")
    @Digits(integer = 3,fraction = 2)
    private Float height;

    @ApiModelProperty(value = "胖或瘦")
    @NotBlank(message = "胖或瘦 不允许为空")
    @Length(min = 1, max = 2, message = "胖或瘦 长度必须在 {min} - {max} 之间")
    private String fatOrThin;

}
