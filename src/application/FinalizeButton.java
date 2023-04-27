package application;

import java.sql.SQLException;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class FinalizeButton extends Button {
	
	
	public FinalizeButton(Letter letter) {
		this.setText("Finalize and Save");
		this.setMinWidth(100);
 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
		this.setOnAction(event -> {
			try {
				if(letter.getId() == Integer.MAX_VALUE) {
					SQLiteHelper.getHelper().insertLetter(letter);
				}
				else
					SQLiteHelper.getHelper().updateLetter(letter);
				Main.changeScene("home");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
