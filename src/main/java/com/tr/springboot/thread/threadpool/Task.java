package com.tr.springboot.thread.threadpool;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 11:52 AM
 */
public class Task extends Thread {

    ThreadService threadService = new ThreadServiceImpl();

    private int threadNum;

    private int type;

    Task(int num, int t) {
        threadNum = num;
        type = t;
    }

    @Override
    public void run() {
//        System.out.println(super.getName());
//        System.out.println("当前执行了：" + threadNum + "-" + type);
        switch (type) {
            case 1:
                threadService.methodA();
                break;
            case 2:
                threadService.methodB();
                break;
            case 3:
                threadService.methodC();
                break;
            default:
                return;
        }
        System.out.println("任务 " + threadNum + "-" + type + " >>执行完成" + "\n");
    }
}

