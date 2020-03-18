package com.zlymessage.base;


public enum ResultEnum {
    // 成功
    SUCCESS("200", "成功"),

    // 登录异常
    LOGIN_ERROR("303", "登录异常"),
    REMOTE_ERROR("304", "异地登录"),
    //token
    TOKEN_MISSING("4001", "缺失token参数"),
    INVALID_TOKEN("4002", "不合法的token"),
    //签名
    SIGN_MISSING("5401", "缺失签名"),
    INVALID_SIGN("5402", "无效签名"),
    //版本
    FORCE_UPDATE("5403", "强制升级"),
    // 错误
    ERROR("500", "错误");

    private String code = null;
    private String msg = null;

    private ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResultEnum getEnumByCode(String code) {
        for (ResultEnum kind : ResultEnum.values()) {
            if (code.equals(kind.getCode())) {
                return kind;
            }
        }
        return null;
    }


}
