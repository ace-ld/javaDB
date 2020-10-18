package com.company.db;

import java.sql.ResultSet;
import java.sql.Statement;

public class TablesDB {
    public void GetTable() {
        try (var conn = ConnectDB.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            while (resultSet.next()) {
                var id = resultSet.getInt(1);
                var name = resultSet.getString(2);
                var price = resultSet.getInt(3);
                System.out.printf("%d. %s - %d\n", id, name, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
