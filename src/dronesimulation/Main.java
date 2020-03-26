package dronesimulation;

import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
        Parent root = FXMLLoader.load(getClass().getResource("simulation.fxml"));
        primaryStage.setTitle("Drone Simulation");
        
        //GUI Setup
        /* MAIN SCREEN
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
        */
        
        /* CUSTOM SIMULATION SETTINGS */
        
        Label title = new Label("Setup/Custom Simulation");
        title.setTranslateY(-160);
        title.setFont(new Font("Arial", 25));
        
        Label orderTypes = new Label("Order Types");
        orderTypes.setTranslateX(-150);
        orderTypes.setTranslateY(-100);
        orderTypes.setFont(new Font("Arial", 15));
        
        Label orderFrequency = new Label("Order Frequency");
        orderFrequency.setTranslateX(205);
        orderFrequency.setTranslateY(-100);
        orderFrequency.setFont(new Font("Arial", 15));
        
        Rectangle r = new Rectangle();
        r.setTranslateX(-150);
        r.setTranslateY(25);
        r.setWidth(400);
        r.setHeight(200);
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(2);
        
        Rectangle r2 = new Rectangle();
        r2.setTranslateX(205);
        r2.setTranslateY(5);
        r2.setWidth(300);
        r2.setHeight(160);
        r2.setArcWidth(20);
        r2.setArcHeight(20);
        r2.setFill(Color.TRANSPARENT);
        r2.setStroke(Color.BLACK);
        r2.setStrokeWidth(2);
        
        Label burgers = new Label("Burgers");
        burgers.setTranslateX(-300);
        burgers.setTranslateY(-50);
        burgers.setFont(new Font("Arial", 15));
        
        Label fries = new Label("Fries");
        fries.setTranslateX(-230);
        fries.setTranslateY(-50);
        fries.setFont(new Font("Arial", 15));
        
        Label drinks = new Label("Drinks");
        drinks.setTranslateX(-160);
        drinks.setTranslateY(-50);
        drinks.setFont(new Font("Arial", 15));
        
        Label probability = new Label("Probability");
        probability.setTranslateX(-80);
        probability.setTranslateY(-50);
        probability.setFont(new Font("Arial", 15));
        
        Label weight = new Label("Weight");
        weight.setTranslateX(0);
        weight.setTranslateY(-50);
        weight.setFont(new Font("Arial", 15));
        
        //Text Fields
        //Burgers
        TextField burgers1 = new TextField();
        burgers1.setTranslateX(-300);
        burgers1.setTranslateY(-20);
        burgers1.setMaxWidth(40);
        
        TextField burgers2 = new TextField();
        burgers2.setTranslateX(-300);
        burgers2.setTranslateY(20);
        burgers2.setMaxWidth(40);
        
        TextField burgers3 = new TextField();
        burgers3.setTranslateX(-300);
        burgers3.setTranslateY(60);
        burgers3.setMaxWidth(40);
        
        //Fries
        TextField fries1 = new TextField();
        fries1.setTranslateX(-230);
        fries1.setTranslateY(-20);
        fries1.setMaxWidth(40);
        
        TextField fries2 = new TextField();
        fries2.setTranslateX(-230);
        fries2.setTranslateY(20);
        fries2.setMaxWidth(40);
        
        TextField fries3 = new TextField();
        fries3.setTranslateX(-230);
        fries3.setTranslateY(60);
        fries3.setMaxWidth(40);
        
        //Drinks
        TextField drinks1 = new TextField();
        drinks1.setTranslateX(-160);
        drinks1.setTranslateY(-20);
        drinks1.setMaxWidth(40);
        
        TextField drinks2 = new TextField();
        drinks2.setTranslateX(-160);
        drinks2.setTranslateY(20);
        drinks2.setMaxWidth(40);
        
        TextField drinks3 = new TextField();
        drinks3.setTranslateX(-160);
        drinks3.setTranslateY(60);
        drinks3.setMaxWidth(40);
        
        //Probability
        TextField probability1 = new TextField();
        probability1.setTranslateX(-80);
        probability1.setTranslateY(-20);
        probability1.setMaxWidth(40);
        
        TextField probability2 = new TextField();
        probability2.setTranslateX(-80);
        probability2.setTranslateY(20);
        probability2.setMaxWidth(40);
        
        TextField probability3 = new TextField();
        probability3.setTranslateX(-80);
        probability3.setTranslateY(60);
        probability3.setMaxWidth(40);
        
        //Weight
        TextField weight1 = new TextField();
        weight1.setTranslateX(0);
        weight1.setTranslateY(-20);
        weight1.setMaxWidth(40);
        
        TextField weight2 = new TextField();
        weight2.setTranslateX(0);
        weight2.setTranslateY(20);
        weight2.setMaxWidth(40);
        
        TextField weight3 = new TextField();
        weight3.setTranslateX(0);
        weight3.setTranslateY(60);
        weight3.setMaxWidth(40);
        
        //Order Frequency Section
        Label hour = new Label("Hour");
        hour.setTranslateX(90);
        hour.setTranslateY(-50);
        hour.setFont(new Font("Arial", 15));
        
        Label numOrders = new Label("# of Orders");
        numOrders.setTranslateX(290);
        numOrders.setTranslateY(-50);
        numOrders.setFont(new Font("Arial", 15));
        
        Rectangle r3 = new Rectangle();
        r3.setTranslateX(205);
        r3.setTranslateY(-35);
        r3.setWidth(297);
        r3.setHeight(3);
        r3.setStroke(Color.BLACK);
        
        Label hour1 = new Label("1");
        hour1.setTranslateX(90);
        hour1.setTranslateY(-15);
        hour1.setFont(new Font("Arial", 15));
        
        Label hour2 = new Label("2");
        hour2.setTranslateX(90);
        hour2.setTranslateY(10);
        hour2.setFont(new Font("Arial", 15));
        
        Label hour3 = new Label("3");
        hour3.setTranslateX(90);
        hour3.setTranslateY(35);
        hour3.setFont(new Font("Arial", 15));
        
        Label hour4 = new Label("4");
        hour4.setTranslateX(90);
        hour4.setTranslateY(60);
        hour4.setFont(new Font("Arial", 15));
        
        TextField hourField1 = new TextField();
        hourField1.setTranslateX(290);
        hourField1.setTranslateY(-15);
        hourField1.setMaxWidth(40);
        
        TextField hourField2 = new TextField();
        hourField2.setTranslateX(290);
        hourField2.setTranslateY(10);
        hourField2.setMaxWidth(40);
        
        TextField hourField3 = new TextField();
        hourField3.setTranslateX(290);
        hourField3.setTranslateY(35);
        hourField3.setMaxWidth(40);
        
        TextField hourField4 = new TextField();
        hourField4.setTranslateX(290);
        hourField4.setTranslateY(60);
        hourField4.setMaxWidth(40);
        
        //Buttons
        Button addOrder = new Button("Add Order");
        addOrder.setTranslateX(-290);
        addOrder.setTranslateY(150);
        
        Button deleteSelectedRow = new Button("Delete Selected Row");
        deleteSelectedRow.setTranslateX(-165);
        deleteSelectedRow.setTranslateY(150);
        
        Button startSimulation = new Button("Start Simulation");
        startSimulation.setTranslateX(-25);
        startSimulation.setTranslateY(150);
        
        //Add elements to layout/view
        StackPane layout= new StackPane();
        layout.getChildren().add(title);
        layout.getChildren().add(orderTypes);
        layout.getChildren().add(orderFrequency);
        layout.getChildren().add(r);
        layout.getChildren().add(r2);
        layout.getChildren().add(burgers);
        layout.getChildren().add(fries);
        layout.getChildren().add(drinks);
        layout.getChildren().add(probability);
        layout.getChildren().add(weight);
        layout.getChildren().add(burgers1);
        layout.getChildren().add(burgers2);
        layout.getChildren().add(burgers3);
        layout.getChildren().add(fries1);
        layout.getChildren().add(fries2);
        layout.getChildren().add(fries3);
        layout.getChildren().add(drinks1);
        layout.getChildren().add(drinks2);
        layout.getChildren().add(drinks3);
        layout.getChildren().add(probability1);
        layout.getChildren().add(probability2);
        layout.getChildren().add(probability3);
        layout.getChildren().add(weight1);
        layout.getChildren().add(weight2);
        layout.getChildren().add(weight3);
        layout.getChildren().add(hour);
        layout.getChildren().add(numOrders);
        layout.getChildren().add(r3);
        layout.getChildren().add(hour1);
        layout.getChildren().add(hour2);
        layout.getChildren().add(hour3);
        layout.getChildren().add(hour4);
        layout.getChildren().add(hourField1);
        layout.getChildren().add(hourField2);
        layout.getChildren().add(hourField3);
        layout.getChildren().add(hourField4);
        layout.getChildren().add(addOrder);
        layout.getChildren().add(deleteSelectedRow);
        layout.getChildren().add(startSimulation);
        
        //Create and Set the Scene
        Scene scene1 = new Scene(layout, 750, 400);
        primaryStage.setScene(scene1);
        
        //Show it
        primaryStage.show();
        
    }

    public static void main(String[] args) {
    	
        launch(args);
        
    }
    
}
