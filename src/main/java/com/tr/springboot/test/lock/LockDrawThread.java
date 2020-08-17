package com.tr.springboot.test.lock;

/**
 * Lock锁研究系列：从账户取钱线程
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/15 下午4:22
 */
public class LockDrawThread extends Thread {

    /** 账户 */
    private LockAccount account;
    /** 取钱数额 */
    private double drawAmount;

    public LockDrawThread(String name, LockAccount account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }

}
