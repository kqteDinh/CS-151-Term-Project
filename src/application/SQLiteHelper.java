package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper {
    
    // SQLite database URL
    private static final String URL = "jdbc:sqlite:test.db";
    
    // Connection object
    private Connection connection;
    
    // Constructor
    public SQLiteHelper() throws SQLException {
        // Create a connection to the SQLite database
        connection = DriverManager.getConnection(URL);
        
        // Create tables in the database if they don't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS facultyInfo (id INTEGER PRIMARY KEY AUTOINCREMENT, faculty_name TEXT, faculty_title TEXT, school_name TEXT, department_name TEXT, email TEXT, phone_number TEXT)";
        connection.createStatement().execute(createTableSQL);
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS semesters (id INTEGER PRIMARY KEY AUTOINCREMENT, semester_name TEXT)";
        connection.createStatement().execute(createTableSQL);
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY AUTOINCREMENT, course_name TEXT)";
        connection.createStatement().execute(createTableSQL);
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS programs (id INTEGER PRIMARY KEY AUTOINCREMENT, program_name TEXT)";
        connection.createStatement().execute(createTableSQL);
    }
    
    // Insert faculty signature information into the recommendation_signature table
    public void insertSignature(String facultyName, String facultyTitle, String schoolName, String departmentName, String email, String phoneNumber) throws SQLException {
        String insertSQL = "INSERT INTO facultyInfo (faculty_name, faculty_title, school_name, department_name, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, facultyName);
        statement.setString(2, facultyTitle);
        statement.setString(3, schoolName);
        statement.setString(4, departmentName);
        statement.setString(5, email);
        statement.setString(6, phoneNumber);
        statement.executeUpdate();
    }
    
    // Get all semesters from the semesters table
    public String[] getAllSemesters() throws SQLException {
        String selectSQL = "SELECT * FROM semesters";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = statement.executeQuery();
        List<String> semestersList = new ArrayList<>();
        while(resultSet.next()) {
            semestersList.add(resultSet.getString("semester_name"));
        }
        return semestersList.toArray(new String[0]);
    }
    
    // Get all courses from the courses table
    public String[] getAllCourses() throws SQLException {
        String selectSQL = "SELECT * FROM courses";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = statement.executeQuery();
        List<String> coursesList = new ArrayList<>();
        while(resultSet.next()) {
            coursesList.add(resultSet.getString("course_name"));
        }
        return coursesList.toArray(new String[0]);
    }
    
    // Get all programs from the programs table
    public String[] getAllPrograms() throws SQLException {
        String selectSQL = "SELECT * FROM programs";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = statement.executeQuery();
        List<String> programsList = new ArrayList<>();
        while(resultSet.next()) {
            programsList.add(resultSet.getString("program_name"));
        }
        return programsList.toArray(new String[0]);
    }
    
 // Insert a semester into the semesters table
    public void insertSemester(String semesterName) throws SQLException {
        String insertSQL = "INSERT INTO semesters (semester_name) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, semesterName);
        statement.executeUpdate();
    }

    // Insert a course into the courses table
    public void insertCourse(String courseName) throws SQLException {
        String insertSQL = "INSERT INTO courses (course_name) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, courseName);
        statement.executeUpdate();
    }

    // Insert a program name into the programs table
    public void insertProgram(String programName) throws SQLException {
        String insertSQL = "INSERT INTO programs (program_name) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, programName);
        statement.executeUpdate();
    }

    // Close the connection
    public void close() throws SQLException {
        connection.close();
    }
    
}
