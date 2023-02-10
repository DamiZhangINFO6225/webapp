package com.sk.userman.controller;

import com.sk.userman.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zsc
 * @create: 2023-02-10 15:09
 **/
@RequestMapping
@RestController
public class TestController {

    @GetMapping("healthz")
    public Result healthz(){
        return new Result().ok("运行成功Run in good");
    }
}
