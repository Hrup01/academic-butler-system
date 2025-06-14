package com.hrup.academicbutlersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应数据传输对象，用于封装API接口返回给客户端的数据
 * @param <T> 响应中携带的具体数据类型的泛型参数
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /** 响应码 */
    private Integer code;
    /** 响应消息 */
    private String message;
    /** 响应数据 */
    private T data;
    /** 响应时间戳 */
    private Long timestamp;

    /** 成功响应码 */
    public static final Integer SUCCESS = 200;
    /** 参数错误响应码 */
    public static final Integer PARAM_ERROR = 400;
    /** 未授权响应码 */
    public static final Integer UNAUTHORIZED = 401;
    /** 禁止访问响应码 */
    public static final Integer FORBIDDEN = 403;
    /** 资源不存在响应码 */
    public static final Integer NOT_FOUND = 404;
    /** 服务器错误响应码 */
    public static final Integer ERROR = 500;

    /**
     * 成功响应
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(SUCCESS);
        result.setMessage("操作成功");
        return result;
    }

    /**
     * 成功响应
     * @param data 响应数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(SUCCESS);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 失败响应
     * @param code 错误码
     * @param message 错误信息
     */
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


}
