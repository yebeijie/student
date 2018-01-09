package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static final String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String NAME = "root";
    private static final String PASS = "root";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("create connection fail.",e);
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL , NAME , PASS);
        } catch (SQLException e) {
            throw new RuntimeException("get connection fail.",e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
