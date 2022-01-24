package com.tr.springboot.util;

/**
 * 正则表达式工具类
 *
 * @author rtao
 * @date 2022/1/17 18:08
 */
public class RegexUtil {

    /** 手机号码 */
    public static final String PHONE = "^1[34578]\\d{9}$";

    /** 邮箱 */
    public static final String MAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 通用密码：非空格字符，包含字母、数字、特殊字符
     * 简单密码：字母、数字、下划线任意组合
     * 组合密码：包含字母、数字、特殊字符中的至少2种
     * 安全密码：同时包含大写字母、小写字母、数字、特殊字符
     */
    public static final String PASSWORD = "^\\S{6,16}$";
    public static final String PASSWORD_SIM = "^\\w{6,16}$";
    public static final String PASSWORD_COM = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,16}$";
    public static final String PASSWORD_SEC = "^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[@!#$%^&*()_+\\.\\-\\?<>'\"|=]+).{8,15}$";

    /**
     * 15位身份证：1.首位非0 2.月份01~12 3.日期01~31
     * 18位身份证：1.首位非0 2.年份前两位19/20 3.月份01~12 4.日期01~31
     */
    public static final String SFZ_15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(1[0-2]))((0[1,9])|([1|2]\\\\d)|3[0-1])\\d{3}$";
    public static final String SFZ_18 = "^[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))((0[1,9])|([1|2]\\d)|3[0-1])\\d{3}[0-9Xx]$";

}
