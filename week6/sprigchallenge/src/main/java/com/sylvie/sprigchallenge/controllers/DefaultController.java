package com.sylvie.sprigchallenge.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    private static Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Value("${syl.test}")
    private String chal1;

    @GetMapping("/")
    public String text() {
        return "Testing";
    }

    @GetMapping("/chal1")
    public String chal1() {
        logger.info("Somebody hit the chal1 endpoint");
        return chal1;
    }
}
