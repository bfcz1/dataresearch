package com.me.dao;


import com.me.model.Item;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ResearchDao {

    int insert(Item item);
    List<Item> queryByKeyword(Item item);
    void delete(Item item);



}
