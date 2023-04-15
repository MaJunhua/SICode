package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mysql"; //数据库连接地址
        String user = "root"; //用户名
        String password = "133256"; //密码

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

            //注册数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //创建数据库连接
        conn = DriverManager.getConnection(url, user, password);

        //创建SQL语句对象
        stmt = conn.createStatement();

        //执行SQL查询语句
        rs = stmt.executeQuery("SELECT * FROM employees");

        //处理查询结果集
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("first_name");
            System.out.println("ID: " + id + ", Name: " + name);
        }
    }
}