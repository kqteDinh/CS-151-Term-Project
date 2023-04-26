package application;

import java.sql.SQLException;

import javafx.scene.control.Button;

public class FinalizeButton extends Button {
	
	
	public FinalizeButton(Letter letter) {
		this.setText("Finalize and Save");
		this.setOnAction(event -> {
			try {
				SQLiteHelper.getHelper().insertLetter(letter);
				Main.changeScene("home");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
