package com.runrunfast.currency.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
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
@ToString
public class User implements Serializable {

    @ApiModelProperty(value = "主键ID",example = "100")
    private Long id;

    @ApiModelProperty(value = "姓名",required = true,example = "james")
    @NotBlank(message = "姓名 不允许为空")
    @Length(min = 1, max = 20, message = "姓名 长度必须在 {min} - {max} 之间")
    private String name;

    @ApiModelProperty(value = "年龄",required = true,example = "22")
    private Integer age;

    @ApiModelProperty(value = "邮箱",required = true,example = "adgjlakd@154")
    @Email(message = "邮箱 不允许为空")
    private String email;


}
