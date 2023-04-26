package application;

import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;

public class SearchPane extends HBox{
	private static SQLiteHelper sql;
	
	private TextField lastName;
	private Label errorMessage;
	private Button searchButton;
	private Label searchText;
	private VBox results;
	
	public SearchPane() {
		searchView();
		
	}
	private void searchView(){
		sql = SQLiteHelper.getHelper();
		
		VBox leftPane = new VBox();
		leftPane.setMinWidth(200);
        leftPane.setPrefSize(188, 600);
        leftPane.setStyle("-fx-background-color: #FFFFFF;");
		searchText = new Label("Search by last name:");
		searchText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
        lastName = new TextField();
		searchButton = new Button("search");
        searchButton.setOnAction(event -> searchForLetter());
        searchButton.setStyle("-fx-background-color: #1E90FF;");
        searchButton.setPrefSize(133, 31);
        errorMessage = new Label();
		errorMessage.setWrapText(true);
		errorMessage.setTextFill(Color.color(1, 0, 0));
        leftPane.getChildren().addAll(searchText, lastName, searchButton, errorMessage);
        leftPane.setSpacing(10);
        getChildren().add(leftPane);
        
        results = new VBox();
        results.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        results.setMinWidth(660);
        getChildren().add(results);
        
        setSpacing(10);
        
        
	}
	
	private void searchForLetter() {
		try {
			results.getChildren().clear();
			if(sql.checkLastName(lastName.getText())) {
				errorMessage.setText("");
				for(Letter l : sql.getLettersByLastName(lastName.getText())) {
					results.getChildren().add(new SearchResult(l));
				}
			}
			else {
				errorMessage.setText("No results found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void testSearch() {
		
	}
}
