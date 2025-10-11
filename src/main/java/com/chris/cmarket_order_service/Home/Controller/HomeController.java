package com.chris.cmarket_order_service.Home.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "<a href=\"/products\">Go to Products Endpoint</a>";
    }
}
