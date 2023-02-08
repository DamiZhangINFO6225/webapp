package com.sk.userman.controller;

import com.sk.userman.domain.User;
import com.sk.userman.dto.LoginDTO;
import com.sk.userman.dto.UserDTO;
import com.sk.userman.service.UserService;
import com.sk.userman.utils.BaseContext;
import com.sk.userman.utils.Result;
import com.sk.userman.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**

 **/
@RequestMapping("/userman")
@RestController
@Api(tags="用户管理User Administrator")
public class UserController {

    /**
     *
     * controller  -> service -> dao/mapper
     *
     */




    @Autowired
    private UserService userService;

    @ApiOperation("登录Login")
    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody LoginDTO loginDTO){
        String token = userService.login(loginDTO);
        Result<String> stringResult = new Result<>();
        stringResult.setResult(token);
        return stringResult;
    }

    @ApiOperation("注册Register")
    @PostMapping("/register")
    public Result register( @Validated @RequestBody User user) throws Exception {
        userService.register(user);
        return new Result<>().ok("注册成功Success");
    }

    @ApiOperation(value = "获取当前用户信息 Accessing User Information",response = UserVO.class)
    @GetMapping("/info")
    public Result info(@AuthenticationPrincipal org.springframework.security.core.userdetails.User loginedUser){

        UserVO info = userService.info(BaseContext.get());
        return new Result<>().ok(info);
    }

    @ApiOperation("修改当前用户信息Updating User Information")
    @PutMapping("/info")
    public Result updateInfo(@AuthenticationPrincipal org.springframework.security.core.userdetails.User loginedUser,@Validated @RequestBody UserDTO userDTO) throws Exception {
        userDTO.setEmail(BaseContext.get());
        userService.updateInfo(userDTO);
        return new Result<>().ok("更新成功Updating Successfully ");
    }

}
