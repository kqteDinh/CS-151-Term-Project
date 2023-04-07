package application;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.util.HashMap;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class SelectorPane extends GridPane {
	private static SQLiteHelper sql;
	
	private List<Characteristic> characteristics;
	
	private final Map<Characteristic, Option> choices = new HashMap<>();

	public SelectorPane() {
		sql = SQLiteHelper.getHelper();
		try {
			characteristics = sql.getAllCharacteristics();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setHgap(10);
		setVgap(5);
		
		int i = 0;
		
        for (Characteristic characteristic : characteristics) {
        	Label label = new Label(characteristic.getChoice().getName()+ ": ");
            ComboBox<Option> comboBox = new ComboBox<>();
        	comboBox.getItems().addAll(characteristic.getOptions());
        	comboBox.setPromptText("Select an option");
            comboBox.setOnAction(event -> choices.put(characteristic, comboBox.getValue()));
            add(label, 0, i);
            add(comboBox, 1, i);
            i++;
        }
	}
}
