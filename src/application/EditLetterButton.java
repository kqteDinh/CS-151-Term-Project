package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class EditLetterButton extends Button {

	// When clicked, this button redirects the user to the edit pane.
 	public EditLetterButton(Letter letter) {
 		this.setText("Edit Letter");
 		this.setMinWidth(100);
 		this.setOnAction(event -> {
 			Main.changeScene("selector", letter);
 		});
 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
 	}
}
