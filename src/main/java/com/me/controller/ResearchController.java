package com.me.controller;

import com.me.model.Item;
import com.me.service.ItemServiceImpl;
import com.me.util.ExcelUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
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
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("state", 1);
        //跳转到 templates 目录下的 index.html
        return view;
    }

    @PostMapping(value = "/upload")
        public ModelAndView upload(@RequestParam("file") MultipartFile[] fileArray,
                               HttpServletRequest request) throws IOException {
        for (MultipartFile file : fileArray) {

            final InputStream inputStream = file.getInputStream();
            List<Item> itemList = null;
            try {
                itemList = ExcelUtils.readeExcel2List(inputStream);
            } catch (Exception e) {
                ModelAndView view = new ModelAndView("index");
                view.addObject("state", "uploadFail");
                return view;
            }
            for (Item item: itemList) {

                try {
                    itemService.addItem(item);
                } catch (Exception e) {
                    ModelAndView view = new ModelAndView("index");
                    view.addObject("state", "analysisFail");
                    return view;
                }

            }

        }
        ModelAndView view = new ModelAndView("index");
        view.addObject("state", "uploadSuccess");
        return view;
    }

    @GetMapping(value = "/research")
    public ModelAndView research(@RequestParam("keyword") String keyword) {

        Item item = new Item();
        item.setCompany(keyword);
        List<Item> itemList = itemService.findAllUser(item);
        LinkedHashMap<Integer, Item> dataMap = new LinkedHashMap<Integer, Item>();
        int i = 0;
        for (Item itemTemp : itemList) {
            i++;
            dataMap.put(i, itemTemp);
        }
        ModelAndView view = new ModelAndView("research");
        view.addObject("data", dataMap);
        return view;
    }


}
