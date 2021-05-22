package com.example.mybatisplus.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplus.bean.ResponseEnhanceAnnotation;
import com.example.mybatisplus.bean.ResponseResult;
import com.example.mybatisplus.exception.ResultException;
import com.example.mybatisplus.moudel.BuOrder;
import com.example.mybatisplus.service.BuOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医疗机构订单表 前端控制器
 * </p>
 *
 * @author weihua lan
 * @since 2021-05-20
 */
@RestController
@RequestMapping("/mybatisplus/buOrder")
@Slf4j
public class BuOrderController {
    @Autowired
    private BuOrderService buOrderService;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseResult save() {
        log.info("【插入一条记录】");
        try {
            boolean success = buOrderService.save();
            log.info("【插入一条记录】状态为---{}",success);
            return ResponseResult.success(success);
        } catch (ResultException e) {
            log.error("【插入一条记录失败】错误信息为：", e);
            return ResponseResult.error(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selectByMap", method = RequestMethod.GET)
    public ResponseResult selectByMap() {
        log.info("【查询记录】");
        try {
            List<BuOrder> list = buOrderService.selectByMap();
            log.info("【查询记录】数据为---{}",list);
            return ResponseResult.success(list);
        } catch (ResultException e) {
            log.error("【查询记录】错误信息为：", e);
            return ResponseResult.error(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public ResponseResult selectByPage() {
        log.info("【根据查询内容分页查询记录】");
        try {
            IPage<Map<String,String>> iPage = buOrderService.selectByPageOne();
            log.info("【根据查询内容分页查询记录】数据为---{}",iPage.getRecords());
            return ResponseResult.success(iPage);
        } catch (ResultException e) {
            log.error("【根据查询内容分页查询记录】错误信息为：", e);
            return ResponseResult.error(e);
        }
    }
}

