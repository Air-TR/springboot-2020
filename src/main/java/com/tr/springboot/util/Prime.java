package com.tr.springboot.util;

/**
 * 质数
 *
 * @author TR
 * @version 1.0
 * @date 8/25/2020 3:43 PM
 */
public class Prime {

    public static void main(String[] args) {
        System.out.println(isPrime(67));
    }

    /**
     * 判断是否是质数
     *
     * @author TR
     * @date 8/25/2020 3:45 PM
     * @params [num]
     */
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else {
            //注意是i起始值为2，i<=Math.sqrt
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
