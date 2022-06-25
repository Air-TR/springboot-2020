package com.tr.springboot.web.common.result;

public enum ResultEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    DAO_EXCEPTION(2, "数据库异常"),
    NO_LOGIN(3, "未登录"),
    RESPONSE_PACK_ERROR(4, "Response 返回包装失败")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
