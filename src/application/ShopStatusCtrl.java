package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShopStatusCtrl {

    @FXML
    private Label shopNameLabel;

    @FXML
    private Label shopPhoneLabel;

    @FXML
    private Label shopStatus;

    @FXML
    private Label shopManagerLabel;
    
    @FXML
    public void initialize() {
    	ShopSession currentSession = ShopSession.getSession();
    	shopNameLabel.setText(currentSession.fetchShop().fetchName());
        shopPhoneLabel.setText(currentSession.fetchShop().fetchPhone());
        shopManagerLabel.setText(currentSession.fetchShop().fetchManager());
        shopStatus.setText(currentSession.fetchShop().fetchStatus());
    }
}
