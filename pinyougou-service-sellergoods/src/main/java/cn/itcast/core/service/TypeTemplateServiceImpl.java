package cn.itcast.core.service;

import cn.itcast.core.dao.specification.SpecificationOptionDao;
import cn.itcast.core.dao.template.TypeTemplateDao;
<<<<<<< HEAD
import cn.itcast.core.pojo.good.Goods;
=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
import cn.itcast.core.pojo.specification.SpecificationOption;
import cn.itcast.core.pojo.specification.SpecificationOptionQuery;
import cn.itcast.core.pojo.template.TypeTemplate;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
<<<<<<< HEAD
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
=======
import org.springframework.transaction.annotation.Transactional;

>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
import java.util.List;
import java.util.Map;

/**
 * 模板管理
 */
@Service
@Transactional
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TypeTemplateDao typeTemplateDao;
    @Autowired
    private SpecificationOptionDao specificationOptionDao;
    @Autowired
    private RedisTemplate redisTemplate;
<<<<<<< HEAD
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination topicPageAndSolrDestination;
    @Autowired
    private Destination queueSolrDeleteDestination;

=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a

    @Override
    public PageResult search(Integer page, Integer rows, TypeTemplate tt) {

        List<TypeTemplate> typeTemplates = typeTemplateDao.selectByExample(null);
        for (TypeTemplate typeTemplate : typeTemplates) {

//            3:获取模板对象中品牌的属性 及规格属性
//            String s = [{"id":35,"text":"牛栏山"},{"id":36,"text":"剑南春"},{"id":39,"text":"口子窑"}]
//            4:将上面的品牌的json格式字符串转成品牌列表
//            5:将上面的规格的json格式字符串转成规格列表

            List<Map> brandList = JSON.parseArray(typeTemplate.getBrandIds(), Map.class);

            //缓存品牌列表
            redisTemplate.boundHashOps("brandList").put(typeTemplate.getId(),brandList);

            //获取List<Map
            List<Map> specList = findBySpecList(typeTemplate.getId());

            redisTemplate.boundHashOps("specList").put(typeTemplate.getId(),specList);
        }




        PageHelper.startPage(page, rows);

        //分页
        //排序
        PageHelper.orderBy("id desc");


        Page<TypeTemplate> p = (Page<TypeTemplate>) typeTemplateDao.selectByExample(null);

        return new PageResult(p.getTotal(), p.getResult());
    }

    //添加
    @Override
    public void add(TypeTemplate tt) {


        typeTemplateDao.insertSelective(tt);
    }

    //查询一个模板对象
    @Override
    public TypeTemplate findOne(Long id) {
        return typeTemplateDao.selectByPrimaryKey(id);
    }

    //修改
    @Override
    public void update(TypeTemplate tt) {
        typeTemplateDao.updateByPrimaryKeySelective(tt);

    }

    //查询模板对象  中规格集合  返回值 List<Map>
    @Override
    public List<Map> findBySpecList(Long id) {
//        1:入参:模板对象的ID
        TypeTemplate typeTemplate = typeTemplateDao.selectByPrimaryKey(id);
//        2:查询:模板对象  从对象中获取出 String  specIds   = [{"id":27,"text":"网络"},{"id":32,"text":"机身内存"}]
        String specIds = typeTemplate.getSpecIds();


//        3:json格式转换   List<Map>  listMap = JSON.parseArray(specIds,Map.class)
        List<Map> listMap = JSON.parseArray(specIds, Map.class);
        for (Map map : listMap) {
//        4:根据上面的27  规格选项表的外键 查询集合

            SpecificationOptionQuery query = new SpecificationOptionQuery();
            // 类型转换异常   Object --> 基本类型(整数,String Boolean)    特殊类型  长整
            query.createCriteria().andSpecIdEqualTo(Long.parseLong(String.valueOf(map.get("id"))));
            //query.createCriteria().andSpecIdEqualTo((long)(Integer)(map.get("id")));
            List<SpecificationOption> specificationOptions = specificationOptionDao.selectByExample(query);//健壮
//        5:查询到的集合设置到上面的Map中
            map.put("options",specificationOptions);
        }
/*        Map1
        put(id,27)
        put(text,网络)
        put(options,List)*/
        return listMap;
    }
<<<<<<< HEAD


    //开始审核
    @Override
    public void updateStatus(Long[] ids, String status) {
        TypeTemplate typeTemplate=new TypeTemplate();
        typeTemplate.setAuditStatus(status);
        for (Long id : ids) {
            typeTemplate.setId(id);
            //1:更改商品状态
            typeTemplateDao.updateByPrimaryKeySelective(typeTemplate);
            //只有在审核通过的时候才会执行下面处理
            if("1".equals(status)){

                //发消息
                jmsTemplate.send(topicPageAndSolrDestination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(String.valueOf(id));
                    }
                });

            }

        }

    }


=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
}
