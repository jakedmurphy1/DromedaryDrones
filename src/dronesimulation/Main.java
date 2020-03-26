package dronesimulation;

import javafx.scene.control.*;
import javafx.scene.text.*;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
	
	public int capacity;
	//test
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
        Parent root = FXMLLoader.load(getClass().getResource("simulation.fxml"));
        primaryStage.setTitle("Drone Simulation");
        
        //GUI Setup
        Button startSimulation = new Button("Start Simulation");
        startSimulation.setMaxSize(200, 50);
        startSimulation.setTranslateX(110);
        
        Button simulationSettings = new Button("Simulation Setup/Settings");
        simulationSettings.setMaxSize(200, 50);
        simulationSettings.setTranslateX(-110);
        
        Button defaultSettings = new Button("View Default Settings");
        defaultSettings.setMaxSize(200, 50);
        defaultSettings.setTranslateY(80);
        
        Label title = new Label("Dromedary Drones Food Delivery Simulation");
        title.setTranslateY(-160);
        title.setFont(new Font("Arial", 25));
        
        Label description = new Label("Welcome to the drone delivery simulation by Dromedary Drones! Click ‘Start Simulation’ to begin a new simulation with the default settings, or make a custom simulation in the settings tab.");
        description.setTranslateY(-100);
        description.setWrapText(true);
        description.setMaxWidth(600);
        description.setTextAlignment(TextAlignment.CENTER);
        
        //Create Layout
        StackPane layout= new StackPane();
        
        //Add Elements to Layout
        layout.getChildren().add(startSimulation);
        layout.getChildren().add(simulationSettings);
        layout.getChildren().add(defaultSettings);
        layout.getChildren().add(title);
        layout.getChildren().add(description);
        
        //Create and Set the Scene
        Scene scene1 = new Scene(layout, 750, 400);
        primaryStage.setScene(scene1);
        
        //Show it
        primaryStage.show();
        
    }

    public static void main(String[] args) {
    	
        //launch(args);
    	
    	Order a = new Order(1, 1, 1, 0.1, 1);
    	Order b = new Order(2, 2, 2, 0.1, 2);
    	Order c = new Order(3, 3, 3, 0.1, 3);
    	Order d = new Order(4, 4, 4, 0.1, 4);
    	Order e = new Order(5, 5, 5, 0.1, 5);
    	
    	Menu m = new Menu();
    	m.addOrder(a);
    	m.addOrder(b);
    	m.addOrder(c);
    	m.addOrder(d);
    	m.addOrder(e);
    	
    	Knapsack test = new Knapsack(m, 3);
    	
    	ArrayList<Order> myArray = test.solve();
    	
    	for(Order o : myArray) {
    		System.out.println(o.getOrderWeight());
    	}
    	

        
    }
    
}
