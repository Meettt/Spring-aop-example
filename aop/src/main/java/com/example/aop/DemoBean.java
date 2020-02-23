package com.example.aop;

import org.springframework.stereotype.Component;

/**
 * @author meettpatel
 * @date 2020-02-23
 */
@Component
public class DemoBean {

    public void newMethod() {

    }
    public void throwRuntimeException() {
        throw new NullPointerException();
    }

    public String returnString() {
        return "Hi There!!!";
    }
}
