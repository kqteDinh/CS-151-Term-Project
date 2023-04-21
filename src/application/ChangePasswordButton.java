package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ChangePasswordButton extends Button {
	public ChangePasswordButton() {
		this.setText("Change Password");
		this.setOnAction(event -> {
			Main.changeScene("change-password");
		});
		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
	}
}
