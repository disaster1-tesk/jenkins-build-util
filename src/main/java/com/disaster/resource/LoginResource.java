package com.disaster.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginResource {
    @GetMapping("/")
    public String hello() {
        return "index"; // 要導入的html
    }
}
