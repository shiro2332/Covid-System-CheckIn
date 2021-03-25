package application;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class signInCtrl {
	private Customer customerSession;
	private Shop shopSession;
	
    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXPasswordField passwordTextField;
    
    @FXML
    private AnchorPane loginPane;
    
    @FXML
    private JFXSnackbar popup;
    
    @FXML
    void onRegisterButtonClicked(ActionEvent event) throws IOException {
    	SceneHandler sceneHandler = new SceneHandler("RegisterAccount.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
		sceneHandler.showWindow();
    }
    
    @FXML
    void onSignInButtonClicked(ActionEvent event) throws IOException {
    	FileHandler fh = new FileHandler();
    	ArrayList<User> userList = new ArrayList<User>();
    	ArrayList<Customer> customerList = new ArrayList<Customer>();
    	ArrayList<Shop> shopList = new ArrayList<Shop>();
		try {
			userList = fh.readUserFile("UserList.txt");
			customerList = fh.readCustomerFile("CustomerList.txt");
			shopList = fh.readShopFile("ShopList.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < userList.size(); i++) {
			if(nameTextField.getText().equals(userList.get(i).fetchUsername()) && passwordTextField.getText().equals(userList.get(i).fetchPassword())) {
				for(int j = 0; j < customerList.size(); j++) {
					if(nameTextField.getText().equals(customerList.get(j).fetchUsername())) {
						customerSession = new Customer(customerList.get(j).fetchUsername(), customerList.get(j).fetchPhoneNum(), customerList.get(j).fetchStatus());
						CustomerSession currentSession = CustomerSession.getSession();
						currentSession.setCustomer(customerSession);
						SceneHandler sceneHandler = new SceneHandler("CustomerMenu.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
			    		sceneHandler.showWindow();
					}	
				}
					
				for(int k = 0; k < shopList.size(); k++) {
					if(nameTextField.getText().equals(shopList.get(k).fetchName())) {
						shopSession = new Shop(shopList.get(k).fetchName(), shopList.get(k).fetchPhone(), shopList.get(k).fetchStatus(), shopList.get(k).fetchManager());
						ShopSession currentSession = ShopSession.getSession();
						currentSession.setShop(shopSession);
						SceneHandler sceneHandler = new SceneHandler("ShopMenu.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
			    		sceneHandler.showWindow();
					}
				}
	    	}
		}
		
    	popup.fireEvent(new SnackbarEvent(new JFXSnackbarLayout("Invalid username or Password!"), Duration.seconds(3)));
    }
}

