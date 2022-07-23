package com.bridgelabz;

import java.sql.*;


public class DataBaseConnection {
    public static void main(String[] args) throws SQLException {
        System.out.println("welcome to Data Base Connection " + "\n");

        //user details
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Manoj@451";
        Connection connection = null;

        //connecting to database
        try {
            System.out.println("Connecting to database :" + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successful" + connection + "\n");

            //creating a statement
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM employee_payroll WHERE start_date BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW());";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getDate("start_date"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
