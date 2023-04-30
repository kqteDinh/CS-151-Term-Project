package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ChangePasswordButton extends Button {

	// When clicked, this button redirects the user to the login pane and displays the change password view.
	public ChangePasswordButton() {
		this.setText("Change Password");
		this.setMinWidth(100);
		this.setOnAction(event -> {
			Main.changeScene("change-password");
		});
		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
	}
}
