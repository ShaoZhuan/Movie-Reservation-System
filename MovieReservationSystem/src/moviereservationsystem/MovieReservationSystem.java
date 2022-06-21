/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moviereservationsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        loadData();
        Button btn = new Button();
        Text titleText = new Text();        
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("");       
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(titleText);
        
        Scene scene = new Scene(root, 1150, 646.88);
        
        primaryStage.setTitle("Movie Reservation System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void loadData(){
        File file = new File("movies.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String[] str = sc.nextLine().split(",");                
                Movie movie = new Movie(str[0],str[3],Integer.parseInt(str[2]),Integer.parseInt(str[1]),str[4]);
                System.out.println(movie.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovieReservationSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadData();
//        launch(args);
    }
    
}