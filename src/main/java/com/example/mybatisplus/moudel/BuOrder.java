package com.example.mybatisplus.moudel;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 医疗机构订单表
 * </p>
 *
 * @author weihua lan
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bu_order")
@ApiModel(value="BuOrder对象", description="医疗机构订单表")
public class BuOrder extends Model<BuOrder> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID")
    @TableId("order_id")
    private Long orderId;

    @ApiModelProperty(value = "病人ID（来源于ba_persons表）")
    @TableField("person_id")
    private Long personId;

    @ApiModelProperty(value = "交易流水号")
    @TableField("trade_id")
    private Long tradeId;

    @ApiModelProperty(value = "机构编码（冗余字段，方便查询）")
    @TableField("org_code")
    private String orgCode;

    @ApiModelProperty(value = "0挂号、1门诊、2住院押金、3预约取号")
    @TableField("order_type")
    private String orderType;

    @ApiModelProperty(value = "订单状态 0-未交易 1-订单挂起 2-订单成功 3-订单失败 4-订单取消5-订单关闭")
    @TableField("order_state")
    private String orderState;

    @ApiModelProperty(value = "总费用")
    @TableField("feeall")
    private Double feeall;

    @ApiModelProperty(value = "创建时间戳")
    @TableField(fill = FieldFill.INSERT)
    private Date ctstamp;

    @ApiModelProperty(value = "更新时间戳")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date utstamp;

    @ApiModelProperty(value = "使用标志（1-启用0-停用）")
    @TableField("useflag")
    private Integer useflag;

    @ApiModelProperty(value = "his流水号")
    @TableField("his_tradeno")
    private String hisTradeno;

    @ApiModelProperty(value = "自助机Id")
    @TableField("device_id")
    private String deviceId;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
