package com.me.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResearchController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){

        return "success";
    }




}
