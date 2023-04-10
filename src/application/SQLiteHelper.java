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
    private static final String URL = "jdbc:sqlite:./src/application/test.db";
    
    // Connection object
    private Connection connection;
    
    // Singleton helper
    private static SQLiteHelper db = new SQLiteHelper();
    
    // Constructor
    private SQLiteHelper() {
        // Create a connection to the SQLite database
        try {
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Create tables in the database if they don't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS facultyInfo (id INTEGER PRIMARY KEY AUTOINCREMENT, faculty_name TEXT, faculty_title TEXT, school_name TEXT, department_name TEXT, email TEXT, phone_number TEXT)";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS semesters (id INTEGER PRIMARY KEY AUTOINCREMENT, semester_name TEXT)";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY AUTOINCREMENT, course_name TEXT)";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS programs (id INTEGER PRIMARY KEY AUTOINCREMENT, program_name TEXT)";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS choices (id INTEGER PRIMARY KEY AUTOINCREMENT, choice_name TEXT, type TEXT)";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS options (id INTEGER PRIMARY KEY AUTOINCREMENT, choice_id INTEGER, option_name TEXT, CONSTRAINT fk_choice FOREIGN KEY(choice_id) REFERENCES choices(id) )";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
        try {
			connection.createStatement().execute(createTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
    
    public static SQLiteHelper getHelper() {
    	return db;
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
    
    // Get all choices from choices table
    public List<Choice> getAllChoices() throws SQLException {
        String selectSQL = "SELECT * FROM choices";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = statement.executeQuery();
        List<Choice> choicesList = new ArrayList<>();
        while(resultSet.next()) {
            choicesList.add(new Choice(resultSet.getInt("id"), resultSet.getString("choice_name"),resultSet.getString("type")));
        }
        return choicesList;
    }
    
    // Get all options from options table
    public List<Option> getAllOptions() throws SQLException {
        String selectSQL = "SELECT * FROM Options";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = statement.executeQuery();
        List<Option> optionsList = new ArrayList<>();
        while(resultSet.next()) {
            optionsList.add(new Option(resultSet.getInt("id"), resultSet.getInt("choice_id"),resultSet.getString("type")));
        }
        return optionsList;
    }
    
    // Get list of all characteristics 
    public List<Characteristic> getAllCharacteristics() throws SQLException {
        String selectSQL = "SELECT * FROM choices";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = statement.executeQuery();
        List<Characteristic> characteristicsList = new ArrayList<>();
        while(resultSet.next()) {
        	selectSQL = "SELECT * FROM options WHERE choice_id=" + resultSet.getInt("id");
        	statement = connection.prepareStatement(selectSQL);
        	ResultSet optionsResultSet = statement.executeQuery();
        	List<Option> optionsList = new ArrayList<>();
        	while(optionsResultSet.next()) {
        		optionsList.add(new Option(optionsResultSet.getInt("id"),optionsResultSet.getInt("choice_id"),optionsResultSet.getString("option_name")));
        	}
            characteristicsList.add(new Characteristic(new Choice(resultSet.getInt("id"), resultSet.getString("choice_name"),resultSet.getString("type")), optionsList));
        }
        return characteristicsList;
    }
    
    // Insert a choice into the choice table
    public void insertChoice(String choiceName, String type) throws SQLException {
        String insertSQL = "INSERT INTO choices (choice_name, type) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, choiceName);
        statement.setString(2, type);
        statement.executeUpdate();
    }
    
    // Insert an option into the options table
    public void insertOption(String optionName, int choiceId) throws SQLException {
        String insertSQL = "INSERT INTO options (option_name, choice_id) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, optionName);
        statement.setInt(2, choiceId);
        statement.executeUpdate();
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
    
    // Insert a user and password 
    public void insertPassword(String password) throws SQLException {
        String insertSQL = "INSERT INTO users (username, password) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, "admin");
        statement.setString(2, password);
        statement.executeUpdate();
    }

    // Update password for admin account
    public void updatePassword(String password) throws SQLException {
        String insertSQL = "UPDATE users SET password=? WHERE username=?";
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(2, "admin");
        statement.setString(1, password);
        statement.executeUpdate();
    }
    
    // Check if the given username and password exist in the users table
    public boolean checkUser(String password) throws SQLException {
        String selectSQL = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        statement.setString(1, "admin");
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
    
}
