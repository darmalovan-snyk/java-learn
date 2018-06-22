package org.laidu.learn.spring.aop.annotation.processor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.laidu.learn.spring.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MethodMonitorProcessorTest {

    @Autowired
    private UserService userService;

    @Test
    void logExecutionTime() {

        userService.addUser("xiaoming");
    }
}