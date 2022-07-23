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
            String query = "insert into employee_payroll (name,salary,start_date,gender,phone_number,address,department,basic_pay,\n" +
                    "deductions,taxable_pay,income_tax,net_pay) values\n" +
                    "('suhas',40000.00,'2020-04-02','M',null,'ap','sales',null,null,null,null,null);";
            int rows = statement.executeUpdate(query);

            if (rows > 0) {
                System.out.println("contact added successfully");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
