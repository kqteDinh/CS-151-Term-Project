package application;
	
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	static Stage stg;
	static SQLiteHelper sql;
	@Override
	public void start(Stage primaryStage) {
		stg = primaryStage;
		try {
			LoginPane start = new LoginPane();
			Scene scene = new Scene(start,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScene(String rootPane) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 20, 10, 20));
		HBox topButtons = new HBox();
		topButtons.getChildren().add(new ChangePasswordButton());
		topButtons.getChildren().add(new LogoutButton());
		topButtons.setAlignment(Pos.CENTER_RIGHT);
		root.setTop(topButtons);
		
		switch (rootPane) {
			case "change-password":
				stg.getScene().setRoot(new LoginPane("change"));
				break;
			case "selector": 
				root.setCenter(new SelectorPane());
				stg.setScene(new Scene(root, 750,600));
				break;
			case "login":
				stg.setScene(new Scene(new LoginPane(), 600,400));
				break;
			default: break;
		}
	}
	
	public static void main(String[] args) {
		sql = SQLiteHelper.getHelper();
//		populateDB();
		launch(args);
		try {
			sql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void populateDB() {
		try  {
			sql.insertPassword("p");
			
			sql.insertChoice("First Name", "text");
			sql.insertChoice("Last Name", "text");
			sql.insertChoice("Gender", "dropdown");
			sql.insertChoice("Target School", "text");
			sql.insertChoice("Date", "date");
			sql.insertChoice("Program", "dropdown");
			sql.insertChoice("First Semester and Year", "droptext");
			sql.insertChoice("All Other Courses and Grades", "multitext");
			sql.insertChoice("Personal Characteristics", "multi");
			sql.insertChoice("Academic Characteristics", "multi");
			
			sql.insertOption("Male", 3);
			sql.insertOption("Female", 3);
			sql.insertOption("Other", 3);
			
			sql.insertOption("Masters of Science (MS)", 6);
			sql.insertOption("Masters of Business Administration (MBA)", 6);
			sql.insertOption(" Doctor of philosophy (PhD)", 6);
			
			sql.insertOption("Spring", 7);
			sql.insertOption("Fall", 7);
			sql.insertOption("Summer", 7);
			sql.insertOption("Winter", 7);
			
			sql.insertOption("CS151: Object-Oriented Design", 8);
			sql.insertOption("CS166: Information Security", 8);
			sql.insertOption("CS154: Theory of Computation", 8);
			sql.insertOption("CS160: Software Engineering", 8);
			sql.insertOption("CS256: Cryptography", 8);
			sql.insertOption("CS146: Data Structures and Algorithms", 8);
			sql.insertOption("CS152: Programming Languages Paradigm", 8);
			
			sql.insertOption("very passionate", 9);
			sql.insertOption("very enthusiastic", 9);
			sql.insertOption("punctual", 9);
			sql.insertOption("attentive", 9);
			sql.insertOption("polite", 9);
			
			sql.insertOption("submitted well-written assignments", 10);
			sql.insertOption("participated in all of my class activities", 10);
			sql.insertOption("worked hard", 10);
			sql.insertOption("was very well prepared for every exam and assignment", 10);
			sql.insertOption("picked up new skills quickly", 10);
			sql.insertOption("was able to excel academically at the top of my class", 10);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
