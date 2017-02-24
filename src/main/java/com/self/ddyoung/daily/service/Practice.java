package com.self.ddyoung.daily.service;

import com.self.ddyoung.daily.plugin.CyclicBarrierDemo;
import org.apache.avalon.framework.ExceptionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/2/23 下午7:59
 */
public class Practice {

    public static void main(String[] args) {
        Map<String, Boolean> stringMap = new HashMap<String, Boolean>();
        stringMap.put("111", Boolean.TRUE);
        stringMap.put("112", Boolean.TRUE);
        stringMap.put("113", Boolean.TRUE);
        stringMap.put("114", Boolean.TRUE);
        stringMap.put("115", Boolean.FALSE);
        Boolean aBoolean = testMoreThread(stringMap);
        if (aBoolean) {
            System.out.println("大家都到达了宿舍楼下，一起出发吧。。。");
        } else {
            System.out.println("都回宿舍了？？？？？？？");
        }
    }

    public static Boolean testMoreThread(Map<String, Boolean> stringMap) {
        CyclicBarrierDemo sCyclicBarrier = new CyclicBarrierDemo(stringMap.size()+1, new Runnable() {
            @Override
            public void run() {
            }
        });
        try {
            for (String key : stringMap.keySet()) {
                Worker worker = new Worker(key, 5000, sCyclicBarrier, stringMap.get(key));
                worker.start();
            }
            Thread.sleep(1000);
            sCyclicBarrier.await();//工人完成工作，计数器减一
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static class Worker extends Thread {
        String workerName;
        int workTime;
        CyclicBarrierDemo sCyclicBarrier;
        Boolean workValue;

        public Worker(String workerName, int workTime, CyclicBarrierDemo sCyclicBarrier, Boolean workValue) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.sCyclicBarrier = sCyclicBarrier;
            this.workValue = workValue;
        }

        public void run() {
            System.out.println(workerName + "开始从宿舍出发。。。");
            try {
                if (workValue) {
                    System.out.println(workerName + "到达楼下。。。");
                    sCyclicBarrier.await();//等待别的同学
                    System.out.println(workerName + "开始从宿舍楼下出发。。。");
                    System.out.println(workerName + "到达食堂。。。");
                } else {
                    System.out.println(workerName + "到达楼下。。。突然想叫外卖，回宿舍。。。");
                    sCyclicBarrier.out();
                }
            } catch (Throwable e) {
                ExceptionUtil.printStackTrace(e);
                System.out.println(workerName + "回宿舍。。。");
                sCyclicBarrier.out();
            }
        }
    }

}
