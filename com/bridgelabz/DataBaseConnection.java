package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBaseConnection {
    public static void main(String[] args) {
        System.out.println("welcome to Data Base Connection " + "\n");

        //user details
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Manoj@451";

        //connecting to database
        try {
            System.out.println("Connecting to database :" + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successful" + connection + "\n");

            //creating a statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll;");

            System.out.println("The data from mySql is " + "\n");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                System.out.println(id + " " + name + " " + gender);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
