package cn.itcast.core.controller;

import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
<<<<<<< HEAD
=======
import entity.Result;
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类管理
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {


    @Reference
    private ItemCatService itemCatService;

    //根据父Id 查询商品分类集合
    @RequestMapping("/findByParentId")
    public List<ItemCat> findByParentId(Long parentId){
        return itemCatService.findByParentId(parentId);
    }

    //查询所有
    @RequestMapping("/findAll")
    public List<ItemCat> findAll(){
        return itemCatService.findAll();
    }
<<<<<<< HEAD
=======

    //开始审核
    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids, String status){

        try {
            itemCatService.updateStatus(ids,status);
            return new Result(true,"审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"审核失败");
        }

    }
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
}
