package com.self.ddyoung.daily.service;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/7/26 上午10:41
 */
public class PracticeDaily {
    public static void main(String[] args) {


    }

    private void makeObjectFunction(){
        Object object = new Object();
        Object object1 = new Object();
        //判断两个对象是否相等，完全一致,与==是一样的
        boolean equals = object.equals(object1);
        //哈希寻找
        int i = object.hashCode();
        //唤醒在该对象上等待的某个线程
        object.notify();
        //唤醒在该对象上等待的所有线程
        object.notifyAll();
        try {
            /*使当前线程等待该对象的锁。当前线程必须是该对象的拥有者，也就是具有该对象的锁。
                wait()方法一直等待，直到获得锁或者被中断。
                wait(long timeout)设定一个超时时间，如果在规定的时间内没有获得锁，就返回。
                调用该方法后当前线程进入睡眠状态，直到以下事件发生：
                1. 其他线程调用了该对象的object.notify()方法
                2. 其他线程调用了该对象的object.notifyAll()方法
                3. 其他线程调用了interrupt中断该线程
                4. 时间间隔到了
                此时该线程就可以被调度了，如果是被中断的话，就抛出一个InterruptedException的异常
            */
            object.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
