package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class LogoutButton extends Button {
	public LogoutButton() {
		this.setText("Logout");
		this.setOnAction(event -> {
			Main.changeScene("login");
		});
		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}
}
