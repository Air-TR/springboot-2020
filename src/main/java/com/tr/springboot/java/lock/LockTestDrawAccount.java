package com.tr.springboot.java.lock;

/**
 * Lock锁研究系列：测试类
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/15 下午4:41
 */
public class LockTestDrawAccount {

    public static void main(String[] args) {
        // 创建一个账户
        LockAccount account = new LockAccount("1234567", 1000);

        // 模拟两个线程对同一个账户取钱
        new LockDrawThread("甲", account, 600).start();
        new LockDrawThread("乙", account, 300).start();
        new LockDrawThread("丙", account, 200).start();
    }

}
