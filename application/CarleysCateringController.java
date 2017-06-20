package application;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;



public class CarleysCateringController  implements Initializable  {
	
	@FXML
	private Label label;
	
	@FXML
	private PasswordField passwordField;
	@FXML
	private Text actiontarget;
	
	@FXML
	private Button btnFreeEstimate;
	
	
	@FXML
	private void handleSubmitButtonAction(ActionEvent  event){
		btnFreeEstimate.setText("HAWK");
	}	
		
	@Override
	public void initialize(URL url, ResourceBundle rd){
	}

}
