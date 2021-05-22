package com.example.mybatisplus.enums;

import lombok.Getter;

@Getter
public enum ResultExceptionEnum {

    ARGS_ERR(400, "参数错误"),
    SYSTEM_ERR(500, "系统错误"),
    OBJECT_NOT_EXIST(100, "操作对象不存在"),
    VERSION_REPETITION(101, "版本号重复"),
    STATUS_NOT_CHANGE(102, "修改状态未变化"),
    OBJECT_IS_EXIST(103, "数据已存在"),
    DATA_CAST_JSON_FAIL(104,"his返回数据转换json异常"),
    HIS_ERROR(105,"his接口返回异常"),
    ;


    private Integer code;

    private String message;

    ResultExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
