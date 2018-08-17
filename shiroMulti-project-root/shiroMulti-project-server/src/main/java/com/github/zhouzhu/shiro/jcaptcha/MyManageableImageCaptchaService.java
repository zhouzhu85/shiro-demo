package com.github.zhouzhu.shiro.jcaptcha;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.captchastore.CaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * @ClassName: MyManageableImageCaptchaService
 * @author:zhouzhu
 * @Date: 2018/8/14 16:42
 * @Version: V1.0
 */
public class MyManageableImageCaptchaService extends DefaultManageableImageCaptchaService{
    public MyManageableImageCaptchaService(CaptchaStore captchaStore, CaptchaEngine captchaEngine,int minGuarantedStorageDelayInSeconds,int maxCaptchaStoreSize, int captchaStoreLoadBeforeGarbageCollection){
        super(captchaStore,captchaEngine,minGuarantedStorageDelayInSeconds,maxCaptchaStoreSize,captchaStoreLoadBeforeGarbageCollection);
    }
    public boolean hasCapcha(String id,String userCaptchaResponse){
        return store.getCaptcha(id).validateResponse(userCaptchaResponse);
    }
}
