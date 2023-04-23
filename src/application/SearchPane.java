package application;

import java.sql.SQLException;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SearchPane extends BorderPane{
	private static SQLiteHelper sql;
	
	private Text lastName;
	private Label errorMessage;
	private VBox centerPane;
	private Button searchButton;
	private Text searchText;
	
	public SearchPane() {
		
		
	}
	private void searchView(){
		sql = SQLiteHelper.getHelper();
		AnchorPane leftPane = new AnchorPane();
        leftPane.setPrefSize(188, 400);
        leftPane.setStyle("-fx-background-color: #FFFFFF;");
		searchText = new Text(" Please enter the last name for the recommendation letter you want to find");
		searchText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		searchButton = new Button("search");
        searchButton.setOnAction(event -> searchForLetter());
        searchButton.setStyle("-fx-background-color: #1E90FF;");
        searchButton.setPrefSize(133, 31);
	}
	
	private void searchForLetter() {
		try {
			if(sql.checkLastName(lastName.getText())) {
				/*if(sql.checkLastName(lastName.getText())){
					centerPane.getChildren().clear();
				}*/
					Main.changeScene("search");
				
			}
			else {
				errorMessage.setText("Letter with this last name not found");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void testSearch() {
		
	}
}
