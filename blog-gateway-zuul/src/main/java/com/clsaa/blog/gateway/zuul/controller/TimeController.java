package com.clsaa.blog.gateway.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Created by eggyer on 2017/3/19.
 */
@RestController
public class TimeController {
    @GetMapping("/timestamp")
    public Timestamp getTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
