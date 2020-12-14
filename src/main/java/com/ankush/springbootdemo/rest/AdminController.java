package com.ankush.springbootdemo.rest;

import com.ankush.springbootdemo.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/v1")
public class AdminController {

    @GetMapping("ping")
    public PingResponse ping() {
        return new PingResponse("PONG");
    }
}