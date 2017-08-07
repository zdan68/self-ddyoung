package com.self.ddyoung.daily.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.pamirs.commons.dao.Query;
import com.self.ddyoung.daily.dao.UserDAO;
import com.self.ddyoung.daily.model.UserDO;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/3/22 上午10:47
 */
public class Producer {

    private static String mqHost = "10.226.76.180:9876";

    @Resource
    private UserDAO userDAO;


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        Date startTime = new Date();
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr(mqHost);
        producer.setInstanceName("rmq-instance");
        producer.setProducerGroup("rmq-group-A");
        producer.start();
        for (int i = 1; i <= 100; i++) {
            Message msg = new Message();
            msg.setTopic("topic-A");
            msg.setTags("tag-A");
            msg.setBody((new Date() + "Hello RocketMQ ,QuickStart," + i).getBytes());
            producer.send(msg);
        }
        producer.shutdown();
        Date endTime = new Date();
        // 耗时
        System.out.println("cast : " + (endTime.getTime() - startTime.getTime()) / 1000 + " s");
    }


    public void transferByAge() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        Date startTime = new Date();
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr(mqHost);
        producer.setInstanceName("rmq-instance");
        producer.setProducerGroup("rmq-group-A");
//        producer.start();

        Query<UserDO> query = new Query<UserDO>();
        int total = (int) userDAO.selectListCount(query);
        int pageSize = 1000;
        for (int i = 1; i <= total / pageSize + 1; i++) {
            query.setCurrentPage(i);
            query.setPageSize(pageSize);
            List<UserDO> userDOs = userDAO.selectList(query);
            for (UserDO userDO: userDOs) {
                Message msg = new Message();
                msg.setTopic("topic-A");
                msg.setTags("tag-A");
                msg.setBody(JSONObject.toJSONString(userDO).getBytes());
                producer.send(msg);
            }
        }
//        producer.shutdown();
        Date endTime = new Date();
        // 耗时
        System.out.println("cast : " + (endTime.getTime() - startTime.getTime()) / 1000 + " s");
    }

}
