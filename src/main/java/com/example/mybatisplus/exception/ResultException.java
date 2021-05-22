package com.example.mybatisplus.exception;



import com.example.mybatisplus.enums.ResultExceptionEnum;
import lombok.Getter;

/**
 * @author
 * @create
 */
@Getter
public class ResultException extends RuntimeException {

    private Integer code;

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ResultException(ResultExceptionEnum enums) {
        super(enums.getMessage());
        this.code = enums.getCode();
    }
}
