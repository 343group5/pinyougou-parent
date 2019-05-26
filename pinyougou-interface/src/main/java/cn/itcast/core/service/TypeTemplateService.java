package cn.itcast.core.service;

import cn.itcast.core.pojo.template.TypeTemplate;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface TypeTemplateService {
    PageResult search(Integer page, Integer rows, TypeTemplate tt);

    void add(TypeTemplate tt);

    TypeTemplate findOne(Long id);

    void update(TypeTemplate tt);

    List<Map> findBySpecList(Long id);
<<<<<<< HEAD

    void updateStatus(Long []ids,String status);
=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
}
