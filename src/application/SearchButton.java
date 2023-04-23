package application;

import javafx.scene.control.Button; 


public class SearchButton extends Button {
	public SearchButton() {
		this.setText("Search");
		this.setOnAction(event -> {
			Main.changeScene("search");
		});
	}
}