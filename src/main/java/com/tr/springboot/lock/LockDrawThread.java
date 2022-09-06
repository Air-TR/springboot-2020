package com.tr.springboot.lock;

/**
 * Lock 锁研究系列：从账户取钱线程
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
        /** 会先直接全部输出 */
        System.out.println(LockAccount.num);

        account.draw(drawAmount); // 线程执行取钱逻辑(同步阻塞)

        /**
         * 会等线程执行完依次输出
         * 实验证明 static 变量被一个线程修改,其他线程获取到的是被修改后的结果
         */
        System.out.println(LockAccount.num);
    }

}
