/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.zlymessage.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 接口返回对象实体
 */
public final class Result<T extends Serializable> implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(Result.class);
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private String code = ResultEnum.ERROR.getCode();

    /**
     * 错误信息
     */
    private String message = null;

    /**
     * 返回结果实体
     */
    private Object data = null;


    public Result() {
    }

    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    private Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T extends Serializable> Result<T> error(String message) {
        LOG.debug("返回错误：code={}, message={}", ResultEnum.ERROR.getCode(), message);
        return new Result<T>(ResultEnum.ERROR.getCode(), message, null);
    }

    public static <T extends Serializable> Result<T> error(ResultEnum resultEnum) {
        LOG.debug("返回错误：code={}, message={}", resultEnum.getCode(), resultEnum.getMsg());
        return new Result<T>(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static <T extends Serializable> Result<T> error(String code, String message) {
        LOG.debug("返回错误：code={}, message={}", code, message);
        return new Result<T>(code, message, null);
    }
    public static <T extends Serializable> Result<T> error(String code, String message,T data) {
        LOG.debug("返回错误：code={}, message={}", code, message);
        return new Result<T>(code, message, data);
    }
    public static <T extends Serializable> Result<T> error(String code, String message,Object data) {
        LOG.debug("返回错误：code={}, message={}", code, message);
        return new Result<T>(code, message, data);
    }

    public static <T extends Serializable> Result<T> success(T data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), "成功", data);
    }

    public static <T extends Serializable> Result<T> success(Object data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), "成功", data);
    }

    public static <T extends Serializable> Result<T> success() {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), "成功", null);
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
    }

}
