package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SQLiteHelper sql = new SQLiteHelper();
//			BorderPane root = new BorderPane();
			SelectorPane selector = new SelectorPane(sql.getAllCharacteristics());
			Scene scene = new Scene(selector,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			sql.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void populateDB() {
		try  {
			SQLiteHelper sql = new SQLiteHelper();
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
