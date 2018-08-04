package com.me.service;

import com.me.model.Item;
import org.springframework.stereotype.Service;

@Service(value = "ItemService")
public class ItemServiceImpl implements ItemService {
    @Override
    public int addItem(Item item) {
        return 0;
    }
}
