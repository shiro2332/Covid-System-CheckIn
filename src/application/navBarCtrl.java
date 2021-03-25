package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class navBarCtrl {
	@FXML
		private BorderPane NavBar;
	
    
    @FXML
    void onCheckInButtonClick(ActionEvent event) {
    	paneControl.changePane("CustomerCheckIn.fxml", NavBar);
    }

    @FXML
    void onCheckInHistoryButtonClick(ActionEvent event) {
    	paneControl.changePane("CustomerCheckInHistory.fxml", NavBar);
    }

    @FXML
    void onLogoutButtonClick(ActionEvent event) throws IOException {
    	SceneHandler sceneHandler = new SceneHandler("SignIn.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
		sceneHandler.showWindow();
    }

    @FXML
    void onMyStatusButtonClick(ActionEvent event) {
    	paneControl.changePane("CustomerStatus.fxml", NavBar);
    }
    
    @FXML
    void initialize() {
    	paneControl.changePane("CustomerStatus.fxml", NavBar);
    }
    
    

}
