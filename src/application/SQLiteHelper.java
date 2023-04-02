package application;
import java.sql.*;

public class SQLiteHelper {
    
    private static Connection conn;
    
    public static void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:recommendations.db");
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS recommendations (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "first_name TEXT," +
                         "last_name TEXT," +
                         "gender TEXT," +
                         "school_name TEXT," +
                         "program_name TEXT," +
                         "semester TEXT," +
                         "year INTEGER," +
                         "courses TEXT," +
                         "grades TEXT," +
                         "personal_char TEXT," +
                         "academic_char TEXT," +
                         "draft TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Table 'recommendations' has been created.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertData(String firstName, String lastName, String gender, String schoolName, String programName, String semester, int year, String courses, String grades, String personalChar, String academicChar, String draft) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO recommendations (first_name, last_name, gender, school_name, program_name, semester, year, courses, grades, personal_char, academic_char, draft) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, gender);
            pstmt.setString(4, schoolName);
            pstmt.setString(5, programName);
            pstmt.setString(6, semester);
            pstmt.setInt(7, year);
            pstmt.setString(8, courses);
            pstmt.setString(9, grades);
            pstmt.setString(10, personalChar);
            pstmt.setString(11, academicChar);
            pstmt.setString(12, draft);
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Data has been inserted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ResultSet searchData(String firstName, String lastName, int year) {
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM recommendations WHERE first_name = ? AND last_name = ? AND year = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, year);
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
}
