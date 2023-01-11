package com.tr.springboot.web.controller.checkvalid;

import com.tr.springboot.web.entity.Account;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: TR
 * @date: 2022/12/7 上午9:11
 */
@Api(tags = "验证 Valid 校验")
@RestController
public class CheckValidController {

    /**
     * 没有 @Valid，没有校验效果，正常进入方法内
     * @param account
     */
    @PostMapping("/valid/without/at-Valid")
    public void validEentityWithoutAtValid(@RequestBody Account account) {
        System.out.println("/valid/without/at-Valid");
    }

    /**
     * 有 @Valid，正常校验，不通过会被拦截，不能进入方法内
     * @param account
     */
    @PostMapping("/valid")
    public void validEentity(@RequestBody @Valid Account account) {
        System.out.println("/valid/entity");
    }

    /**
     * @Valid + BindingResult，有校验，但不通过还会进入方法内，校验结果放在 bindingResult，需自行对 bindingResult 进行处理。
     * 注：@Valid 和 BindingResult 要相邻使用，否则 BindingResult 接收不到错误信息。
     *
     * @param account
     * @param bindingResult
     */
    @PostMapping("/valid/with/bindingResult")
    public void validEentityWithBindingResult(@RequestBody @Valid Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            System.out.println("Error");
        }
        System.out.println("/valid/entity/with/bindingResult");
    }

}
