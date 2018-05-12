package com.lixiaodong.dao;

import com.lixiaodong.db.JdbcUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class Test2Dao {
    public String getOne(){
        String name ="";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 调用工具类中的静态方法来获取连接
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM b1  order by id desc limit 1;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                name = resultSet.getString("name");
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 调用工具类中的静态方法来关闭连接，释放资源
            JdbcUtil.releaseConn(connection, statement, resultSet);
        }
        return name;
    }
}
