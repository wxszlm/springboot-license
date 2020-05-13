package com.yxf.license.controller;

import com.yxf.license.interceptor.GxLicense;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>证书验证测试</p>
 *
 * @author yixiangfeng
 * @blob http://www.wxsstudy.top
 * @date 2:21 2020-05-13
 */
@CrossOrigin
@RestController
public class HelloController {

    @GxLicense
    @GetMapping("/hello")
    public String sayHello(){
        return "hello license !";
    }

}
