# DromedaryDrones

NOTE: JavaFX should come pre-initialized with this project, however, if there are errors because JavaFX is not
      linked with eclipse, follow the directions to install the JavaFX libraries for eclipse at: 
      https://www.eclipse.org/efxclipse/install.html
      
NB: To run the completed sprint one product, be sure to navigate to branch master. If this is not the branch you are in, 
    begin a git bash terminal in the file location of the project, and enter the command "git checkout master", then proceed
    with the directions below. 

How to Run: 
1. Clone the GitHub repository for our Dromedary Drones simulation from: https://github.com/jakedmurphy1/DromedaryDrones.git
2. Once the repository has been cloned, open the project, and navigate to class "Main.Java"
3. Run Main.Java
4. A window should pop up with three options: 
  a) Simulation Setup/Settings
  b) Start Simulation
  c) View Default Settings
5. To run the simulation with the default order specifications and probabilities, click "Start Simulation"
6. To add in custom orders and probabilities, click "Simulation Setup/Settings"
  a) In the new window, all values of burgers, fries, and drinks should be integers, and the user
     will be prompted to correct these values if incorrect types are entered
  b) All probabilities must sum to 1.0, and the user will be prompted to correct these probability values
     if their sum is greater or less than 1.0
  c) If one text field is filled for a given row, all text fields need to be filled to indicate a new order
  d) Be sure to enter integer values in the order frequency box, indicating how many orders will be received in each
     of the four simulated hours
  e) Once all orders have been added with valid types and order frequencies have been set, click "Start Simulation"
7. The simulation will run silently in the background. Once the simulation has completed, a file save dialog will 
   appear, prompting the user to enter a location to save the results file from the simulation
   a) Select the location that you would like the file to be saved to
   b) Enter the name for the results file to be saved as. 
   c) Click "Save"
8. At this point, the program will have completed the execution of the first simulation. The csv file can be viewed 
   at the file location that it was saved at, or the user can begin another simulation. 
