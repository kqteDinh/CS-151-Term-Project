package application;

 import javafx.scene.layout.Background;
 import javafx.scene.layout.BackgroundFill;
 import javafx.scene.layout.HBox;
 import javafx.scene.layout.VBox;
 import javafx.scene.paint.Color;
 import javafx.geometry.Pos;
 import javafx.scene.control.Label;
 import javafx.scene.text.Font;
 import javafx.geometry.Insets;


 public class HomePane extends VBox {
 	// This pane lets the user access the create letter or letter search features once they log in.
	HomePane() {
 		HBox bannerBox = new HBox();
 		Label titleText = new Label("Premium Letter Simulator");
         titleText.setLayoutX(220);
         titleText.setLayoutY(57);
         titleText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
         titleText.setFont(new Font("Times New Roman Bold Italic", 40));
         bannerBox.getChildren().add(titleText);
         bannerBox.setAlignment(Pos.CENTER);
         bannerBox.setBackground(new Background(new BackgroundFill(Color.web("#87CEEB",1.0), null, null)));

 		VBox buttonsBox = new VBox();
 		SearchButton searchButton = new SearchButton();
 		searchButton.setMinWidth(200);
 		buttonsBox.getChildren().addAll(new NewLetterButton(), searchButton);
 		buttonsBox.setSpacing(10);
 		HBox contentBox = new HBox();
 		Label greetingLabel = new Label("Welcome to PLS, Please start your journey with create a new letter!");
 		greetingLabel.setWrapText(true);
 		greetingLabel.setFont(new Font("Times New Roman Italic", 35));
 		greetingLabel.setLayoutX(34.0);
 		greetingLabel.setLayoutY(72.0);
 		greetingLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
 		contentBox.getChildren().addAll(buttonsBox, greetingLabel);
 		contentBox.setAlignment(Pos.CENTER);
 		contentBox.setSpacing(100);
 		contentBox.setPadding(new Insets(0, 100, 0, 100));

 		this.getChildren().addAll(bannerBox, contentBox);
 		this.setSpacing(40);
 		this.setPadding(new Insets(10));
 	}
 }
