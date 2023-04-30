package application;

import javafx.scene.control.Button;

import javafx.scene.control.ButtonType;

import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class DeleteLetterButton extends Button {

	private SQLiteHelper helper = SQLiteHelper.getHelper();
	private int id;

	// This button lets a user delete a letter, then redirects them to the home pane.
    public DeleteLetterButton(int id) {
        super("Delete");

 		this.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));
 		this.setMinWidth(100);

        this.id = id;

        setOnAction(event -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Are you sure you want to delete this recommendation letter?");
            alert.setContentText("This action cannot be undone.");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    deleteLetter();
                    Main.changeScene("home");
                }
            });
        });
    }

    private void deleteLetter() {
    	try {
			helper.deleteLetter(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
