package com.self.ddyoung.daily.service;

import com.self.ddyoung.daily.api.OneInterfaceService;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/1/13 上午11:59
 */
public class OneInterfaceTest extends AutoRollbackBaseTest {
    private OneInterfaceService oneInterfaceService;

    public void testHello(){
        oneInterfaceService.hello("sanbian salaheiyo");
    }

    public void setOneInterfaceService(OneInterfaceService oneInterfaceService) {
        this.oneInterfaceService = oneInterfaceService;
    }
}