package com.fenlon.test;

import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String sql = "select * from `fenlen`.`fenlon_user`";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("uName"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
