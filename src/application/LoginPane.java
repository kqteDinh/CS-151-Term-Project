package application;

import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginPane extends BorderPane {
	private static SQLiteHelper sql;
	
    private VBox centerPane;
    
    private PasswordField password;
    private Label errorMessage;
    private Button loginButton;
    
    private PasswordField oldPassword;
    private PasswordField newPassword;
    private PasswordField confirmPassword;
    private Button newPasswordButton;
    
    private Text welcomeText;

    public LoginPane(String choice) {
    	sql = SQLiteHelper.getHelper();
    	
        // Create the left side of the BorderPane
        AnchorPane leftPane = new AnchorPane();
        leftPane.setPrefSize(188, 400);
        leftPane.setStyle("-fx-background-color: #FFFFFF;");
        ImageView logo = new ImageView(new Image("file:./src/application/icon.png"));
        logo.setFitWidth(164);
        logo.setFitHeight(160);
        AnchorPane.setTopAnchor(logo, 65.0);
        AnchorPane.setLeftAnchor(logo, 17.0);
        Label title = new Label("Premium Letter Simulator");
        title.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 16));
        AnchorPane.setTopAnchor(title, 255.0);
        AnchorPane.setLeftAnchor(title, 20.0);
        leftPane.getChildren().addAll(logo, title);
        setLeft(leftPane);

        // Create the center of the BorderPane
        centerPane = new VBox();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setSpacing(20);
        centerPane.setPadding(new Insets(20));
        centerPane.setPrefSize(407, 400);
        centerPane.setStyle("-fx-background-color: #E0FFFF;");
    	
    	// Add contents to center.
    	switch (choice) {
    		case "change":
    			changePasswordView();
				break;
    		case "default":
    			resetDefaultView();
    			break;
    		case "login":
    		default:
    			loginView();
    			break;
    	}
    }
    
    public LoginPane() {
    	this("login");
    }
    
    private void loginView() {
        welcomeText = new Text("Welcome to our application. Please log in!");
        welcomeText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        password = new PasswordField();
        password.setPrefSize(226, 31);
        loginButton = new Button("Login");
        loginButton.setOnAction(event -> userLogin());
        loginButton.setStyle("-fx-background-color: #1E90FF;");
        loginButton.setPrefSize(133, 31);
        HBox buttonBox = new HBox(loginButton);
        buttonBox.setAlignment(Pos.CENTER);
        VBox.setVgrow(buttonBox, Priority.ALWAYS);
        errorMessage = new Label("");
        errorMessage.setPrefSize(264, 41);
        errorMessage.setTextFill(Color.color(1, 0, 0));
        centerPane.getChildren().addAll(welcomeText, passwordLabel, password, buttonBox, errorMessage);
        setCenter(centerPane);
    }
    
    private void resetDefaultView() {
        welcomeText = new Text("Welcome first time user. Please set your password!");
        welcomeText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
        Label newPasswordLabel = new Label("New password");
        newPasswordLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        newPassword = new PasswordField();
        newPassword.setPrefSize(226, 31);
        Label confirmPasswordLabel = new Label("Confirm password");
        confirmPasswordLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        confirmPassword = new PasswordField();
        confirmPassword.setPrefSize(226, 31);
        newPasswordButton = new Button("Update and Login");
        newPasswordButton.setMinWidth(100);
        newPasswordButton.setOnAction(event -> updatePassword());
        newPasswordButton.setStyle("-fx-background-color: #1E90FF;");
        newPasswordButton.setPrefSize(133, 31);
        HBox buttonBox = new HBox(newPasswordButton);
        buttonBox.setAlignment(Pos.CENTER);
        VBox.setVgrow(buttonBox, Priority.ALWAYS);
        errorMessage = new Label("");
        errorMessage.setPrefSize(264, 41);
        errorMessage.setTextFill(Color.color(1, 0, 0));
        centerPane.getChildren().addAll(welcomeText, newPasswordLabel, newPassword, confirmPasswordLabel, confirmPassword, buttonBox, errorMessage);
        setCenter(centerPane);
    }
    
    private void changePasswordView() {
        welcomeText = new Text("Change your password below.");
        welcomeText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
        Label oldPasswordLabel = new Label("Old password");
        oldPasswordLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        oldPassword = new PasswordField();
        oldPassword.setPrefSize(226, 31);
        Label newPasswordLabel = new Label("New password");
        newPasswordLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        newPassword = new PasswordField();
        newPassword.setPrefSize(226, 31);
        Label confirmPasswordLabel = new Label("Confirm password");
        confirmPasswordLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        confirmPassword = new PasswordField();
        confirmPassword.setPrefSize(226, 31);
        newPasswordButton = new Button("Change Password");
        newPasswordButton.setOnAction(event -> changePassword());
        newPasswordButton.setStyle("-fx-background-color: #1E90FF;");
        newPasswordButton.setPrefSize(133, 31);
        HBox buttonBox = new HBox(newPasswordButton);
        buttonBox.setAlignment(Pos.CENTER);
        VBox.setVgrow(buttonBox, Priority.ALWAYS);
        errorMessage = new Label("");
        errorMessage.setPrefSize(264, 41);
        errorMessage.setTextFill(Color.color(1, 0, 0));
        centerPane.getChildren().addAll(welcomeText, oldPasswordLabel, oldPassword, newPasswordLabel, newPassword, confirmPasswordLabel, confirmPassword, buttonBox, errorMessage);
        setCenter(centerPane);
    }

    private void userLogin() {
    	try {
			if(sql.checkUser(password.getText())) {
				errorMessage.setText("");
				if(sql.checkUser("p")) {
					centerPane.getChildren().clear();
					resetDefaultView();
				}
				else {
					Main.changeScene("home");
				}
			}
			else {
				if(sql.checkUser("p")) {
					errorMessage.setText("The default password is 'p'!");
				}
				else {
					errorMessage.setText("Password is not correct.");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void changePassword() {
    	try {
    		System.out.println("Comparing passwords!");
    		if(sql.checkUser(oldPassword.getText())) {
    			if(!newPassword.getText().equals("") && newPassword.getText().equals(confirmPassword.getText())) {
    				sql.updatePassword(newPassword.getText());
    				errorMessage.setText("Password updated!");
    				Main.changeScene("home");
    			}
    			else {
    				errorMessage.setText("New passwords must match and cannot be blank.");
    			}
    		}
    		else {
    			errorMessage.setText("Old password is not correct.");
    		}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void updatePassword() {
    	try {
    		System.out.println("Comparing passwords!");
			if(newPassword.getText().equals(confirmPassword.getText())) {
				sql.updatePassword(newPassword.getText());
				errorMessage.setText("Password updated!");
				Main.changeScene("home");
			}
			else {
				errorMessage.setText("Passwords do not match.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}