package com.self.ddyoung.daily.service;

import com.self.ddyoung.daily.api.OneInterfaceService;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/1/1 下午6:45
 */
@Component
public class OneInterfaceServiceImpl implements OneInterfaceService {


    public String hello(String input) {
        return input;
    }
}
