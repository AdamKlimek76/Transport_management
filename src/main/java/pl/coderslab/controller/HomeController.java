package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class HomeController {


    @GetMapping("")
    String showIndex() {
        return "index";
    }

    @GetMapping("/login")
    @ResponseBody
    String filterTest(){
        return "login";
    }


}