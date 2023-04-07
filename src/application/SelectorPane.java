package application;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.util.HashMap;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

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
        	switch (characteristic.getChoice().getType()) {
        		case "text": 
        			TextField textField = new TextField();
        			add(textField, 1, i);
        			break;
        		case "dropdown": 
                    ComboBox<Option> comboBox = new ComboBox<>();
                	comboBox.getItems().addAll(characteristic.getOptions());
                	comboBox.setPromptText("Select an option");
                    comboBox.setOnAction(event -> choices.put(characteristic, comboBox.getValue()));
                    add(comboBox, 1, i);
                    break;
        		case "date":
        			DatePicker datePicker = new DatePicker();
        			add(datePicker, 1, i);
        			break;
        		case "droptext":
                    ComboBox<Option> comboBoxText = new ComboBox<>();
                	comboBoxText.getItems().addAll(characteristic.getOptions());
                	comboBoxText.setPromptText("Select an option");
                    comboBoxText.setOnAction(event -> choices.put(characteristic, comboBoxText.getValue()));
                    TextField dText = new TextField();
                    add(comboBoxText, 1, i);
                    add(dText, 2, i);
                    break;
        		case "multi":
                    ListView<Option> multiList = new ListView<>();
                	multiList.getItems().addAll(characteristic.getOptions());
                	multiList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    add(multiList, 1, i);
                    break;
        		case "multitext":
                    ListView<Option> multiListText = new ListView<>();
                	multiListText.getItems().addAll(characteristic.getOptions());
                	multiListText.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                	TextField mText = new TextField();
                    add(multiListText, 1, i);
                    add(mText, 2, i);
        			break;
        		default: break;
        	}

            add(label, 0, i);
            i++;
        }
	}
}
