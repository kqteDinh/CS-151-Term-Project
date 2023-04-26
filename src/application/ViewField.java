package application;

import javafx.scene.control.Label;

public class ViewField extends Label {
	private Letter letter;
	
	ViewField(Letter letter) {
		super();
		this.letter = letter;
		this.setText(this.letter.getContent());
	}
}
