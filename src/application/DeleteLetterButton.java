package application;

import javafx.scene.control.Button;

import javafx.scene.control.ButtonType;

import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DeleteLetterButton extends Button {

	private SQLiteHelper helper = SQLiteHelper.getHelper();
	private int id;

    public DeleteLetterButton(int id) {
        super("Delete");

        this.id = id;

        setOnAction(event -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Are you sure you want to delete this recommendation letter?");
            alert.setContentText("This action cannot be undone.");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    deleteLetter();
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
