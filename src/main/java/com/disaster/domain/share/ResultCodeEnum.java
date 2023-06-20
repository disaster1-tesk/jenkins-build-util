package com.disaster.domain.share;

public enum ResultCodeEnum {
    SUCCESS(200, "接口返回成功"),
    REDIRECT(301, "重定向"),
    ACCESS_DENIED(401, "未授权"),
    ERROR(500, "系统内部错误");

    private int code;
    private String msg;

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

    private ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
