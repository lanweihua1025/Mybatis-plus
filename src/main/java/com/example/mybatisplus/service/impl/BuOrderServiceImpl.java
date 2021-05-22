package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.moudel.BuOrder;
import com.example.mybatisplus.mapper.BuOrderMapper;
import com.example.mybatisplus.service.BuOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医疗机构订单表 服务实现类
 * </p>
 *
 * @author weihua lan
 * @since 2021-05-20
 */
@Service
public class BuOrderServiceImpl extends ServiceImpl<BuOrderMapper, BuOrder> implements BuOrderService {
    @Autowired
    private BuOrderMapper buOrderMapper;

    @Autowired
    private BuOrderService buOrderService;


    /**
     * Service CRUD 接口
     * 说明:
     * 通用 Service CRUD 封装IService (opens new window)接口，进一步封装 CRUD 采用 get 查询单行 remove 删除 list 查询集合 page 分页 前缀命名方式区分 Mapper 层避免混淆，
     * 泛型 T 为任意实体对象
     * 建议如果存在自定义通用 Service 方法的可能，请创建自己的 IBaseService 继承 Mybatis-Plus 提供的基类
     * 对象 Wrapper 为 条件构造器
     */


    /**
     * Mapper CRUD 接口
     * 说明:
     *
     * 通用 CRUD 封装BaseMapper (opens new window)接口，为 Mybatis-Plus 启动时自动解析实体表关系映射转换为 Mybatis 内部对象注入容器
     * 泛型 T 为任意实体对象
     * 参数 Serializable 为任意类型主键 Mybatis-Plus 不推荐使用复合主键约定每一张表都有自己的唯一 id 主键
     * 对象 Wrapper 为 条件构造器
     */
    @Override
    public boolean save() {
        BuOrder buOrder = new BuOrder();
        buOrder.setOrgCode("09151001");
        buOrder.setOrderState("0");
        buOrder.setOrderType("0");
//        buOrder.setCtstamp(new Date());
        buOrder.setFeeall(0.00);
        buOrder.setHisTradeno("123456");
        return buOrderService.save(buOrder);
//        buOrderMapper.insert(buOrder);
//        return true;
    }

    @Override
    public List<BuOrder> selectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("order_id","1395941574678929409");
        List<BuOrder> buOrderList = buOrderMapper.selectByMap(map);
        return buOrderList;
    }

    @Override
    public IPage<Map<String, String>> selectByPageOne() {
        IPage<Map<String,String>> page = new Page<>(1,2);
        return buOrderMapper.selectByPageOne(page,"09151001");
    }

}
