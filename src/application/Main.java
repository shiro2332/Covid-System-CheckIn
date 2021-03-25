package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//JavaFX Main Class
public class Main extends Application {

    private Parent root;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        try {
            this.root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            this.scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Mai Kesihatan");
            stage.setResizable(false);
            
            stage.show();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}	