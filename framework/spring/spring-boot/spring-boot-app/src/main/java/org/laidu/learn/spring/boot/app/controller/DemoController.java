package org.laidu.learn.spring.boot.app.controller;

import org.laidu.learn.spring.boot.app.dto.DemoDTO;
import org.laidu.learn.spring.boot.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

/**
 * demo
 * <p>
 * Created by tiancai.zang
 * on 2018-05-09 22:48.
 * @author laidu
 */
@Slf4j
@Timed
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DemoService demoServiceA;

    @PostMapping("/demo")
    public DemoDTO demo(@RequestBody DemoDTO demoDTO){
        demoDTO.setCreateDate(System.currentTimeMillis());
        return demoDTO;
    }

    @GetMapping("/hello")
    @Timed(extraTags = { "region", "us-east-1" })
    @Timed(value = "all.people", longTask = true)
    public String hello(){
//        demoServiceA.work();

        return "hello";
    }




}