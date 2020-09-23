package bookingsystem.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Starts the App
 */
public class App extends Application{
    
    
    /**
     * Starts the App, sets scene to welcome-view
     * @param Stage 
     * @throws Exception
     */
    public void start(final Stage stage) throws Exception {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FxApp.fxml"));
        final Parent root = fxmlLoader.load();
        //final AppController controller = fxmlLoader.getController();
        
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        }
    
    
    public static void main( String[] args ){
        launch(args);
    }
}
