package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerStatusCtrl{

    @FXML
    private Label customerNameLabel;

    @FXML
    private Label customerPhoneLabel;

    @FXML
    private Label customerStatus;
    
    @FXML
    public void initialize() {
    	CustomerSession currentSession = CustomerSession.getSession();
    	customerNameLabel.setText(currentSession.fetchCustomer().fetchUsername());
        customerPhoneLabel.setText(currentSession.fetchCustomer().fetchPhoneNum());
        customerStatus.setText(currentSession.fetchCustomer().fetchStatus());
    }
}

