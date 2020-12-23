package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnect {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "12345";

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Product> fetchProducts() {
        String SQL = "select productName FROM product_app";
        List<Product> debts = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("productName"));
                debts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debts;
    }
    public Product addProduct(Product product){
        String SQL = "insert into product_app values ('"+product.getName()+"')";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("Added new Product to database " + product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void resetDatabase(){
        String SQL = "delete from product_app";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("All items in DB were deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
