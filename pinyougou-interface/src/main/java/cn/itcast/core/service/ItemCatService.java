package cn.itcast.core.service;

import cn.itcast.core.pojo.item.ItemCat;

import java.util.List;

public interface ItemCatService {
    List<ItemCat> findByParentId(Long parentId);

    ItemCat findOne(Long id);

    List<ItemCat> findAll();
<<<<<<< HEAD
=======

    void updateStatus(Long[] ids, String status);
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
}
