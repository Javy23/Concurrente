package Controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	 
    @Override
    public void start(Stage primaryStage) {
 
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Sample.fxml"));
            Pane ventana = (Pane) loader.load();
            Scene scene = new Scene(ventana);

            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
            //primaryStage.setTitle("GPS Data");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}