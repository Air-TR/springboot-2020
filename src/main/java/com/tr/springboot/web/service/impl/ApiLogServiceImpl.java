package com.tr.springboot.web.service.impl;

import com.tr.springboot.aop.annotation.ApiLog;
import com.tr.springboot.web.service.ApiLogService;
import org.springframework.stereotype.Service;

/**
 * @author taorun
 * @date 2023/1/12 8:27
 */
@Service
public class ApiLogServiceImpl implements ApiLogService {

    @ApiLog
    @Override
    public String apiLog(String name, Integer age) {
//        int i = 1 / 0;
        return "log success";
    }

}
