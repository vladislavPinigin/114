package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USERNAME = "root1";
    private static final String DB_PASSWORD = "root1";

    static {
        loadDriver();
    }

    private Util() {

    }

    public static Connection getConnection() {
        return openConnection();
    }

    private static void loadDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver Err");
            throw new RuntimeException(e);
        }
    }

    private static Connection openConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Err");
            throw new RuntimeException(e);
        }
    }



}
