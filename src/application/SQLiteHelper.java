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

        createTableSQL = "CREATE TABLE IF NOT EXISTS recommendation_letters (id INTEGER PRIMARY KEY AUTOINCREMENT, student_name TEXT, student_email TEXT, semester_name TEXT, course_name TEXT, program_name TEXT, faculty_name TEXT, letter_text TEXT)";
        connection.createStatement().execute(createTableSQL);

        createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
        connection.createStatement().execute(createTableSQL);
    }

    // Insert faculty signature information into the facultyInfo table
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

    // Insert recommendation letter information into the recommendation_letters table
    public void insertRecommendationLetter(String studentName, String studentEmail, String semesterName, String courseName, String programName, String facultyName, String letterText) throws SQLException {
        String insertSQL = "INSERT INTO recommendation_letters (student_name, student_email, semester_name, course_name, program_name, faculty_name, letter_text) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, studentName);
        statement.setString(2, studentEmail);
        statement.setString(3, semesterName);
        statement.setString(4, courseName);
        statement.setString(5, programName);
        statement.setString(6, facultyName);
        statement.setString(7, letterText);
        statement.executeUpdate();
    }

    // Insert user information into the users table
    public void insertUser(String username, String password) throws SQLException {
        String insertSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.executeUpdate();
    }

    // Check if the given username and password exist in the users table
    public boolean checkUser(String username, String password) throws SQLException {
        String selectSQL = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    // Reset the password of the user with the given username
    public void resetPassword(String username, String newPassword) throws SQLException {
        String updateSQL = "UPDATE users SET password=? WHERE username=?";
        PreparedStatement statement = connection.prepareStatement(updateSQL);
        statement.setString(1, newPassword);
        statement.setString(2, username);
        statement.executeUpdate();
    }

    // Close the connection to the database
    public void close() throws SQLException {
        connection.close();
    }
}
