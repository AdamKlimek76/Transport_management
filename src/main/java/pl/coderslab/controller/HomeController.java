package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {


    @GetMapping("")
    String showIndex() {
        return "index";
    }


    @GetMapping("/user/data")
    String showData() {
        return "transport_data";
    }

    @GetMapping("/user/order")
    String showOrders() {
        return "transport_orders";
    }


}