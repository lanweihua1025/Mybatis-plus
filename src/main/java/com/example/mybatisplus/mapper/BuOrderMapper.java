package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.moudel.BuOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 医疗机构订单表 Mapper 接口
 * </p>
 *
 * @author weihua lan
 * @since 2021-05-20
 */
@Mapper
public interface BuOrderMapper extends BaseMapper<BuOrder> {

    IPage<Map<String,String>> selectByPageOne(IPage<Map<String,String>> page, @Param("orgCode") String orgCode);

}
