package com.memorynotfound.spring.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/showdealers")
    public String showDealers() {
        return "user/dealers";
    }

    @GetMapping("/sellItem")
    public String sellItem() {
        return "user/sellItem";
    }
}
