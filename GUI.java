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

public class GUI extends Application {
  
  //Temorary Lst of data
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
    
    //creating the border pane
    BorderPane bp1 = new BorderPane();
    
    Button add = new Button("Add Data");
    Button read = new Button("Read Data");
    Button generate = new Button("Generate Report");

    bp1.setTop(new Label("What would you like to do?"));
    
    HBox hbox = new HBox(250);
    hbox.getChildren().addAll(add,read,generate);
    
    

    bp1.setCenter(hbox);

    
    Scene mainScene = new Scene(bp1, 800, 800);
    
    primaryStage.setTitle("Milk Weights");
    primaryStage.setScene(mainScene);
    primaryStage.show();  
    
    
    
    
    
    //Scene Read
    BorderPane bp2 = new BorderPane();
    
    VBox vbox = new VBox();
    for(int i = 0 ; i < list.size(); i++) {
      vbox.getChildren().add(new Label(list.get(i)));
    }
    
    //Button to return
    Button back = new Button("back");
    
    bp2.setTop(new Label("Read Data"));
    bp2.setCenter(vbox);
    bp2.setBottom(back);
    
    Scene readScene = new Scene(bp2, 800, 800);
    
    //setting action for read button
    read.setOnAction(e -> primaryStage.setScene(readScene));
    
    //setting action for back button
    back.setOnAction(e -> primaryStage.setScene(mainScene));
    
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
