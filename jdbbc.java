import java.sql.*;

public class jdbbc {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/booksss";
        String user = "root";
        String password = "your_password";

        Connection conn = null;
        PreparedStatement insertStmt = null;
        Statement selectStmt = null;
        ResultSet rs = null;

        try {
           

            conn = DriverManager.getConnection(url, user, password);

            String insertSQL = "INSERT INTO books (id, title, author, price) VALUES (?, ?, ?, ?)";
            insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Effective Java");
            insertStmt.setString(3, "Joshua Bloch");
            insertStmt.setDouble(4, 45.50);

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" A new book was inserted successfully!");
            }

            String selectSQL = "SELECT * FROM books";
            selectStmt = conn.createStatement();
            rs = selectStmt.executeQuery(selectSQL);

            System.out.println("\nBooks in Database:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");

                System.out.printf("%d | %s | %s | %.2f%n", id, title, author, price);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (insertStmt != null) insertStmt.close();
                if (selectStmt != null) selectStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
