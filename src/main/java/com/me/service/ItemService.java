package com.me.service;

import com.me.model.Item;

import java.util.List;

public interface ItemService {

    int addItem(Item item);
    List<Item> findAllUser(Item item);

}
