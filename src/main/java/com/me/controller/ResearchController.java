package com.me.controller;

import com.me.model.Item;
import com.me.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ResearchController {
    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping("/index1")
    @ResponseBody
    public String index1() {

        Item item = new Item();
        item.setCompany("123");
        List<Item> itemList = itemService.findAllUser(item);
        for (Item itemTemp : itemList) {
            System.out.println(itemTemp);
        }
        System.out.println(itemList.size());


        return "success";
    }

    @GetMapping(value = "/index")
    public String index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        //跳转到 templates 目录下的 index.html
        return "index";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        System.out.println("contentType:"+contentType+",originalFilename"+originalFilename);
        return "success";
    }


}
