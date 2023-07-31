package dev.keirz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListSubscribers {

    private List<String> subscribers;
    private final DataSourceProperties db;

    public ListSubscribers() {
        this.db = new DataSourceProperties();
    }

    public ListSubscribers(DataSourceProperties db) {
        this.db = db;
    }

    public List<String> handleRequest() {

        subscribers = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(
                db.getJdbcUrl(), db.getUsername(), db.getPassword())) {

            if (!conn.isValid(0)) {
                System.out.println("Unable to connect to: " + db.getJdbcUrl());
                System.exit(0);
            }
            PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM subscribers");
            ResultSet rs = selectStatement.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                System.out.println(email);
                subscribers.add(email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return subscribers;
    }
}
