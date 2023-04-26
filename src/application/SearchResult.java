package application;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class SearchResult extends GridPane {
	Letter letter;
	
	SearchResult(Letter letter) {
		this.letter = letter;
		Label name = new Label(this.letter.getName());
		add(name, 0, 0);
		
		Label program = new Label(this.letter.getProgram());
		add(program,1,0);
		
		Label school = new Label(this.letter.getSchool());
		add(school, 2,0);
		
		add(new ViewLetterButton(this.letter), 4,0);
		add(new EditLetterButton(this.letter), 4,0);
		add(new DeleteLetterButton(this.letter.getId()), 5,0);
	}
}
