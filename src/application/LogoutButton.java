package application;

import javafx.scene.control.Button;

public class LogoutButton extends Button {
	public LogoutButton() {
		this.setText("Logout");
		this.setOnAction(event -> {
			Main.changeScene("login");
		});
	}
}
