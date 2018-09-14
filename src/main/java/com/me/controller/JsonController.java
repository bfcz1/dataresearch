package com.me.controller;

import com.me.model.Item;
import com.me.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class JsonController {
    @Autowired
    private ItemServiceImpl itemService;

    @GetMapping(value = "/delete")
    public String research(@RequestParam("id") int id) {

        try {
            Item item = new Item();
            item.setId(id);
            itemService.delete(item);
        } catch (Exception e) {
            return "failed";
        }
        return "successed";

    }

    @PostMapping(value = "/batchDelete")
    public String research(@RequestParam(value = "delitems") String delitems) {

        final String[] dataArray = delitems.split(",");
        for (String idStr : dataArray) {
            if (idStr.matches("[0-9]+")) {
                final int id = Integer.parseInt(idStr);
                Item item = new Item();
                item.setId(id);
                try {
                    itemService.delete(item);
                } catch (Exception e) {
                    return "failed";
                }
            } else {
                return "failed";
            }

        }
        return "successed";

    }


}
