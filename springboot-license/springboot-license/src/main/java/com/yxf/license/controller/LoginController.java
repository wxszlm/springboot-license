package com.yxf.license.controller;

import com.yxf.license.interceptor.GxLicense;
import com.yxf.license.core.User;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>用户登录</p>
 *
 * @author yixiangfeng
 * @blob http://www.wxsstudy.top
 * @date 2:21 2020-05-13
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    @GxLicense
    @PostMapping("/login")
    public Map<String, Object> checkLicense(@RequestBody User user){

        Map<String,Object> result = new HashMap<>();
        if("appleyk".equals(user.getUserName()) && "123456a".equals(user.getPassWord())){
            result.put("code",200);
        }else{
            result.put("code",500);
            result.put("msg","用户名或密码不对！");
        }
        return result ;

    }

}
