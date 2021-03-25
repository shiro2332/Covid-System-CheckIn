package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RegisterCtrl {

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField phoneTextField;

    @FXML
    private JFXButton registerButton;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXSnackbar popupReg;

    @FXML
    void onBackButtonClicked(ActionEvent event) throws IOException {
    	SceneHandler sceneHandler = new SceneHandler("SignIn.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
		sceneHandler.showWindow();
    }

    @FXML
    void onRegisterButtonClicked(ActionEvent event) throws IOException{
    	if (phoneTextField.getText().matches(".*[a-zA-Z]+.*")) {
    		popupReg.fireEvent(new SnackbarEvent(new JFXSnackbarLayout("Phone number contain alphabets!"), Duration.seconds(3)));
    	}
    	else {
    		FileHandler fh = new FileHandler();
        	try {
    			fh.writeCustomerFile("CustomerList.txt", nameTextField.getText(), phoneTextField.getText(), "Normal");
    			fh.writeUserFile("UserList.txt", nameTextField.getText(), passwordTextField.getText());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	popupReg.fireEvent(new SnackbarEvent(new JFXSnackbarLayout("Account created!"), Duration.seconds(3)));
    	}
    }
}
