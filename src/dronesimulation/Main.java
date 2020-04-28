package dronesimulation;

import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Dimension;
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
        
        Label description = new Label("Welcome to the drone delivery simulation by Dromedary Drones! Click Start Simulation to begin a new simulation with the default settings, or make a custom simulation in the settings tab.");
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
        weight1.setEditable(false);
        
        TextField weight2 = new TextField();
        weight2.setTranslateX(324);
        weight2.setTranslateY(85);
        weight2.setMaxWidth(40);
        weight2.setEditable(false);
        
        TextField weight3 = new TextField();
        weight3.setTranslateX(324);
        weight3.setTranslateY(125);
        weight3.setMaxWidth(40);
        weight3.setEditable(false);
        
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
        
        //Load map
        Button loadCampusMap = new Button("Load image of campus map");
        loadCampusMap.setTranslateX(150);
        loadCampusMap.setTranslateY(150);
        
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
        
        //Create Error Message
        Label errorMessage = new Label("** Make sure all entered numbers are Integers, except probability which must be a decimal with all fields adding up to 1.0. Do not forget the hours section. And if one input is filled on a row, ensure all other inputs in that row are filled as well. If the Add Order button is pressed, the input fields on that order all must be filled.");
        errorMessage.setTranslateX(200);
        errorMessage.setTranslateY(140);
        errorMessage.setMaxWidth(230);
        errorMessage.setWrapText(true);
        errorMessage.setTextFill(Color.RED);
        errorMessage.setVisible(false);
        errorMessage.setFont(new Font("Arial", 10));
        
        //Add elements to layout/view
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(customSimulationBackButton);
        layout2.getChildren().add(simulationSettingsTitle);
        layout2.getChildren().add(orderTypes);
        layout2.getChildren().add(orderFrequency);
        layout2.getChildren().add(r2);
        //add new button
        layout2.getChildren().add(loadCampusMap);
        
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
        layout2.getChildren().add(errorMessage);
        
        /* Default Settings Scene */
        Button backButton = new Button("Back");
        backButton.setTranslateX(-320);
        backButton.setTranslateY(-170);
        
        Label default_title = new Label("Welcome to the drone delivery simulation by Dromedary Drones!");
        default_title.setTextAlignment(TextAlignment.CENTER);
        default_title.setTranslateY(-85);
        default_title.setFont(new Font("Arial", 25));
        
        Label settings = new Label("\nThe default settings are as follows: \n\tOrder 1: 1 burger, 1 fries, 1 drink\n" + 
        		"\tOrder 2: 2 burgers, 1 fries, 1 drink\n\tOrder 3: 1 burger, 1 fries, 0 drinks\n" + 
        		"\tOrder 4: 2 burgers, 1 fries, 0 drinks\n\tOrder 5: 0 burgers, 1 fries, 0 drinks");
        settings.setTranslateY(25);
        settings.setWrapText(true);
        settings.setMaxWidth(600);
        settings.setTextAlignment(TextAlignment.LEFT);
        settings.setFont(new Font("Arial", 25));
        
        //Create Layout
        StackPane layout3 = new StackPane();
        
        //Add Elements to Layout
        layout3.getChildren().add(backButton);
        layout3.getChildren().add(default_title);
        layout3.getChildren().add(settings);
        
        
            
        
        /* SET THE SCENES */
        Scene scene1 = new Scene(layout, 750, 400);
        Scene scene2 = new Scene(layout2, 750, 400);
        Scene scene3 = new Scene(layout3, 750, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
        //go back from the default settings page
        backButton.setOnAction(e-> {
        	primaryStage.setScene(scene1);
        	primaryStage.show();
        });
        
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
        	addWeight[numAddOrders].setEditable(false);
        	pane.getChildren().add(addWeight[numAddOrders]);
        	
        	addOrderYAxis += 40;
        	
        	pane.setPrefHeight(pane.getHeight() + 40);
        	
        	numAddOrders++;
        	
        });
        
        //get the location of the campus map
        loadCampusMap.setOnAction(e -> {
        	String pictureLocation = "";
        	JFileChooser chooser = new JFileChooser();
        	chooser.setCurrentDirectory(new File("."));
        	chooser.setDialogTitle("Choose Image");
        	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        	chooser.setAcceptAllFileFilterUsed(false);
        	chooser.setPreferredSize(new Dimension(600, 400));
        	
        	if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        		pictureLocation = chooser.getSelectedFile().getAbsolutePath();
        	}
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
        
        defaultSettings.setOnAction(e -> {
        	primaryStage.setScene(scene3);
        	primaryStage.show();
        });
        
        startSimulation.setOnAction(e-> {
        	//Start the simulation with DEFAULT settings
        	
        	Drone drone = new Drone();
        	FoodItem burgerItem = new FoodItem(6);
            FoodItem friesItem = new FoodItem(4);
            FoodItem drinkItem = new FoodItem(14);
            
        	CampusMap map = new CampusMap("Grove City College");
            int[] ordersPerHour = {38, 45, 60, 30};
            // Meal 1
            HashMap<FoodItem, Integer> items1 = new HashMap<FoodItem, Integer>();
            items1.put(burgerItem, 1);
            items1.put(friesItem, 1);
            items1.put(drinkItem, 1); //0.55 percent chance
            Meal meal1 = new Meal(items1);
            if(meal1.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            MealProbability mp1 = new MealProbability(meal1, 0.5);
            
            //second meal
            HashMap<FoodItem, Integer> items2 = new HashMap<FoodItem, Integer>();
            items2.put(burgerItem, 2);
            items2.put(friesItem, 1);
            items2.put(drinkItem, 1); //0.55 percent chance
            Meal meal2 = new Meal(items2);
            if(meal2.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            MealProbability mp2 = new MealProbability(meal2, 0.2);
            
            //third meal
            HashMap<FoodItem, Integer> items3 = new HashMap<FoodItem, Integer>();
            items3.put(burgerItem, 1);
            items3.put(friesItem, 1);
            Meal meal3 = new Meal(items3);
            if(meal3.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            MealProbability mp3 = new MealProbability(meal3, 0.15);
            
            //4th meal
            HashMap<FoodItem, Integer> items4 = new HashMap<FoodItem, Integer>();
            items4.put(burgerItem, 2);
            items4.put(friesItem, 1);
            Meal meal4 = new Meal(items4);
            if(meal4.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            MealProbability mp4 = new MealProbability(meal4, 0.1);
            
            //5th meal
            HashMap<FoodItem, Integer> items5 = new HashMap<FoodItem, Integer>();
            items5.put(friesItem, 1);
            Meal meal5 = new Meal(items5);
            if(meal5.getWeight() > drone.getCargoWeight())
            {
            	new Alert(Alert.AlertType.ERROR, "Meals must be below weight of " + drone.getCargoWeight() + " oz.").showAndWait();
            	return;
            }
            MealProbability mp5 = new MealProbability(meal5, 0.05);
            
            MealProbability[] mp = {mp1, mp2, mp3, mp4, mp5};

            Simulation sim = new Simulation(map, mp, ordersPerHour);
            sim.run();

            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extensions = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extensions);
            
            File results = fileChooser.showSaveDialog(primaryStage);
            
            if(results != null) {
            	sim.saveCSV(results);
            }
            
            
            
        });
        
        //custom simulation
        startSimulationSettings.setOnAction(e-> {
        	//Get user input
        	ArrayList<String> allUserInput = new ArrayList<String>();
        	allUserInput.add(hourField1.getText());
            allUserInput.add(hourField2.getText());
            allUserInput.add(hourField3.getText());
            allUserInput.add(hourField4.getText());
            boolean order1Exists = true;
            boolean order2Exists = true;
            boolean order3Exists = true;
        	if (burgers1.getText().isEmpty() && fries1.getText().isEmpty() && drinks1.getText().isEmpty()) {
        		order1Exists = false;
        	}
        	if (burgers2.getText().isEmpty() && fries2.getText().isEmpty() && drinks2.getText().isEmpty()) {
        		order2Exists = false;
        	}
			if (burgers3.getText().isEmpty() && fries3.getText().isEmpty() && drinks3.getText().isEmpty()) {
				order3Exists = false;
			}
			
			if (order1Exists) {
				allUserInput.add(burgers1.getText());
				allUserInput.add(fries1.getText());
				allUserInput.add(drinks1.getText());
				//allUserInput.add(weight1.getText());
			}
			if (order2Exists) {
				allUserInput.add(burgers2.getText());
				allUserInput.add(fries2.getText());
				allUserInput.add(drinks2.getText());
				//allUserInput.add(weight2.getText());
			}
			if (order3Exists) {
				allUserInput.add(burgers3.getText());
				allUserInput.add(fries3.getText());
				allUserInput.add(drinks3.getText());
				//allUserInput.add(weight3.getText());
			}
			
        	ArrayList<Integer> verifyUserInput = new ArrayList<Integer>();
        	boolean verified = true;
        	
        	//Go through standard orders to verify
        	for (int j = 0; j < allUserInput.size(); j++) {
		        try {
		        	verifyUserInput.add(Integer.parseInt(allUserInput.get(j)));
		        }catch (NumberFormatException ex) {
		        	verified = false;
		        	//System.out.println("FALSE 1 " + j);
		        	break;
		        }
        	}
        	//Go through added orders to verify if any
        	for (int j = 0; j < numAddOrders; j++) {
        		try {
	        		verifyUserInput.add(Integer.parseInt(addBurgers[j].getText()));
	        		verifyUserInput.add(Integer.parseInt(addFries[j].getText()));
	        		verifyUserInput.add(Integer.parseInt(addDrinks[j].getText()));
	        		//verifyUserInput.add(Integer.parseInt(addWeight[j].getText()));
        		}catch (NumberFormatException ex) {
		        	verified = false;
		        	//System.out.println("FALSE 2 " + j);
		        	break;
		        }
        	}
        	
        	//Go through Probabilities to verify
        	ArrayList<String> allUserInputProbability = new ArrayList<String>();
        	if (order1Exists) {
        		allUserInputProbability.add(probability1.getText());
        	}
        	if (order2Exists) {
        		allUserInputProbability.add(probability2.getText());
        	}
        	if (order3Exists) {
        		allUserInputProbability.add(probability3.getText());
        	}
        	
        	ArrayList<Double> verifyUserInputProbability = new ArrayList<Double>();
        	
        	for (int j = 0; j < numAddOrders; j++) {
        		allUserInputProbability.add(addProbability[j].getText());
        	}
        	double addUpProbability = 0;
        	for (int j = 0; j < allUserInputProbability.size(); j++) {
		        try {
		        	verifyUserInputProbability.add(Double.parseDouble(allUserInputProbability.get(j)));
		        	addUpProbability += Double.parseDouble(allUserInputProbability.get(j));
		        }catch (NumberFormatException ex) {
		        	verified = false;
		        	//System.out.println("FALSE 3 " + j);
		        	break;
		        }
        	}
        	//Verify that probability adds up to 1.0
        	if (addUpProbability != 1.0) {
        		//System.out.println("Probability Does Not Add Up: " + addUpProbability);
        		verified = false;
        	}
        	
        	
        	
        	if (verified) {
        		
        		//Declare weights of food items
        		final int BURGER_WEIGHT = 6;
        		final int FRIES_WEIGHT = 4;
        		final int DRINKS_WEIGHT = 14;
        		
        		//Calculate Order Weights
        		int orderWeight1 = 0;
        		int orderWeight2 = 0;
        		int orderWeight3 = 0;
        		
        		if (order1Exists) {
	        		orderWeight1 += (Integer.parseInt(burgers1.getText()) * BURGER_WEIGHT);
	        		orderWeight1 += (Integer.parseInt(fries1.getText()) * FRIES_WEIGHT);
	        		orderWeight1 += (Integer.parseInt(drinks1.getText()) * DRINKS_WEIGHT);
	        		weight1.setText(Integer.toString(orderWeight1));
        		}
        		if (order2Exists) {
	        		orderWeight2 += (Integer.parseInt(burgers2.getText()) * BURGER_WEIGHT);
	        		orderWeight2 += (Integer.parseInt(fries2.getText()) * FRIES_WEIGHT);
	        		orderWeight2 += (Integer.parseInt(drinks2.getText()) * DRINKS_WEIGHT);
	        		weight2.setText(Integer.toString(orderWeight2));
        		}
        		if (order3Exists) {
	        		orderWeight3 += (Integer.parseInt(burgers3.getText()) * BURGER_WEIGHT);
	        		orderWeight3 += (Integer.parseInt(fries3.getText()) * FRIES_WEIGHT);
	        		orderWeight3 += (Integer.parseInt(drinks3.getText()) * DRINKS_WEIGHT);
	        		weight3.setText(Integer.toString(orderWeight3));
        		}
        		
        		int orderWeight;
        		for (int j = 0; j < numAddOrders; j++) {
        			orderWeight = 0;
        			
        			orderWeight += (Integer.parseInt(addBurgers[j].getText()) * BURGER_WEIGHT);
            		orderWeight += (Integer.parseInt(addFries[j].getText()) * FRIES_WEIGHT);
            		orderWeight += (Integer.parseInt(addDrinks[j].getText()) * DRINKS_WEIGHT);
            		
            		addWeight[j].setText(Integer.toString(orderWeight));
        			
        		}
        		
        	
	        	//Start the simulation with CUSTOM settings
	        	Drone drone = new Drone();
	        	FoodItem burgerItem = new FoodItem(BURGER_WEIGHT);
	            FoodItem friesItem = new FoodItem(FRIES_WEIGHT);
	            FoodItem drinkItem = new FoodItem(DRINKS_WEIGHT);
	            
	        	CampusMap map = new CampusMap("Grove City College");
	        	
	        	//Get orders per hour from user input
	            int[] ordersPerHour = new int[4];
	            ordersPerHour[0] = Integer.parseInt(hour1.getText());
	            ordersPerHour[1] = Integer.parseInt(hour2.getText());
	            ordersPerHour[2] = Integer.parseInt(hour3.getText());
	            ordersPerHour[3] = Integer.parseInt(hour4.getText());
	            
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
	
	                MealProbability mp1 = new MealProbability(meal1, Double.parseDouble(probability1.getText()));
	                groupOrders.add(mp1);

	                System.out.println(mp1.getProbability());
	                
	                //File I/O to add save details of first custom order
	                try {
	                	
	                	fw = new FileWriter(fileLoc, true);
	                	pw = new PrintWriter(fw);
	                	
	                	pw.print("Begin Custom Orders\n");
	                	pw.print("Orders listed as follows: #burgers, #drinks, #fries, weight, probability\n");
	                	
	                	pw.print(Integer.parseInt(burgers1.getText()) + ", " + Integer.parseInt(drinks1.getText()) + ", " + 
	                			Integer.parseInt(fries1.getText()) + ", " + meal1.getWeight() + ", " + mp1.getProbability());
	                	
	                	pw.flush();
	                	pw.close();
	                	
	                } catch(Exception exception) {
	                	exception.printStackTrace();
	                }
	                

	                //System.out.println(mp1.getProbability());
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
	
	                MealProbability mp2 = new MealProbability(meal2, Double.parseDouble(probability2.getText()));
	                groupOrders.add(mp2);

	                System.out.println(mp2.getProbability());
	                
	                //File I/O to add save details of second custom order
	                try {
	                	
	                	fw = new FileWriter(fileLoc, true);
	                	pw = new PrintWriter(fw);
	                	
	                	pw.print(Integer.parseInt(burgers2.getText()) + ", " + Integer.parseInt(drinks2.getText()) + ", " + 
	                			Integer.parseInt(fries2.getText()) + ", " + meal2.getWeight() + ", " + mp2.getProbability());
	                	
	                	pw.flush();
	                	pw.close();
	                	
	                } catch(Exception exception) {
	                	exception.printStackTrace();
	                }
	                

	                //System.out.println(mp2.getProbability());

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
	
	                MealProbability mp3 = new MealProbability(meal3, Double.parseDouble(probability3.getText()));
	                groupOrders.add(mp3);

	                System.out.println(mp3.getProbability());
	                
	                //File I/O to add save details of third custom order
	                try {
	                	
	                	fw = new FileWriter(fileLoc, true);
	                	pw = new PrintWriter(fw);
	                	
	                	pw.print(Integer.parseInt(burgers3.getText()) + ", " + Integer.parseInt(drinks3.getText()) + ", " + 
	                			Integer.parseInt(fries3.getText()) + ", " + meal3.getWeight() + ", " + mp3.getProbability());
	                	
	                	pw.flush();
	                	pw.close();
	                	
	                } catch(Exception exception) {
	                	exception.printStackTrace();
	                }
	                

	                //System.out.println(mp3.getProbability());

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
	
		                MealProbability newMealProbability = new MealProbability(newMeal, Double.parseDouble(addProbability[j].getText()));
		                groupOrders.add(newMealProbability);

		                System.out.println(newMealProbability.getProbability());
		                
		                //File I/O to add save details of each successive custom order
		                try {
		                	
		                	fw = new FileWriter(fileLoc, true);
		                	pw = new PrintWriter(fw);		                	
		                	
		                	pw.print(Integer.parseInt(addBurgers[j].getText()) + ", " + Integer.parseInt(addDrinks[j].getText()) + ", " + 
		                			Integer.parseInt(addFries[j].getText()) + ", " + newMeal.getWeight() + ", " + newMealProbability.getProbability());
		                	
		                	pw.print("End Custom Orders\n");
		                	
		                	pw.flush();
		                	pw.close();
		                	
		                } catch(Exception exception) {
		                	exception.printStackTrace();
		                }
		                

		                //System.out.println(newMealProbability.getProbability());

					}
				}
	            
				//Convert arrayList to array to support being passed into Simulation
				MealProbability[] mp = new MealProbability[groupOrders.size()];
				for (int j = 0; j < groupOrders.size(); j++) {
					mp[j] = groupOrders.get(j);
				}
	
	            Simulation sim = new Simulation(map, mp, ordersPerHour);
	            sim.run();
	            
	            // Open file save dialog to let the user choose where they want results saved
	            // Adapted from https://www.genuinecoder.com/save-files-javafx-filechooser/
	            FileChooser fileChooser = new FileChooser();
	            FileChooser.ExtensionFilter extensions = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
	            fileChooser.getExtensionFilters().add(extensions);
	            
	            File results = fileChooser.showSaveDialog(primaryStage);
	            
	            if(results != null) {
	            	sim.saveCSV(results);
	            }
        	}
        	else {
        		errorMessage.setVisible(true);
        	}
            
        });
        
    }

    public static void main(String[] args) {

        launch(args);
        
    }
    
}
