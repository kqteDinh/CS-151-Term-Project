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
		changeScene(rootPane, null);
	}
	
	public static void changeScene(String rootPane, Object argument) {
		int defaultHeight = 900, defaultWidth = 600;
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 20, 10, 20));
		HBox topButtons = new HBox();
		topButtons.getChildren().add(new ChangePasswordButton());
		topButtons.getChildren().add(new LogoutButton());
		topButtons.setAlignment(Pos.CENTER_RIGHT);
		topButtons.setSpacing(10);
		topButtons.setPadding(new Insets(0, 0, 10, 0));
		root.setTop(topButtons);
		
		HBox bottomButtons = new HBox();
		bottomButtons.setAlignment(Pos.CENTER_RIGHT);
		bottomButtons.setSpacing(10);
		bottomButtons.setPadding(new Insets(10, 0, 0, 0));

		switch (rootPane) {
			case "change-password":
				stg.getScene().setRoot(new LoginPane("change"));
				break;
			case "edit":
				root.setCenter(new EditField((Letter) argument));
				bottomButtons.getChildren().add(new CancelButton());
				bottomButtons.getChildren().add(new FinalizeButton((Letter) argument));
				root.setBottom(bottomButtons);
				stg.setScene(new Scene(root, defaultHeight,defaultWidth));
				break;
			case "home":
				root.setCenter(new HomePane());
				stg.setScene(new Scene(root, defaultHeight,defaultWidth));
				break;
			case "login":
				stg.setScene(new Scene(new LoginPane(), 600,400));
				break;
			case "selector": 
				root.setCenter(new SelectorPane((Letter) argument));
				stg.setScene(new Scene(root, defaultHeight,defaultWidth));
				break;
			case "search" :
				root.setCenter(new SearchPane());
				bottomButtons.getChildren().add(new CancelButton());
				root.setBottom(bottomButtons);
				stg.setScene(new Scene(root, defaultHeight,defaultWidth));
				break;
			case "view":
				root.setCenter(new ViewField((Letter) argument));
				bottomButtons.getChildren().add(new CancelButton());
				root.setBottom(bottomButtons);
				stg.setScene(new Scene(root, defaultHeight,defaultWidth));
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
			sql.insertChoice("First Course and Grade", "droptext");
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
			
			sql.insertOption("CS151: Object-Oriented Design", 7);
			sql.insertOption("CS166: Information Security", 7);
			sql.insertOption("CS154: Theory of Computation", 7);
			sql.insertOption("CS160: Software Engineering", 7);
			sql.insertOption("CS256: Cryptography", 7);
			sql.insertOption("CS146: Data Structures and Algorithms", 7);
			sql.insertOption("CS152: Programming Languages Paradigm", 7);
			
			sql.insertOption("Spring", 8);
			sql.insertOption("Fall", 8);
			sql.insertOption("Summer", 8);
			sql.insertOption("Winter", 8);
			
			sql.insertOption("CS151: Object-Oriented Design", 9);
			sql.insertOption("CS166: Information Security", 9);
			sql.insertOption("CS154: Theory of Computation", 9);
			sql.insertOption("CS160: Software Engineering", 9);
			sql.insertOption("CS256: Cryptography", 9);
			sql.insertOption("CS146: Data Structures and Algorithms", 9);
			sql.insertOption("CS152: Programming Languages Paradigm", 9);
			
			sql.insertOption("very passionate", 10);
			sql.insertOption("very enthusiastic", 10);
			sql.insertOption("punctual", 10);
			sql.insertOption("attentive", 10);
			sql.insertOption("polite", 10);
			
			sql.insertOption("submitted well-written assignments", 11);
			sql.insertOption("participated in all of my class activities", 11);
			sql.insertOption("worked hard", 11);
			sql.insertOption("was very well prepared for every exam and assignment", 11);
			sql.insertOption("picked up new skills quickly", 11);
			sql.insertOption("was able to excel academically at the top of my class", 11);
			
			sql.insertFaculty("Ahmad Yazdankhah","Lecturer","SJSU","CS department","ahmad.yazdankhah@sjsu.edu","(123) 456-7890");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
