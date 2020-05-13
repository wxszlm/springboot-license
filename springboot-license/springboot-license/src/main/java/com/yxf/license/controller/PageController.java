package com.yxf.license.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>WebPage页面模板映射</p>
 *
 * @author yixiangfeng
 * @blob http://www.wxsstudy.top
 * @date 2:21 2020-05-13
 */
@Controller
public class PageController {

    @GetMapping("/{page}")
    public String getLogin(@PathVariable(name = "page") String page){
        return page+".html";
    }

}
