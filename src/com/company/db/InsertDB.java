package com.company.db;

import java.sql.PreparedStatement;

public class InsertDB {
    public void SetValues(String name, int price) {
        try (var conn = ConnectDB.getConnection()) {
            String sql = "INSERT INTO Products (ProductName, Price) Values (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d rows added\n", rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
