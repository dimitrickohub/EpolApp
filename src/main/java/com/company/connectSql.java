package com.company;

import java.sql.*;
import java.util.HashMap;

public class connectSql {

    public void connection(String sql_url, String sql_username, String sql_password) throws ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(sql_url);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(sql_url, sql_username, sql_password);
        } catch (
                SQLException e) {
            for (Throwable ex : e) {
                System.err.println("Error occurred " + ex);
            }
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connected to database!");
        } else {
            System.out.println("Failed to make connection!");
        }

        try {
            HashMap hm = new HashMap<>();
            Statement stmt = connection.createStatement();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE fruit SET DateUpdated = CURRENT_TIMESTAMP");

            String query = "select * from fruit ;";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String fruitname = rs.getObject(2).toString();
                String inventory = rs.getObject(3).toString();
                String unitId = rs.getObject(4).toString();
                String date = rs.getObject(5).toString();
                ResultSet resultSet = statement.executeQuery(query);
//                while (resultSet.next()) {
//                    hm.put(resultSet.getInt("FruitId"), resultSet.getString("FruitName") );
//                }
//                System.out.println(hm);
                System.out.println("fruitName " + fruitname + "\ninventory " + inventory + "\nunitId " + unitId + "\nunitId " + unitId +"\ndate "  + date);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            for (Throwable ex : e) {
                System.err.println("Error occurred " + ex);
            }
            System.out.println("Error in fetching data");
        }
    }
}
