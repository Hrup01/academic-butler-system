package com.hrup.academicbutlersystem.exception;


import com.hrup.academicbutlersystem.dto.Result;

/**
 * 自定义业务异常类，继承自RuntimeException。
 * 用于在业务逻辑中抛出带有特定错误码和错误信息的异常。
 */
public class BusinessException extends RuntimeException{
    private Integer code;//错误码

    /**
     * 构造方法，使用默认的错误码(Result.PARAM_ERROR)创建业务异常。
     *
     * @param message 异常的错误信息
     */
    public BusinessException(String message){
        super(message);
        this.code = Result.PARAM_ERROR;
    }
    /**
     * 构造方法，使用指定的错误码和错误信息创建业务异常。
     *
     * @param code 异常对应的错误码
     * @param message 异常的错误信息
     */
    public BusinessException(Integer code, String message){
        super(message);
        this.code = code;
    }
    /**
     * 获取异常的错误码。
     *
     * @return 异常对应的错误码
     */
    public Integer getCode(){
        return code;
    }
}
