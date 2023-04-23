package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class NewLetterButton extends Button {
	NewLetterButton() {
		this.setText("Create a letter");
		this.setMinWidth(200);
		this.setOnAction(e -> {
			Main.changeScene("selector");
		});
		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
	}
}
