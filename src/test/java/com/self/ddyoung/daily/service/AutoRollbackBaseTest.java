package com.self.ddyoung.daily.service;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/1/13 下午12:01
 */
public class AutoRollbackBaseTest extends AbstractDependencyInjectionSpringContextTests {

    @Override
    protected String[] getConfigLocations() {
        String[] config = {
                "classpath:/spring/test-spring-config.xml"
        };
        return config;
    }

    public void testRun(){

    }

}