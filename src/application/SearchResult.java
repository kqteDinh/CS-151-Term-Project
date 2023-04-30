package application;

import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;


public class SearchResult extends GridPane {
	private Letter letter;
	
	// Display search results along with UI buttons to edit, view, or delete.
	public SearchResult(Letter letter) {
		this.letter = letter;
		Label name = new Label(this.letter.getName());
		add(name, 0, 0);
		
		Label program = new Label(this.letter.getProgram());
		add(program,1,0);
		
		Label school = new Label(this.letter.getSchool());
		add(school, 2,0);
		
		add(new ViewLetterButton(this.letter), 3,0);
		add(new EditLetterButton(this.letter), 4,0);
		add(new DeleteLetterButton(this.letter.getId()), 5,0);
		
		for (int i = 0; i <= 6; i++) {
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100/6);
			getColumnConstraints().add(column);
		}
		setHgap(5);
		setPadding(new Insets(0, 0, 10, 0)); 
	}
}
