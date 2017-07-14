package org.springframework.samples.mvc.yc;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/7/12.
 */
public class InitializingBeanTest implements InitializingBean {

    public InitializingBeanTest() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println("init-method");
    }
}
