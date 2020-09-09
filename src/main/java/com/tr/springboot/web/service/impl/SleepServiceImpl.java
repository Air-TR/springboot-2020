package com.tr.springboot.web.service.impl;

import com.tr.springboot.web.service.SleepService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author TR
 * @version 1.0
 * @date 2020/9/9 下午10:40
 */
@Service
public class SleepServiceImpl implements SleepService {

    @Override
    public void sleep(int n) {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(n + "-Sleep Done: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
