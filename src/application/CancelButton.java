package application;

 import javafx.scene.control.Button;
 import javafx.scene.layout.Background;
 import javafx.scene.layout.BackgroundFill;
 import javafx.scene.paint.Color;

 public class CancelButton extends Button {
 	
	// When clicked, this button redirects the user to the home pane.
	public CancelButton() {
 		this.setText("Cancel");
 		this.setMinWidth(100);
 		this.setOnAction(event -> {
 			Main.changeScene("home");
 		});
 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
 	}
 }
