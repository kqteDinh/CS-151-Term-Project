package application;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
public class LogInController {
    public static LogInController instance;

	 	@FXML
	    private Button loginbutton;
	    @FXML
	    private Label wrongLogIn;
	    @FXML
	    private TextField username;
	    @FXML
	    public PasswordField password;
	    @FXML
	

	    public void userLogIn(ActionEvent event) throws IOException {
	        checkLogin();

	    }

	    private void checkLogin() throws IOException {
	        Main m = new Main();
	        if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
	            wrongLogIn.setText("Success!");

	            m.changeScene("afterLogin.fxml");
	        }

	        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
	            wrongLogIn.setText("Please enter your data.");
	        }


	        else {
	            wrongLogIn.setText("Wrong username or password!");
	        }
	    }
}
