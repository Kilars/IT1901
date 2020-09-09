package bookingsystem.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application{
	
    public void start(final Stage stage) throws Exception {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FxApp.fxml"));
        final Parent root = fxmlLoader.load();
        final AppController controller = fxmlLoader.getController();
        
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        }
    
    
    public static void main( String[] args ){
        System.out.println( "Test");
        launch(args);
    }
}
