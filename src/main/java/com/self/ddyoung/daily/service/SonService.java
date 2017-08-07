package com.self.ddyoung.daily.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/7/26 下午2:24
 */
public class SonService extends PartnerService {

    public static void main(String[] args) {
        collectionSetFunc();
    }


    public int overrideFunc(){

        return 0;
    }

    public static int overload(){
        return 0;
    }

    public static void collectionListFunc(){
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(0, 1);
        integerList.add(3);
        integerList.add(0, 2);
        integerList.add(1,100);
        integerList.add(2,200);
        integerList.add(4);
        integerList.add(4);
        System.out.println(JSONObject.toJSONString(integerList));
        integerList.remove(0);
        System.out.println(JSONObject.toJSONString(integerList));
    }

    public static void collectionSetFunc(){
        Set<Integer> integerSet = new HashSet<Integer>();
        integerSet.add(0);
        integerSet.add(0);
        integerSet.add(1);
        System.out.println(JSONObject.toJSONString(integerSet));
    }
}
