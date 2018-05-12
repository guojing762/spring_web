package com.lixiaodong.db;

import java.sql.*;

public class MyDB {
    public static void main(String[] args) {

        /* 协议：子协议://主机:端口/数据库名 */
        String url = "jdbc:mysql://localhost:3306/lixiaodong?characterEncoding=utf8&useUnicode=true&serverTimezone=UTC";

        // mysql数据库的用户名与密码，安装时自己设置，一般默认为root
        String user = "root";
        String password = "lemon123";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.加载驱动//com.mysql.jdbc.Driver
            /*
             * DriverManager.registerDriver(new
             * Driver());用这种方法会加载两次驱动，也就是说会创建两个drive对象
             */
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            connection = DriverManager.getConnection(url, user, password);

            // 3.获取用于向数据库发送SQL的Statement对象
            statement = connection.createStatement();

            // 4.执行sql,获取数据
            resultSet = statement.executeQuery("SELECT * FROM b1;");

            // 解析数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println(id + " " + name );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接，释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                resultSet = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                statement = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                connection = null;
            }
        }
    }
}