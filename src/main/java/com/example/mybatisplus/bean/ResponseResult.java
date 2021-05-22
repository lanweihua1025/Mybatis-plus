package com.example.mybatisplus.bean;



import com.example.mybatisplus.enums.ResultExceptionEnum;
import com.example.mybatisplus.exception.ResultException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult {

    private Integer code;

    private String msg;

    private Object data;

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setData(null);
        result.setMsg("成功");
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setData(data);
        result.setMsg("成功");
        return result;
    }

    public static ResponseResult error(ResultExceptionEnum resultEnum) {
        ResponseResult result = new ResponseResult();
        result.setCode(resultEnum.getCode());
        result.setData(null);
        result.setMsg(resultEnum.getMessage());
        return result;
    }

    public static ResponseResult error(ResultException exception) {
        ResponseResult result = new ResponseResult();
        result.setCode(exception.getCode());
        result.setData(null);
        result.setMsg(exception.getMessage());
        return result;
    }

    public static ResponseResult error(Exception exception) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResultExceptionEnum.SYSTEM_ERR.getCode());
        result.setData((Object) exception);
        result.setMsg(ResultExceptionEnum.SYSTEM_ERR.getMessage());
        return result;
    }

    public static ResponseResult errorExp(Object exception) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResultExceptionEnum.SYSTEM_ERR.getCode());
        result.setData(exception);
        result.setMsg(ResultExceptionEnum.SYSTEM_ERR.getMessage());
        return result;
    }

    public static ResponseResult error(Integer code, String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult error() {
        ResponseResult result = new ResponseResult();
        result.setCode(ResultExceptionEnum.SYSTEM_ERR.getCode());
        result.setData(null);
        result.setMsg(ResultExceptionEnum.SYSTEM_ERR.getMessage());
        return result;
    }

    public static ResponseResult error(String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResultExceptionEnum.SYSTEM_ERR.getCode());
        result.setData(null);
        result.setMsg(msg);
        return result;
    }
}
