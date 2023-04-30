package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ViewLetterButton extends Button {
	// This button redirects the user to the view pane.
 	public ViewLetterButton(Letter letter) {
 		this.setText("View Letter");
 		this.setMinWidth(100);
 		this.setOnAction(event -> {
 			Main.changeScene("view", letter);
 		});
 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
 	}
}
