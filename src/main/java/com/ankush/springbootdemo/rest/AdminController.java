package com.ankush.springbootdemo.rest;


import com.ankush.springbootdemo.model.PingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/v1")
public class AdminController {

    @GetMapping("ping")
    public PingResponse ping() {
        return new PingResponse("PONG");
    }
}