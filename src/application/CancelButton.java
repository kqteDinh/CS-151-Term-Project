package application;

import javafx.scene.control.Button;

public class CancelButton extends Button {
	public CancelButton() {
		this.setText("Cancel");
		this.setOnAction(event -> {
			Main.changeScene("home");
		});
	}
}
