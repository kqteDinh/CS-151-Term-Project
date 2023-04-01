package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AfterResetFPWController {
	@FXML
    private Button loginbutton;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField newpassword;
    
    public void userAfterReset (ActionEvent event) throws IOException {
        checkResetPW();
}
    private void checkResetPW() throws IOException {
//        Main m = new Main();
        if(username.getText().toString().equals("admin") && newpassword.getText().equals("456")) {
            wrongLogIn.setText("Success!");
}
        else if(username.getText().isEmpty() && newpassword.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }

        else {
            wrongLogIn.setText("Wrong username or password!");
        }
}
}
