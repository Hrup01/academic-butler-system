package com.hrup.academicbutlersystem.exception;

import com.hrup.academicbutlersystem.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 全局异常处理控制器，用于捕获和处理应用程序中的异常
 *
 * 使用@RestControllerAdvice标注，表示这是一个全局异常处理类
 * 可以集中处理应用程序中抛出的各种异常
 */
@RestControllerAdvice
public class GLobalExceptionHandler {
    /**
     * 处理业务异常(BusinessException)
     *
     * @param e 捕获到的业务异常对象，包含异常代码和消息
     * @return Result<Void> 返回给前端的错误结果，包含异常代码和消息
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e){
        return Result.error(e.getCode(), e.getMessage());
    }
    /**
     * 处理其他未捕获的普通异常(Exception)
     *
     * @param e 捕获到的异常对象
     * @return Result<Void> 返回给前端的错误结果，包含系统异常标识和异常消息
     *
     * 注意：此方法处理所有未被特定异常处理器捕获的异常
     * 返回统一的系统错误码(Result.ERROR)和异常信息
     */

    public Result<Void> handleException(Exception e){
        return Result.error(Result.ERROR,"系统异常："+ e.getMessage());
    }
}
