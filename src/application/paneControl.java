package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class paneControl{
	//Switch panel without switching scene
	public static FXMLLoader changePane(String filename, BorderPane pane) {
        URL fileURL = Main.class.getResource(filename);

        try {
            if (fileURL == null) throw new FileNotFoundException(filename + " not found!");
            FXMLLoader loader = new FXMLLoader(fileURL);
            pane.setCenter(loader.load());
            return loader;
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

