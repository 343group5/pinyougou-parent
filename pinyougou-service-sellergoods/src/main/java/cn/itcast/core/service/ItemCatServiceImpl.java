package cn.itcast.core.service;

import cn.itcast.core.dao.item.ItemCatDao;
import cn.itcast.core.pojo.good.Goods;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.pojo.item.ItemCatQuery;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.List;

/**
 * 商品分类管理
 */
@Service
@Transactional
public class ItemCatServiceImpl implements  ItemCatService {

    @Autowired
    private ItemCatDao itemCatDao;
    @Autowired
    private RedisTemplate redisTemplate;


    //查询父ID为多少 的商品分类集合
    @Override
    public List<ItemCat> findByParentId(Long parentId) {

        //    1:查询Mysql中的商品分类结果集 保存到缓存中一份
        List<ItemCat> itemCats = findAll();//1197
        for (ItemCat itemCat : itemCats) {
            redisTemplate.boundHashOps("itemCat").put(itemCat.getName(),itemCat.getTypeId());
        }

        ItemCatQuery itemCatQuery = new ItemCatQuery();
        itemCatQuery.createCriteria().andParentIdEqualTo(parentId);
        return itemCatDao.selectByExample(itemCatQuery);
    }

    //查询一个商品分类
    @Override
    public ItemCat findOne(Long id) {
        return itemCatDao.selectByPrimaryKey(id);
    }

    //查询所有商品分类集合
    @Override
    public List<ItemCat> findAll() {
        return itemCatDao.selectByExample(null);
    }
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination topicPageAndSolrDestination;
    @Autowired
    private Destination queueSolrDeleteDestination;
    //开始审核
    @Override
    public void updateStatus(Long[] ids, String status) {
        ItemCat itemCat = new ItemCat();
        itemCat.setAuditStatus(status);
        for (Long id : ids) {
            System.out.println(id);
            itemCat.setId(id);
            //1:更改分类状态
            itemCatDao.updateByPrimaryKeySelective(itemCat);
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
}
