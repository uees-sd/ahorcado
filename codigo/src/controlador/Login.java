package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Login extends Application {

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_registar;

    @FXML
    void inciar(ActionEvent event) {

    }

    @FXML
    void registrarse(ActionEvent event) {

    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*StackPane root = new StackPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();*/
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Login.class.getResource("/vista/login.fxml"));
        Pane ventana = (Pane) loader.load();
        
        Scene scene = new Scene(ventana);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
