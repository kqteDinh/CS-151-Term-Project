package application;

import javafx.scene.control.TextArea;

public class EditField extends TextArea {
	private Letter letter;

	public EditField(Letter letter) {
		super();
		this.setWrapText(true);
		this.letter = letter;
		this.setText(this.letter.getContent());
		this.textProperty().addListener((observable, oldText, newText) -> {
			this.letter.setContent(newText);
			System.out.println(this.letter.getContent());
			// TODO add undo/redo options here
		});
	}
	
	
}
