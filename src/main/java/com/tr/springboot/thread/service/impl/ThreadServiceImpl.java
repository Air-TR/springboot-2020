package com.tr.springboot.thread.service.impl;

import com.tr.springboot.thread.service.ThreadService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 10:52 AM
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Override
    public String methodA() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Finish A ==> " + LocalTime.now());
            return "A";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "E-A";
    }

    @Override
    public String methodB() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Finish B ==> " + LocalTime.now());
            return "B";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "E-B";
    }

    @Override
    public String methodC() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Finish C ==> " + LocalTime.now());
            return "C";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "E-C";
    }

}
