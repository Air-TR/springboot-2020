package com.tr.springboot.kit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * BigDecimal 计算工具类
 *
 * @author TR
 * @date 2023/03/30
 */
public class BigDecimalKit {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println("a：" + a); // 输出：0.1000000000000000055511151231257827021181583404541015625
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b：" + b); // 输出：0.1
        BigDecimal c = new BigDecimal(String.valueOf(0.1)); // 所以，BigDecimal 建议传 String 而不建议直接传数字
        System.out.println("c：" + c); // 输出：0.1

        NumberFormat currency = NumberFormat.getCurrencyInstance(); // 建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  // 建立百分比格式化引用
        percent.setMaximumFractionDigits(3); // 百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); // 贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); // 利率
        BigDecimal interest = loanAmount.multiply(interestRate); // 利息

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));

        System.out.println(formatNumber(new BigDecimal("1.234")));
        System.out.println(formatNumber(new BigDecimal("1.235")));
        System.out.println(formatNumber(new BigDecimal("1.295")));
        System.out.println(formatNumber(new BigDecimal("99.999999"), "#.0000"));
    }

    /**
     * 数字格式化，四舍五入保留两位小数，不足补零
     */
    public static String formatNumber(BigDecimal number) {
        return formatNumber(number, "#.00");
    }

    /**
     * 数字格式化，保留固定位数小数（四舍五入），不足补零
     *  本类 round() 方法也能四舍五入保留指定位数小数，但不足不会补零
     */
    public static String formatNumber(BigDecimal number, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        if (number.compareTo(BigDecimal.ZERO) >= 0 && number.compareTo(new BigDecimal(1)) < 0) {
            return "0" + df.format(number);
        } else {
            return df.format(number).toString();
        }
    }

    /**
     * 默认除法运算精度
     */
    private static final int DEF_DIV_SCALE = 4;

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double subtract(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double multiply(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double divide(double v1, double v2) {
        return divide(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double divide(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = BigDecimal.valueOf(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精确的类型转换(Float)
     *
     * @param v 需要被转换的数字
     * @return 返回转换结果
     */
    public static float convertToFloat(double v) {
        BigDecimal b = new BigDecimal(v);
        return b.floatValue();
    }

    /**
     * 提供精确的类型转换(Int)不进行四舍五入
     *
     * @param v 需要被转换的数字
     * @return 返回转换结果
     */
    public static int convertsToInt(double v) {
        BigDecimal b = new BigDecimal(v);
        return b.intValue();
    }

    /**
     * 提供精确的类型转换(Long)
     *
     * @param v 需要被转换的数字
     * @return 返回转换结果
     */
    public static long convertsToLong(double v) {
        BigDecimal b = new BigDecimal(v);
        return b.longValue();
    }

    /**
     * 返回两个数中大的一个值
     *
     * @param v1 需要被对比的第一个数
     * @param v2 需要被对比的第二个数
     * @return 返回两个数中大的一个值
     */
    public static double returnMax(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.max(b2).doubleValue();
    }

    /**
     * 返回两个数中小的一个值
     *
     * @param v1 需要被对比的第一个数
     * @param v2 需要被对比的第二个数
     * @return 返回两个数中小的一个值
     */
    public static double returnMin(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.min(b2).doubleValue();
    }

    /**
     * 精确对比两个数字
     *
     * @param v1 需要被对比的第一个数
     * @param v2 需要被对比的第二个数
     * @return 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
     */
    public static int compareTo(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.compareTo(b2);
    }

}