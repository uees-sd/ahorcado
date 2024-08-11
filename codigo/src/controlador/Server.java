package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Servidor;

public class Server extends Application {

    @FXML
    private Button btn_Iniciar;

    @FXML
    private TextField txtPuerto;

    public Server(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Login.class.getResource("/vista/server.fxml"));
        Pane ventana = (Pane) loader.load();
        
        Scene scene = new Scene(ventana);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @FXML
    void iniciarServer(ActionEvent event) {
        Servidor server= new Servidor();
        server.setPuerto(Integer.parseInt(this.txtPuerto.getText()));
        server.Conectar();
    }

    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
