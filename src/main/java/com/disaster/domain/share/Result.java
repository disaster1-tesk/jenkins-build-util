package com.disaster.domain.share;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 15869325700230991L;
    private int code;
    private String msg;
    private boolean status;
    private T data;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    protected Result() {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.status = true;
    }

    protected Result(T data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.status = true;
        this.data = data;
    }

    protected Result(int code, String msg, T data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.status = true;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg, T data, boolean status) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.status = true;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
        this.status = true;
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
    }

    public static <T> Result<T> success(int code, T data) {
        return new Result(code,data);
    }

    public static <T> Result<T> success(T data) {
        return new Result(data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> fail(ResultCodeEnum resultCodeEnum) {
        return new Result(resultCodeEnum.getCode(), resultCodeEnum.getMsg(), (Object)null, false);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(ResultCodeEnum.ERROR.getCode(), msg, (Object)null, false);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result(code, msg, (Object)null, false);
    }

    public static <T> Result<T> fail(int code, String msg, T data) {
        return new Result(code, msg, data, false);
    }
}