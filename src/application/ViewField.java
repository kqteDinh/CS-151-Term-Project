package application;

import javafx.scene.control.Label;

public class ViewField extends Label {
	private Letter letter;
	
	// Display the text of a letter which cannot be modified.
	public ViewField(Letter letter) {
		super();
		this.letter = letter;
		this.setText(this.letter.getContent());
	}
}
