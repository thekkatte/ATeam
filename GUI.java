import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//need to create all the pop-ups
//need to make use of input data
//need to be able to call from Main class
//need to add functions to buttons in generate Report
//need to add function to the add button
//need to create the report displaying page and the data displaying page

public class GUI extends Application {
  
  //Temporary List of data
  private List<String> list;
  
  private List<String> args;
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    
    args = this.getParameters().getRaw();
    
    //temporary data
    list = new ArrayList<>();
    list.add("2019-1");
    list.add("2012-2");
    list.add("2019-3");
    
    //creating the border pane for main page
    BorderPane bp1 = new BorderPane();
    
    //buttons on the main page
    Button add = new Button("Add Data");
    Button read = new Button("Read Data");
    Button generate = new Button("Generate Report");

    
    //setting the text at the top of the layout
    bp1.setTop(new Label("\nWhat would you like to do?\n "));
    
    
    //HBox to equally space the buttons from each other
    HBox hbox = new HBox(250);
    hbox.getChildren().addAll(add,read,generate);
    
    //setting the center of the layout to the hbox
    bp1.setCenter(hbox);

    //setting the main scene - scene for the main page
    Scene mainScene = new Scene(bp1, 800, 800);
    
    //App title is set to Milk Weights
    primaryStage.setTitle("Milk Weights");
    primaryStage.setScene(mainScene);
    primaryStage.show();  
    
    
    
    //Scene for when the Read button is clicked
   
    //Border Pane for the page that opens when the read button is clicked
    BorderPane bp2 = new BorderPane();
    
    //VBox with the data of file name of each year
    // this needs to be changed as its supposed to be able to show the data after one of these file names are clicked
    // hardcoded data is being used right now
    VBox vbox = new VBox();
    for(int i = 0 ; i < list.size(); i++) {
      vbox.getChildren().add(new Label(list.get(i)));
    }
    
    //Button to return from the read page
    Button readBack = new Button("Back");
    
    
    //setting the second bp
    bp2.setTop(new Label("Read Data\n\n Select the file your would like to read\n "));
    bp2.setCenter(vbox);
    bp2.setBottom(readBack);
    
    //setting the read scene to bp2
    Scene readScene = new Scene(bp2, 800, 800);
    
    
    // Scene for Generate Report
    BorderPane bpGenerate = new BorderPane();
    
    bpGenerate.setTop(new Label("Generate Report\n\nSelect the type of report you would like to generate\n "));
    
    //Buttons for the generate Report Page
    Button farm = new Button("Farm Report");
    Button annual = new Button("Annual Report");
    Button monthly = new Button("Monthly Report");
    Button dateRange = new Button("Date Range Report");
    
    //Button to return from the read page
    Button generateBack = new Button("Back");
    
    //Hbox with all the buttons
    HBox hboxGenerate = new HBox(100);
    hboxGenerate.getChildren().addAll(farm, annual, monthly, dateRange);
    
    bpGenerate.setCenter(hboxGenerate);
    bpGenerate.setBottom(generateBack);
    
    //setting the read scene to bpGenerate
    Scene generateScene = new Scene(bpGenerate, 800, 800);
    
    //setting action for read button
    read.setOnAction(e -> primaryStage.setScene(readScene));
    
    //setting action for back button
    readBack.setOnAction(e -> primaryStage.setScene(mainScene));
    generateBack.setOnAction(e -> primaryStage.setScene(mainScene));
    
    //setting action for generate button
    generate.setOnAction(e -> primaryStage.setScene(generateScene));
    
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
