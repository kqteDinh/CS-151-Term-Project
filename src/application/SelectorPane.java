package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.SQLException;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class SelectorPane extends GridPane {
	private static SQLiteHelper sql;
	
	private List<Characteristic> characteristics;
	
	private Label fNameL;
	private TextField fNameC;
	private Label lNameL;
	private TextField lNameC;
	private Label genderL;
	private ComboBox<Option> genderC;
	private Label schoolL;
	private TextField schoolC;
	private Label dateL;
	private DatePicker dateC;
	private Label programL;
	private ComboBox<Option> programC;
	private Label fCourseL;
	private ComboBox<Option> fCourseC;
	private Label fGradeL;
	private TextField fGradeC;
	private Label fSemL;
	private ComboBox<Option> fSemC;
	private Label yearL;
	private TextField yearC;
	private Label coursesL;
	private ListView<Option> coursesC;
	private Label gradesL;
	private TextField gradesC;
	private Label personalL;
	private ListView<Option> personalC;
	private Label academicL;
	private ListView<Option> academicC;

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
		
		fNameL = new Label(characteristics.get(0).getChoice().getName()+ ": ");
		fNameC = new TextField();
		fNameL.setMinWidth(180);
		add(fNameL, 0, 0);
		add(fNameC, 1, 0);
		
		lNameL = new Label(characteristics.get(1).getChoice().getName()+ ": ");
		lNameC = new TextField();
		add(lNameL, 0, 1);
		add(lNameC, 1, 1);
		
		genderL = new Label(characteristics.get(2).getChoice().getName()+ ": ");
		genderC = new ComboBox<>();
		genderC.getItems().addAll(characteristics.get(2).getOptions());
		genderC.setPromptText("Select an option");
		add(genderL, 0, 2);
		add(genderC, 1, 2);
		
		schoolL = new Label(characteristics.get(3).getChoice().getName()+ ": ");
		schoolC = new TextField();
		add(schoolL, 0, 3);
		add(schoolC, 1, 3);
		
		dateL = new Label(characteristics.get(4).getChoice().getName()+ ": ");
		dateC = new DatePicker();
		add(dateL, 0, 4);
		add(dateC, 1, 4);
		
		programL = new Label(characteristics.get(5).getChoice().getName()+ ": ");
		programC = new ComboBox<>();
		programC.getItems().addAll(characteristics.get(5).getOptions());
		programC.setPromptText("Select an option");
		add(programL, 0, 5);
		add(programC, 1, 5);
		
		fCourseL = new Label(characteristics.get(6).getChoice().getName()+ ": ");
		fCourseC = new ComboBox<>();
		fCourseC.getItems().addAll(characteristics.get(6).getOptions());
		fCourseC.setPromptText("Select an option");
		VBox fGradeBox = new VBox();
		fGradeL = new Label("Grade Earned:");
		fGradeC = new TextField();
		fGradeBox.getChildren().addAll(fGradeL, fGradeC);
		add(fCourseL, 0, 6);
		add(fCourseC, 1, 6);
        add(fGradeBox, 2, 6);
		
		
		fSemL = new Label(characteristics.get(7).getChoice().getName()+ ": ");
		fSemC = new ComboBox<>();
		fSemC.getItems().addAll(characteristics.get(7).getOptions());
		fSemC.setPromptText("Select an option");
		VBox yearBox = new VBox();
		yearL = new Label("Year Taken:");
		yearC = new TextField();
		yearBox.getChildren().addAll(yearL, yearC);
		add(fSemL, 0, 7);
		add(fSemC, 1, 7);
        add(yearBox, 2, 7);
		
		coursesL = new Label(characteristics.get(8).getChoice().getName()+ ": ");
		coursesC = new ListView<>();
		coursesC.getItems().addAll(characteristics.get(8).getOptions());
		coursesC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		VBox gradesBox = new VBox();
		gradesL = new Label("Grades (in order, separate with commas):");
		gradesL.setMinWidth(250);
		gradesC = new TextField();
		gradesBox.getChildren().addAll(gradesL, gradesC);
		add(coursesL, 0, 8);
		add(coursesC, 1, 8);
        add(gradesBox, 2, 8);
		
		personalL = new Label(characteristics.get(9).getChoice().getName()+ ": ");
		personalC = new ListView<>();
		personalC.getItems().addAll(characteristics.get(9).getOptions());
		personalC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		add(personalL, 0, 9);
		add(personalC, 1, 9);
        
		academicL = new Label(characteristics.get(10).getChoice().getName()+ ": ");
		academicC = new ListView<>();
		academicC.getItems().addAll(characteristics.get(10).getOptions());
		academicC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		add(academicL, 0, 10);
		add(academicC, 1, 10);
		
		Button compile = new Button("Compile");
        compile.setOnAction(event -> compileLetter());
        add(compile, 2, 10);
	}
	
	public void flagRequiredFields() {
		
		// TODO validate all fields!
	}
	
	public void compileLetter() {
		List<String> personalSelections = new ArrayList<String>();
		for(Option o : personalC.getSelectionModel().getSelectedItems()) {
			personalSelections.add(o.getName());
		}
		
		List<String> academicSelections = new ArrayList<String>();
		for(Option o : academicC.getSelectionModel().getSelectedItems()) {
			academicSelections.add(o.getName());
		}
		
		List<String> courseSelections = new ArrayList<String>();
		for(Option o : coursesC.getSelectionModel().getSelectedItems()) {
			courseSelections.add(o.getName());
		}
		
		List<String> grades = new ArrayList<String>(Arrays.asList(gradesC.getText().split("\\s*,\\s*")));
		
		try {
			
			String returnedLetter = LetterTemplate.compileLetter(fNameC.getText(), lNameC.getText(), 
					genderC.getValue().getName(), dateC.getValue().toString(),
					programC.getValue().getName(), fSemC.getValue().getName(), fCourseC.getValue().getName(),
					fGradeC.getText(),courseSelections, grades, 
					academicSelections, personalSelections,sql.getFaculty());
			System.out.println(returnedLetter);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO send letter and metadata to editing pane for finalization
		

	}
}
