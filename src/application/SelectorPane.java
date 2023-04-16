package application;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.util.HashMap;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        	label.setMinWidth(180);
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
                    VBox dTextBox = new VBox();
                    Label dTextLabel = new Label("Year Taken:");
                    TextField dText = new TextField();
                    dTextBox.getChildren().addAll(dTextLabel, dText);
                    add(comboBoxText, 1, i);
                    add(dTextBox, 2, i);
                    break;
        		case "multi":
                    ListView<Option> multiList = new ListView<>();
                	multiList.getItems().addAll(characteristic.getOptions());
                	multiList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//                	multiList.setMinHeight(150);
                    add(multiList, 1, i);
                    break;
        		case "multitext":
                    ListView<Option> multiListText = new ListView<>();
                	multiListText.getItems().addAll(characteristic.getOptions());
                	multiListText.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//                	multiListText.setMinHeight(100);
                    VBox mTextBox = new VBox();
                    Label mTextLabel = new Label("Grades (in order, separate with commas):");
                    mTextLabel.setMinWidth(250);
                    TextField mText = new TextField();
                    mTextBox.getChildren().addAll(mTextLabel, mText);
                    add(multiListText, 1, i);
                    add(mTextBox, 2, i);
        			break;
        		default: break;
        	}

            add(label, 0, i);
            i++;
        }
	}
}
