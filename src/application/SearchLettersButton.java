package application;

 import javafx.scene.control.Button;
 import javafx.scene.layout.Background;
 import javafx.scene.layout.BackgroundFill;
 import javafx.scene.paint.Color;

 public class SearchLettersButton extends Button {
 	public SearchLettersButton() {
 		this.setText("Search letters");
 		this.setMinWidth(200);
 		this.setOnAction(event -> {
 			Main.changeScene("search");
 		});
 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
 	}
 }