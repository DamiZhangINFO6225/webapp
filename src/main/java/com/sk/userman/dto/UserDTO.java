package com.sk.userman.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @author: zsc
 * @create: 2023-01-29 22:29
 **/
@Data
@ApiModel(value = "修改实体类Update entity")
public class UserDTO {
    @Null(message = "用户id不可修改Id not modifiable")
    @ApiModelProperty(value = "id")
    private Integer id;

    @NotBlank(message = "姓不能为空Given Name cannot be empty")
    @ApiModelProperty(value = "姓Given name")
    private String firstName;


    @NotBlank(message = "名不能为空Surname cannot be empty")
    @ApiModelProperty(value = "名Surname")
    private String lastName;


    @NotBlank(message = "密码不能为空Password cannot be empty")
    @ApiModelProperty(value = "密码password")
    private String password;


    @Email
    @Null(message = "用户邮箱不可修改user email not modifiable")
    @ApiModelProperty(value = "邮箱Email")
    private String email;


    @Null(message = "用户创建时间不可修改Time of User Information created not modifiable")
    @ApiModelProperty(value = "创建时间Time Created")
    private Date accountCreated;

    /**
     *
     */
    @Null(message = "用户更新时间不可修改Time of User Information updated not modifiable")
    @ApiModelProperty(value = "更新时间Time Updated")
    private Date accountUpdate;

}
