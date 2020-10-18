package com.company.db;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteDB {
    public void Delete(int row) {
        try (var conn = ConnectDB.getConnection()) {
            String sql = "DELETE FROM Products WHERE Id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, row);
            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d row(s) deleted\n", rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
