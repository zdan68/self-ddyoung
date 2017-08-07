package com.self.ddyoung.daily.service;

import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/3/22 下午5:05
 */
public class ProducerTest extends AutoRollbackBaseTest {

    @Resource
    private Producer producer;

    @Test
    public void testTransferByAge() throws Exception {
        producer.transferByAge();
    }

}