package application;

 import javafx.scene.control.Button;
 import javafx.scene.layout.Background;
 import javafx.scene.layout.BackgroundFill;
 import javafx.scene.paint.Color;

 public class CancelButton extends Button {
 	public CancelButton() {
 		this.setText("Cancel");
 		this.setOnAction(event -> {
 			Main.changeScene("home");
 		});
 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
 	}
 }