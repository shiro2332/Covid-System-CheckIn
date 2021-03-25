package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class shopMenuCtrl {

    @FXML
    private BorderPane NavBar;
    
    @FXML
    void initialize() {
    	paneControl.changePane("ShopStatus.fxml", NavBar);
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
    	SceneHandler sceneHandler = new SceneHandler("SignIn.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
		sceneHandler.showWindow();
    }

    @FXML
    void onMyStatusClick(ActionEvent event) {
    	paneControl.changePane("ShopStatus.fxml", NavBar);
    }

}