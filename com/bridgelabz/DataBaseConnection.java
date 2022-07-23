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
            String name = "terissa";
            String query = "select * from employee_payroll where name = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + resultSet.getString("gender") + resultSet.getDate("start_date"));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
