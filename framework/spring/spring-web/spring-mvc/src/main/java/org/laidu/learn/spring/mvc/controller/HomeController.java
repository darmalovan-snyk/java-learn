package org.laidu.learn.spring.mvc.controller;

import java.util.Random;

import org.laidu.learn.spring.mvc.model.Response;
import org.laidu.learn.spring.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * home
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 13:53.
 *
 * @author tiancai.zang
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HomeController extends BaseController{

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public Response<String> hello() throws InterruptedException {

        log.info("active Thread count: {}", Thread.activeCount());

        return Response.ok(helloService.sayHello());
    }

    @GetMapping("/sleep")
    public Integer sleep(@RequestParam("sec") int secends ) throws InterruptedException {

        Thread.sleep(secends * 1000);
        return secends;
    }

    @GetMapping("/sleepRandom")
    public Integer sleepRandom(@RequestParam("sec") int secends ) throws InterruptedException {

        Thread.sleep(new Random(100).nextInt(secends) * 1000);
        return secends;
    }


}