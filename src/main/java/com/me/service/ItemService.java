package com.me.service;

import com.github.pagehelper.PageInfo;
import com.me.model.Item;

import java.util.List;

public interface ItemService {

    int addItem(Item item);
    List<Item> findAllUser(Item item);
    void delete(Item item);
    PageInfo<Item> findAllUser(int pageNum, int pageSize);

}
