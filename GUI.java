import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {
  
  private List<String> args;
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    
    args = this.getParameters().getRaw();
    
    //creating the border pane
    BorderPane bp = new BorderPane();
    
    Button add = new Button("Add Data");
    Button read = new Button("Read Data");
    Button generate = new Button("Generate Report");

    bp.setTop(new Label("What would you like to do?"));
    
    bp.setLeft(add);
    bp.setCenter(read);
    bp.setRight(generate);
    
    Scene mainScene = new Scene(bp, 800, 800);
    
    primaryStage.setTitle("Milk Weights");
    primaryStage.setScene(mainScene);
    primaryStage.show();    
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
