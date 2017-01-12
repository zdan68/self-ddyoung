package com.self.ddyoung.daily.interfaces;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/1/1 下午6:48
 */
public class Main {

    public static void main(String[] args) {
        OneInterface oneInterface = new OneInterfaceImpl();
        System.out.println(oneInterface.hello("hello Sanbian"));
    }
}
