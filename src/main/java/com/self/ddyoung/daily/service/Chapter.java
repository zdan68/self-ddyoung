package com.self.ddyoung.daily.service;

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
        mainTread2(startTime, 4);
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

    public static void get6W() {
        String sql = "INSERT INTO self_ddyoung.test_100w (name, age, addr, remark) VALUES (?,?,?,?)";
        DBHelper dbHelper = new DBHelper(sql);
        try {
            for (int i = 1; i <= total; i++) {
                String name = getRandomString(getBetweenRandom(3, 10));
                byte age = (byte) getBetweenRandom(1, 99);
                String address = getRandomString(getBetweenRandom(10, 30));
                String remark = getRandomString(getBetweenRandom(20, 40));
                dbHelper.pst.setString(1, name);
                dbHelper.pst.setByte(2, age);
                dbHelper.pst.setString(3, address);
                dbHelper.pst.setString(4, remark);
                dbHelper.pst.addBatch();
                if (i % 60000 == 0) {
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
                String name = getRandomString(getBetweenRandom(3, 10));
                byte age = (byte) getBetweenRandom(1, 99);
                String address = getRandomString(getBetweenRandom(10, 30));
                String remark = getRandomString(getBetweenRandom(20, 40));
                suffix.append("('").append(name).append("',").append(age).append(", '").append(address).append("','").append(remark).append("'),");
                if (j % 60000 == 0) {
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

    private static int getBetweenRandom(int countA, int countB) {
        return getRandom(countB - countA) + countA;
    }

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    private static String string = "爱慕与爱不同，爱慕因为有了仰慕的存在，转而显得更为纯粹，内省，也更为无私。这从郭襄真心为杨过夫妇团聚而祈福这件事中就能看得出来。在郭襄与杨过的关系中，郭襄一直处于主动的位置，主动奉献出爱，主动地为了杨过辗转反侧，从偶遇杨过后回到襄阳的一切表现中，我们可以看到郭襄是动了真感情的，她收藏神雕大侠的玩偶，为杨过祈福，因杨过为她做的一切欢欣鼓舞。那三件生日贺礼，表面上是为了贺寿，实际上却在借花献佛帮的是郭靖的忙。不能说杨过一点不爱郭襄，只能说是消受不起。一方面心中有人，另一方面，越是成熟的男人他的内心其实越是懦弱，在感情上尤是，他已经不可能全盘付出了，他没有那么多可以付出。郭襄却实实在在是无私的，甚至可说在她对杨过的感情上“慕”更大于“爱”，因为如果“爱”还有自私的一面的话，那么“慕”则完全是奉献的，直到掏空自己为止。这样飞蛾扑火式的情感，也只有处于花季时期的少女才会拥有，如此单纯，如此动人。";

    private static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }

}



