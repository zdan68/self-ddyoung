package com.self.ddyoung.daily.service;

import com.self.ddyoung.daily.manager.UserManager;
import com.self.ddyoung.daily.plugin.DBHelper;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/3/10 下午2:05
 * <p>
 * <p>
 * name 3-10个汉字
 * age 1-99随机
 * addr 10-30ge 汉字
 * remark 20-40个随机汉字
 * <p>
 * <p>
 * random产生的是[0,1)的小数
 */
public class Chapter {


    private static int total = 1000000;

    public static void main(String[] args) {
        Date startTime = new Date();
        mainTread2(startTime, 10);
        Date endTime = new Date();
        // 耗时
        System.out.println("cast : " + (endTime.getTime() - startTime.getTime()) / 1000 + " s");
    }

    public static void mainTread2(final Date startTime, final int countTread) {
        for (int i = 1; i <= countTread; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (finalI == countTread){
                        mainOne(total - total/countTread * (finalI-1));
                    }else {
                        mainOne(total/countTread);
                    }
                    Date endTime = new Date();
                    // 耗时
                    System.out.println("cast : " + (endTime.getTime() - startTime.getTime()) / 1000 + " s");
                }
            }).start();
        }
    }

    public static void insertOneCommitOne() {
        String sql = "INSERT INTO self_ddyoung.test_100w (name, age, addr, remark) VALUES (?,?,?,?)";
        DBHelper dbHelper = new DBHelper(sql);
        try {
            for (int i = 1; i <= total; i++) {
                String name = UserManager.getRandomString(UserManager.getBetweenRandom(3, 10));
                byte age = (byte) UserManager.getBetweenRandom(1, 99);
                String address = UserManager.getRandomString(UserManager.getBetweenRandom(10, 30));
                String remark = UserManager.getRandomString(UserManager.getBetweenRandom(20, 40));
                dbHelper.pst.setString(1, name);
                dbHelper.pst.setByte(2, age);
                dbHelper.pst.setString(3, address);
                dbHelper.pst.setString(4, remark);
                dbHelper.pst.execute();
                dbHelper.conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbHelper.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertOneCommitBatch() {
        String sql = "INSERT INTO self_ddyoung.test_100w (name, age, addr, remark) VALUES (?,?,?,?)";
        DBHelper dbHelper = new DBHelper(sql);
        try {
            for (int i = 1; i <= total; i++) {
                String name = UserManager.getRandomString(UserManager.getBetweenRandom(3, 10));
                byte age = (byte) UserManager.getBetweenRandom(1, 99);
                String address = UserManager.getRandomString(UserManager.getBetweenRandom(10, 30));
                String remark = UserManager.getRandomString(UserManager.getBetweenRandom(20, 40));
                dbHelper.pst.setString(1, name);
                dbHelper.pst.setByte(2, age);
                dbHelper.pst.setString(3, address);
                dbHelper.pst.setString(4, remark);
                dbHelper.pst.addBatch();
                if (i % 6000 == 0) {
                    dbHelper.pst.executeBatch();
                    dbHelper.pst.clearBatch();
                    dbHelper.conn.commit();
                }
            }
            if (total%6000!=0){
                dbHelper.pst.executeBatch();
                dbHelper.pst.clearBatch();
                dbHelper.conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbHelper.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mainOne(int oneTotal) {
        String sql = "INSERT INTO self_ddyoung.test_100w (name, age, addr, remark) VALUES (?,?,?,?)";
        DBHelper dbHelper = new DBHelper(sql);
        try {
            String prefix = "INSERT INTO self_ddyoung.test_100w (name, age, addr, remark) VALUES ";
            StringBuffer suffix = new StringBuffer();
            for (int j = 1; j <= oneTotal; j++) {
                String name = UserManager.getRandomString(UserManager.getBetweenRandom(3, 10));
                byte age = (byte) UserManager.getBetweenRandom(1, 99);
                String address = UserManager.getRandomString(UserManager.getBetweenRandom(10, 30));
                String remark = UserManager.getRandomString(UserManager.getBetweenRandom(20, 40));
                suffix.append("('").append(name).append("',").append(age).append(", '").append(address).append("','").append(remark).append("'),");
                if (j % 6000 == 0) {
                    String insertSql = prefix + suffix.substring(0, suffix.length() - 1);
                    dbHelper.pst.addBatch(insertSql);
                    dbHelper.pst.executeBatch();
                    dbHelper.pst.clearBatch();
                    dbHelper.conn.commit();
                    prefix = "INSERT INTO self_ddyoung.test_100w (name, age, addr, remark) VALUES ";
                    suffix = new StringBuffer();
                }
            }
            if (oneTotal%6000!=0){
                String insertSql = prefix + suffix.substring(0, suffix.length() - 1);
                dbHelper.pst.addBatch(insertSql);
                dbHelper.pst.executeBatch();
                dbHelper.pst.clearBatch();
                dbHelper.conn.commit();
                dbHelper.pst.executeBatch();
                dbHelper.conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbHelper.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}



