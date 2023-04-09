package application;

import javafx.scene.control.Button;

public class ChangePasswordButton extends Button {
	public ChangePasswordButton() {
		this.setText("Change Password");
		this.setOnAction(event -> {
			Main.changeScene("change-password");
		});
	}
}
