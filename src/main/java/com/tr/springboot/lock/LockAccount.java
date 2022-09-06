package com.tr.springboot.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 锁研究系列：实体类
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/15 下午12:41
 */
public class LockAccount {

    /** 定义锁对象 */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 定义静态变量
     * 测试静态变量在程序中的修改与可见性关系
     */
    public static int num = 100;

    private String accountNo;
    private double balance;

    /** 取钱方法 */
    public void draw(double drawAmount) {
        lock.lock(); // 加锁
        try {
            System.out.println(Thread.currentThread().getName() + " 开始取钱，取钱金额：" + drawAmount);
            /** 测试在线程中修改静态变量,看其他线程拿到的静态变量结果 */
            num--;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 账户余额大于取钱数目
            if (balance >= drawAmount) {
                // 取出钱，修改余额
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() +
                        " 取钱成功！账户余额：" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " 取钱失败！余额不足！");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 退出程序" + "\n");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == LockAccount.class) {
            LockAccount target = (LockAccount) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    public LockAccount() {
    }

    public LockAccount(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public double getBalance() {
        return this.balance;
    }

}
