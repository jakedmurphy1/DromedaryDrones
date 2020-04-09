package dronesimulation;

import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Main extends Application {
	
	int addOrderYAxis = 165;
	int numAddOrders = 0;
	
	String userDir = System.getProperty("user.dir");
	String fileLoc = userDir + "\\customSettings.txt";
	
	FileWriter fw;
	PrintWriter pw;
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	//Do we need this??
        //Parent root = FXMLLoader.load(getClass().getResource("simulation.fxml"));
        primaryStage.setTitle("Drone Simulation");
        
        //GUI Setup
        
        /* WELCOME SCREEN */
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
        
        Label description = new Label("Welcome to the drone delivery simulation by Dromedary Drones! Click �Start Simulation� to begin a new simulation with the default settings, or make a custom simulation in the settings tab.");
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
        
    

  
        
        /* CUSTOM SIMULATION SETTINGS SCREEN */
        Button customSimulationBackButton = new Button("Back");
        customSimulationBackButton.setTranslateX(-320);
        customSimulationBackButton.setTranslateY(-170);
        
        Label simulationSettingsTitle = new Label("Setup/Custom Simulation");
        simulationSettingsTitle.setTranslateY(-160);
        simulationSettingsTitle.setFont(new Font("Arial", 25));
        
        Label orderTypes = new Label("Order Types");
        orderTypes.setTranslateX(-150);
        orderTypes.setTranslateY(-100);
        orderTypes.setFont(new Font("Arial", 15));
        
        Label orderFrequency = new Label("Order Frequency");
        orderFrequency.setTranslateX(205);
        orderFrequency.setTranslateY(-100);
        orderFrequency.setFont(new Font("Arial", 15));
        
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
        burgers.setTranslateX(25);
        burgers.setTranslateY(15);
        burgers.setFont(new Font("Arial", 15));
        
        Label fries = new Label("Fries");
        fries.setTranslateX(100);
        fries.setTranslateY(15);
        fries.setFont(new Font("Arial", 15));
        
        Label drinks = new Label("Drinks");
        drinks.setTranslateX(160);
        drinks.setTranslateY(15);
        drinks.setFont(new Font("Arial", 15));
        
        Label probability = new Label("Probability");
        probability.setTranslateX(230);
        probability.setTranslateY(15);
        probability.setFont(new Font("Arial", 15));
        
        Label weight = new Label("Weight");
        weight.setTranslateX(320);
        weight.setTranslateY(15);
        weight.setFont(new Font("Arial", 15));
        
        //Text Fields
        //Burgers
        TextField burgers1 = new TextField();
        burgers1.setTranslateX(30);
        burgers1.setTranslateY(45);
        burgers1.setMaxWidth(40);
        
        TextField burgers2 = new TextField();
        burgers2.setTranslateX(30);
        burgers2.setTranslateY(85);
        burgers2.setMaxWidth(40);
        
        TextField burgers3 = new TextField();
        burgers3.setTranslateX(30);
        burgers3.setTranslateY(125);
        burgers3.setMaxWidth(40);
        
        //Fries
        TextField fries1 = new TextField();
        fries1.setTranslateX(97);
        fries1.setTranslateY(45);
        fries1.setMaxWidth(40);
        
        TextField fries2 = new TextField();
        fries2.setTranslateX(97);
        fries2.setTranslateY(85);
        fries2.setMaxWidth(40);
        
        TextField fries3 = new TextField();
        fries3.setTranslateX(97);
        fries3.setTranslateY(125);
        fries3.setMaxWidth(40);
        
        //Drinks
        TextField drinks1 = new TextField();
        drinks1.setTranslateX(162);
        drinks1.setTranslateY(45);
        drinks1.setMaxWidth(40);
        
        TextField drinks2 = new TextField();
        drinks2.setTranslateX(162);
        drinks2.setTranslateY(85);
        drinks2.setMaxWidth(40);
        
        TextField drinks3 = new TextField();
        drinks3.setTranslateX(162);
        drinks3.setTranslateY(125);
        drinks3.setMaxWidth(40);
        
        //Probability
        TextField probability1 = new TextField();
        probability1.setTranslateX(245);
        probability1.setTranslateY(45);
        probability1.setMaxWidth(40);
        
        TextField probability2 = new TextField();
        probability2.setTranslateX(245);
        probability2.setTranslateY(85);
        probability2.setMaxWidth(40);
        
        TextField probability3 = new TextField();
        probability3.setTranslateX(245);
        probability3.setTranslateY(125);
        probability3.setMaxWidth(40);
        
        //Weight
        TextField weight1 = new TextField();
        weight1.setTranslateX(324);
        weight1.setTranslateY(45);
        weight1.setMaxWidth(40);
        
        TextField weight2 = new TextField();
        weight2.setTranslateX(324);
        weight2.setTranslateY(85);
        weight2.setMaxWidth(40);
        
        TextField weight3 = new TextField();
        weight3.setTranslateX(324);
        weight3.setTranslateY(125);
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
        
        Button startSimulationSettings = new Button("Start Simulation");
        startSimulationSettings.setTranslateX(-25);
        startSimulationSettings.setTranslateY(150);
        
        //Set scroll pane
        Pane pane = new Pane();
        pane.setPrefHeight(200);
        pane.setPrefWidth(385);
        pane.getChildren().add(burgers);
        pane.getChildren().add(fries);
        pane.getChildren().add(drinks);
        pane.getChildren().add(probability);
        pane.getChildren().add(weight);
        pane.getChildren().add(burgers1);
        pane.getChildren().add(burgers2);
        pane.getChildren().add(burgers3);
        pane.getChildren().add(fries1);
        pane.getChildren().add(fries2);
        pane.getChildren().add(fries3);
        pane.getChildren().add(drinks1);
        pane.getChildren().add(drinks2);
        pane.getChildren().add(drinks3);
        pane.getChildren().add(probability1);
        pane.getChildren().add(probability2);
        pane.getChildren().add(probability3);
        pane.getChildren().add(weight1);
        pane.getChildren().add(weight2);
        pane.getChildren().add(weight3);
        //pane.setStyle("-fx-background-color: #87CEFA;");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setTranslateX(-150);
        scrollPane.setTranslateY(25);
        scrollPane.setMaxWidth(400);
        scrollPane.setMaxHeight(200);
        scrollPane.setContent(pane);
        
        //Add More Orders TextField array
        TextField addBurgers[] = new TextField[99];
        TextField addFries[] = new TextField[99];
        TextField addDrinks[] = new TextField[99];
        TextField addProbability[] = new TextField[99];
        TextField addWeight[] = new TextField[99];
        
 
        
        
        //Add elements to layout/view
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(customSimulationBackButton);
        layout2.getChildren().add(simulationSettingsTitle);
        layout2.getChildren().add(orderTypes);
        layout2.getChildren().add(orderFrequency);
        layout2.getChildren().add(r2);
        
        layout2.getChildren().addAll(scrollPane);
        
        layout2.getChildren().add(hour);
        layout2.getChildren().add(numOrders);
        layout2.getChildren().add(r3);
        layout2.getChildren().add(hour1);
        layout2.getChildren().add(hour2);
        layout2.getChildren().add(hour3);
        layout2.getChildren().add(hour4);
        layout2.getChildren().add(hourField1);
        layout2.getChildren().add(hourField2);
        layout2.getChildren().add(hourField3);
        layout2.getChildren().add(hourField4);
        layout2.getChildren().add(addOrder);
        layout2.getChildren().add(deleteSelectedRow);
        layout2.getChildren().add(startSimulationSettings);
        
        
        
        /* SET THE SCENES */
        Scene scene1 = new Scene(layout, 750, 400);
        Scene scene2 = new Scene(layout2, 750, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
        
        
        /* SETUP BUTTON ACTIONS */
        addOrder.setOnAction(e-> {
        	addBurgers[numAddOrders] = new TextField();
        	addBurgers[numAddOrders].setTranslateX(30);
        	addBurgers[numAddOrders].setTranslateY(addOrderYAxis);
        	addBurgers[numAddOrders].setMaxWidth(40);
        	pane.getChildren().add(addBurgers[numAddOrders]);
        	
        	addFries[numAddOrders] = new TextField();
        	addFries[numAddOrders].setTranslateX(97);
        	addFries[numAddOrders].setTranslateY(addOrderYAxis);
        	addFries[numAddOrders].setMaxWidth(40);
        	pane.getChildren().add(addFries[numAddOrders]);
        	
        	addDrinks[numAddOrders] = new TextField();
        	addDrinks[numAddOrders].setTranslateX(162);
        	addDrinks[numAddOrders].setTranslateY(addOrderYAxis);
        	addDrinks[numAddOrders].setMaxWidth(40);
        	pane.getChildren().add(addDrinks[numAddOrders]);
        	
        	addProbability[numAddOrders] = new TextField();
        	addProbability[numAddOrders].setTranslateX(245);
        	addProbability[numAddOrders].setTranslateY(addOrderYAxis);
        	addProbability[numAddOrders].setMaxWidth(40);
        	pane.getChildren().add(addProbability[numAddOrders]);
        	
        	addWeight[numAddOrders] = new TextField();
        	addWeight[numAddOrders].setTranslateX(324);
        	addWeight[numAddOrders].setTranslateY(addOrderYAxis);
        	addWeight[numAddOrders].setMaxWidth(40);
        	pane.getChildren().add(addWeight[numAddOrders]);
        	
        	addOrderYAxis += 40;
        	
        	pane.setPrefHeight(pane.getHeight() + 40);
        	
        	numAddOrders++;
        	
        });
        
        simulationSettings.setOnAction(e-> {
        	//Create and Set the Scene
            primaryStage.setScene(scene2);
            primaryStage.show();
        });
        
        customSimulationBackButton.setOnAction(e-> {
        	//Create and Set the Scene
            primaryStage.setScene(scene1);
            primaryStage.show();
        });
        
        startSimulation.setOnAction(e-> {
        	//Start the simulation with DEFAULT settings
        	Drone drone = new Drone();
        	FoodItem burgerItem = new FoodItem(6);
            FoodItem friesItem = new FoodItem(4);
            FoodItem drinkItem = new FoodItem(14);
            
        	CampusMap map = new CampusMap("Grove City College");
            int[] ordersPerHour = {15, 17, 22, 12};
            // Meal 1
            HashMap<FoodItem, Integer> items1 = new HashMap<FoodItem, Integer>();
            items1.put(burgerItem, 2);
            items1.put(drinkItem, 1);
            Meal meal1 = new Meal(items1);
            
            //Verify order weight
            if(meal1.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            
            MealProbability mp1 = new MealProbability(meal1, 0.5);
            // Meal 2
            HashMap<FoodItem, Integer> items2 = new HashMap<FoodItem, Integer>();
            items2.put(burgerItem, 1);
            items2.put(friesItem, 1);
            Meal meal2 = new Meal(items2);
            
            //Verify order weight
            if(meal2.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            
            MealProbability mp2 = new MealProbability(meal2, 0.5);

            MealProbability[] mp = {mp1, mp2};

            Simulation sim = new Simulation(map, mp, ordersPerHour);
            sim.run();
            File placeToSave = new File("temp.csv");
            sim.saveCSV(placeToSave);
        });
        
        startSimulationSettings.setOnAction(e-> {
        	//Start the simulation with CUSTOM settings
        	Drone drone = new Drone();
        	FoodItem burgerItem = new FoodItem(6);
            FoodItem friesItem = new FoodItem(4);
            FoodItem drinkItem = new FoodItem(14);
            
        	CampusMap map = new CampusMap("Grove City College");
        	
        	
        	//Get orders per hour from user input
            int[] ordersPerHour = new int[4];
            ordersPerHour[0] = Integer.parseInt(hour1.getText());
            ordersPerHour[1] = Integer.parseInt(hour2.getText());
            ordersPerHour[2] = Integer.parseInt(hour3.getText());
            ordersPerHour[3] = Integer.parseInt(hour4.getText());
            
            //File I/O for stochastic flow of custom orders
            try {
            	
            	fw = new FileWriter(fileLoc, true);
            	pw = new PrintWriter(fw);
            	
            	pw.print("Begin custom order\n");
            	
            	pw.print("Orders per hour\n");
            	for(int i = 0; i < ordersPerHour.length; i++) {
            		pw.print(ordersPerHour[i] + "\n");
            	}
            	
            	pw.flush();
            	pw.close();
            	
            } catch(Exception exception) {
            	exception.printStackTrace();
            }
            
            //Create arraylist to hold order then convert to array later
            ArrayList<MealProbability> groupOrders = new ArrayList<MealProbability>();
            
            //Get any custom orders entered by user
            if (!probability1.getText().equals("")) {
            	HashMap<FoodItem, Integer> items1 = new HashMap<FoodItem, Integer>();
            	items1.put(burgerItem, Integer.parseInt(burgers1.getText()));
                items1.put(drinkItem, Integer.parseInt(drinks1.getText()));
                items1.put(friesItem, Integer.parseInt(fries1.getText()));
                
                Meal meal1 = new Meal(items1);
                
                //Verify order weight
                if(meal1.getWeight() > drone.getCargoWeight())
                {
                	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
                	return;
                }

                MealProbability mp1 = new MealProbability(meal1, Integer.parseInt(probability1.getText()));
                groupOrders.add(mp1);
                System.out.println(mp1.getProbability());
                
                // File I/O to add first meal to custom settings file
                try {
                	
                	fw = new FileWriter(fileLoc, true);
                	pw = new PrintWriter(fw);
                	
                	pw.print("Orders listed as follows: #burgers, #drinks, #fries, weight, probability\n");
                	
                	pw.print(Integer.parseInt(burgers1.getText()) + "\t" + Integer.parseInt(drinks1.getText()) + 
                			"\t" + Integer.parseInt(fries1.getText()) + "\t" + meal1.getWeight() + "\t" + Integer.parseInt(probability1.getText()) + "\n");
                	
                	pw.flush();
                	pw.close();
                	
                } catch(Exception exception) {
                	exception.printStackTrace();
                }
                
            }
			if (!probability2.getText().equals("")) {
				HashMap<FoodItem, Integer> items2 = new HashMap<FoodItem, Integer>();
				items2.put(burgerItem, Integer.parseInt(burgers2.getText()));
                items2.put(drinkItem, Integer.parseInt(drinks2.getText()));
                items2.put(friesItem, Integer.parseInt(fries2.getText()));
                
                Meal meal2 = new Meal(items2);
                
                //Verify order weight
                if(meal2.getWeight() > drone.getCargoWeight())
                {
                	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
                	return;
                }

                MealProbability mp2 = new MealProbability(meal2, Integer.parseInt(probability2.getText()));
                groupOrders.add(mp2);
                System.out.println(mp2.getProbability());
                
                try {
                	
                	fw = new FileWriter(fileLoc, true);
                	pw = new PrintWriter(fw);       
                	
                	pw.print(Integer.parseInt(burgers2.getText()) + "\t" + Integer.parseInt(drinks2.getText()) + 
                			"\t" + Integer.parseInt(fries2.getText()) + "\t" + meal2.getWeight() + "\t" + Integer.parseInt(probability2.getText()) + "\n");
                	
                	pw.flush();
                	pw.close();
                	
                } catch(Exception exception) {
                	exception.printStackTrace();
                }
                
            }
			if (!probability3.getText().equals("")) {
				HashMap<FoodItem, Integer> items3 = new HashMap<FoodItem, Integer>();
				items3.put(burgerItem, Integer.parseInt(burgers3.getText()));
                items3.put(drinkItem, Integer.parseInt(drinks3.getText()));
                items3.put(friesItem, Integer.parseInt(fries3.getText()));
                
                Meal meal3 = new Meal(items3);
                
                //Verify order weight
                if(meal3.getWeight() > drone.getCargoWeight())
                {
                	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
                	return;
                }

                MealProbability mp3 = new MealProbability(meal3, Integer.parseInt(probability3.getText()));
                groupOrders.add(mp3);
                System.out.println(mp3.getProbability());
                
                try {
                	
                	fw = new FileWriter(fileLoc, true);
                	pw = new PrintWriter(fw);
                	
                	pw.print(Integer.parseInt(burgers3.getText()) + "\t" + Integer.parseInt(drinks3.getText()) + 
                			"\t" + Integer.parseInt(fries3.getText()) + "\t" + meal3.getWeight() + "\t" + Integer.parseInt(probability3.getText()) + "\n");
                	
                	pw.flush();
                	pw.close();
                	
                } catch(Exception exception) {
                	exception.printStackTrace();
                }
                
			}
			
			
			//Add in any textFields the user implemented using the addOrder button
			
			for (int j = 0; j < numAddOrders; j++) {
				if (!addProbability[j].getText().equals("")) {
					HashMap<FoodItem, Integer> newItem = new HashMap<FoodItem, Integer>();
					newItem.put(burgerItem, Integer.parseInt(addBurgers[j].getText()));
	                newItem.put(drinkItem, Integer.parseInt(addDrinks[j].getText()));
	                newItem.put(friesItem, Integer.parseInt(addFries[j].getText()));
	                
	                Meal newMeal = new Meal(newItem);
	                
	                //Verify order weight
	                if(newMeal.getWeight() > drone.getCargoWeight())
	                {
	                	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
	                	return;
	                }

	                MealProbability newMealProbability = new MealProbability(newMeal, Integer.parseInt(addProbability[j].getText()));
	                groupOrders.add(newMealProbability);
	                System.out.println(newMealProbability.getProbability());
	                
	                try {
	                	
	                	fw = new FileWriter(fileLoc, true);
	                	pw = new PrintWriter(fw);
	                	
	                	pw.print(Integer.parseInt(addBurgers[j].getText()) + "\t" + Integer.parseInt(addDrinks[j].getText()) + 
	                			"\t" + Integer.parseInt(addFries[j].getText()) + "\t" + newMeal.getWeight() + "\t" + Integer.parseInt(addProbability[j].getText()) + "\n");
	                	
	                	pw.flush();
	                	pw.close();
	                	
	                } catch(Exception exception) {
	                	exception.printStackTrace();
	                }
	                
				}
			}
            
			//Convert arrayList to array to support being passed into Simulation
			MealProbability[] mp = new MealProbability[groupOrders.size()];
			for (int j = 0; j < groupOrders.size(); j++) {
				mp[j] = groupOrders.get(j);
			}

			//File I/O to let us know we have reached the end of a custom order
			try {
				
				fw = new FileWriter(fileLoc, true);
				pw = new PrintWriter(fw);
				
				pw.print("End custom order\n");
				
				pw.flush();
				pw.close();
				
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			
            Simulation sim = new Simulation(map, mp, ordersPerHour);
            sim.run();

            // Open file dialoge to save file (based on code from codejava.net)
            JFrame parent = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save simulation results");
            
            int userSelection = fileChooser.showSaveDialog(parent);
            if(userSelection == JFileChooser.APPROVE_OPTION) {
            	File fileToSave = new File("results.csv");
            	sim.saveCSV(fileToSave);
            }
        });
        
    }

    public static void main(String[] args) {

        launch(args);
        
    }
    
}
