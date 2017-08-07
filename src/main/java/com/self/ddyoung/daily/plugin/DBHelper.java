package com.self.ddyoung.daily.plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/3/13 上午11:08
 */
public class DBHelper {


    public static final String url = "jdbc:mysql://127.0.0.1/self_ddyoung?characterEncoding=utf8";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql){
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            conn.setAutoCommit(Boolean.FALSE);
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
