package com.sk.userman.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @author: zdm
 * @create: 2023-01-29 22:29
 **/
@Data
@ApiModel(value = "修改实体类Update body class")
public class UserDTO {
    @Null(message = "用户id不可修改User ID cannot be updated")
    @ApiModelProperty(value = "id")
    private Integer id;

    @NotBlank(message = "姓不能为空No empty lastname")
    @ApiModelProperty(value = "姓Lastname")
    private String firstName;


    @NotBlank(message = "名不能为空No empty firstname")
    @ApiModelProperty(value = "名Firstname")
    private String lastName;


    @NotBlank(message = "密码不能为空No empty Pwd")
    @ApiModelProperty(value = "密码Pwd")
    private String password;


    @Email
    @Null(message = "用户邮箱不可修改Failed to update email")
    @ApiModelProperty(value = "邮箱Email")
    private String email;


    @Null(message = "用户创建时间不可修改Fail to update time  created")
    @ApiModelProperty(value = "创建时间Time created")
    private Date accountCreated;

    /**
     *
     */
    @Null(message = "用户更新时间不可修改Fail to update time updated")
    @ApiModelProperty(value = "更新时间Time updated")
    private Date accountUpdate;

}
