package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DataBaseConnection {
    public static void main(String[] args) {
        System.out.println("welcome to Data Base Connection ");

        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Manoj@451";
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("cannot find the Driver in the classpath !", exception);
        }
        listDrivers();

        try {
            System.out.println("Connecting to database :" + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successful" + connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("    " + driverClass.getClass().getName());
        }
    }
}
