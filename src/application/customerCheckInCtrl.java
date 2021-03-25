package application;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class customerCheckInCtrl {
	
	//Changeable element via control
	@FXML
    private JFXComboBox<String> checkInChoice;
	
	@FXML
    private JFXSnackbar popup;
    
	//Execute this part of code when CustomerCheckInCtrl.fxml is open
    @FXML
    void initialize() {
    	FileHandler file = new FileHandler();
    	ArrayList<Shop> shopList = new ArrayList<Shop>();
		try {
			shopList = file.readShopFile("ShopList.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for (int i = 0; i < shopList.size(); i++) {
    		checkInChoice.getItems().add(shopList.get(i).fetchName());
    	}
    }
    
    //Run this part of code when Save button is clicked
    @FXML
    void onSaveCheckInClick(ActionEvent event) throws Exception {
    	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		FileHandler file = new FileHandler();
		try {
			CustomerSession currentSession = CustomerSession.getSession();
			file.writeRecordFile("RecordList.txt", date.format(now).toString(), time.format(now).toString(), currentSession.fetchCustomer().fetchUsername(), checkInChoice.getValue());
			popup.fireEvent(new SnackbarEvent(new JFXSnackbarLayout("Saved successfully!"), Duration.seconds(3)));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
