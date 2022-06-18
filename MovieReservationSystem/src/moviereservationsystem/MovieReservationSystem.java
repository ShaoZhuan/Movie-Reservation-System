/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moviereservationsystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MovieReservationSystem extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Text titleText = new Text();        
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            titleText.setText("Text is Changed");            
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(titleText);
        
        Scene scene = new Scene(root, 1150, 646.88);
        
        primaryStage.setTitle("Movie Reservation System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}