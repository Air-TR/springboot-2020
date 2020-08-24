package com.tr.springboot.thread;

import java.util.Random;

/**
 * 任务类
 * 创建任务供 ThreadPool 执行
 *
 * @author TR
 * @version 1.0
 * @date 8/18/2020 10:53 AM
 */
class Task extends Thread {
    private int threadNum;

    Task(int num) {
        threadNum = num;
    }

    @Override
    public void run() {
        System.out.println(super.getName());
        System.out.println("当前执行了：" + threadNum);
        try {
            Random random = new Random();
            int sleep = random.nextInt(5) + 2;
            System.out.println(threadNum + ">>停止" + sleep + "秒");
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException e) {
            System.out.println("执行过程中出现线程暂停异常" + e);
        }
        System.out.println(threadNum + ">>执行完成");
        System.gc();
    }
}
