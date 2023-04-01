package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AfterLogInController {
	@FXML
	private Button logoutbutton;

	@FXML
	private Button savebutton;
	
	@FXML
	private Label wrongReset;
	
	@FXML
	private PasswordField factorypassword;
	
	@FXML
	private PasswordField newpassword ;
	
	@FXML
	private PasswordField reenternewpassword;


	
	
	 public void userSave (ActionEvent event) throws IOException {
	        checkReset();

	    }
	 // Remember to bind checkReset to save button
	 private void checkReset() throws IOException {
	        Main n = new Main();

	        if(factorypassword.getText().equals("123")){
	        	if(newpassword.getText().equals(reenternewpassword.getText())){
	        		factorypassword = reenternewpassword;
	        		System.out.println(factorypassword);
	        		wrongReset.setText("Your password has been reset successfully!" );
	        		n.changeScene("AfterResetFPW.fxml");
	        	}
	        	else wrongReset.setText("Your re-enter new password is not match!");
	        }
	        else wrongReset.setText("Your factory password is not correct!");
	 }
	    public void userLogOut(ActionEvent event) throws IOException {
	        Main m = new Main();
	        m.changeScene("LogIn.fxml");

	    }
}
