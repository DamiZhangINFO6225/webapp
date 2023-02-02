package com.sk.userman.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 登录实体
 *
 * @author: zdm
 * @create: 2023-01-29 20:25
 **/
@Data
@ApiModel(value = "登录接收实体Login reception body")
public class LoginDTO {
    @ApiModelProperty(value = "邮箱Email")
    @Email
    private String email;

    @NotBlank(message = "密码不能为空No empty input")
    @ApiModelProperty(value = "密码Password")
    private String password;
}
