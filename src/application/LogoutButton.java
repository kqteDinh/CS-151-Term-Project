package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class LogoutButton extends Button {
	// This button redirects the user to the login pane.
	public LogoutButton() {
		this.setText("Logout");
		this.setMinWidth(100);
		this.setOnAction(event -> {
			Main.changeScene("login");
		});
		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
	}
}
