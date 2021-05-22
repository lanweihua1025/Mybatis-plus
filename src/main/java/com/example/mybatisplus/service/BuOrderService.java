package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplus.moudel.BuOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医疗机构订单表 服务类
 * </p>
 *
 * @author weihua lan
 * @since 2021-05-20
 */
public interface BuOrderService extends IService<BuOrder> {

    // 插入一条记录（选择字段，策略插入）
    boolean save();


    List<BuOrder> selectByMap();

    //分页查询Ipage的使用
    IPage<Map<String,String>> selectByPageOne();

}
