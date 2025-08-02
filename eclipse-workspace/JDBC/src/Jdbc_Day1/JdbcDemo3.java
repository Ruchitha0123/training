package Jdbc_Day1;

import java.sql.*;

public class JdbcDemo3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc"; // your database name
        String userName = "root";
        String pwd = "Ruchitha@9347";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found!");
            e.printStackTrace();
            return;
        }

        try (Connection con = DriverManager.getConnection(url, userName, pwd);
             Statement st = con.createStatement()) {

            // Create movies table
            String createTable = "CREATE TABLE IF NOT EXISTS movies (" +
                    "movie_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "genre VARCHAR(50) NOT NULL, " +
                    "rating DECIMAL(3,1) NOT NULL, " +
                    "status VARCHAR(20) NOT NULL, " +
                    "poster_image_url VARCHAR(255) NULL)";
            st.executeUpdate(createTable);
            System.out.println("Table 'movies' created successfully!");

            // Insert one movie with a different status
            String insertSQL = "INSERT INTO movies (title, genre, rating, status, poster_image_url) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertSQL)) {
                ps.setString(1, "Avatar: The Way of Water");
                ps.setString(2, "Fantasy");
                ps.setBigDecimal(3, new java.math.BigDecimal("8.0"));
                ps.setString(4, "Upcoming"); // 🔹 Changed status here
                ps.setString(5, "http://example.com/avatar2.jpg");
                ps.executeUpdate();
                System.out.println("Movie inserted successfully with status 'Upcoming'!");
            }

            // Fetch & display movies
            String query = "SELECT * FROM movies";
            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("movie_id");
                    String title = rs.getString("title");
                    String genre = rs.getString("genre");
                    double rating = rs.getDouble("rating");
                    String status = rs.getString("status");
                    String poster = rs.getString("poster_image_url");

                    System.out.println("ID: " + id + ", Title: " + title + ", Genre: " + genre +
                            ", Rating: " + rating + ", Status: " + status + ", Poster URL: " + poster);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        }
    }
}
