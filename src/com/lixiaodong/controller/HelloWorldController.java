package com.lixiaodong.controller;

import com.alibaba.fastjson.JSON;
import com.lixiaodong.controller.service.TestService;
import com.lixiaodong.service.TestServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller("helloWorldController")
@RequestMapping("lemon")
public class HelloWorldController {
    @Autowired
    TestService testService;
    @Autowired
    TestServiceNew testServiceNew;


    public static void main(String[] args) {
        HelloWorldController helloWorldController = new HelloWorldController();
//        helloWorldController.hello();

        Map map = new HashMap<>();
        map.put("HelloWorldController", "lemon/helloworld222");
        map.put("HelloWorldController", "lemon/helloworld5555");
//        /helloworld222

    }

    @RequestMapping("/helloworld222")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", JSON.toJSONString(testServiceNew.getName()));
        modelAndView.addObject("message2", "2222222");
        modelAndView.setViewName("helloworld");
        return modelAndView;
    }

    @RequestMapping("/helloworld2225")
    public String hello222(ModelAndView model) {
        return "helloworld";
    }

    @RequestMapping("/helloworld5555")
    public String hello1() {
        return "helloworld";
    }
}
