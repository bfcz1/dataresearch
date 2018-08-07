package com.me.service;

import com.github.pagehelper.PageInfo;
import com.me.dao.ResearchDao;
import com.me.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ResearchDao dao;


    @Override
    public int addItem(Item item) {

        int insert = dao.insert(item);
        return insert;

    }

    @Override
    public List<Item> findAllUser(Item item) {

        List<Item> itemList = dao.queryByKeyword(item);


        return itemList;
    }


}
