package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Servidor;

public class Modo {

    @FXML
    private AnchorPane anchor_login;

    @FXML
    private Button btn_equipo;

    @FXML
    private Button btn_nina;

    @FXML
    private Button btn_nino;

    @FXML
    private Button btn_solo;

    @FXML
    private Button btn_versus;

    @FXML
    private TextField textUnirPuerto;

    @FXML
    private TextField txtNombre;

    private String genero;

    public Dificultad nivel;

    @FXML
    void generoNina(ActionEvent event) {
        this.genero="nina";
        System.out.println("genero: "+this.genero);
    }

    @FXML
    void generoNino(ActionEvent event) {
        this.genero="nino";
        System.out.println("genero: "+this.genero);
    }

    @FXML
    void soloMode(ActionEvent event) {
        enviarModo("solo");
    }

    @FXML
    void teamMode(ActionEvent event) {
        enviarModo("team");
    }

    @FXML
    void versusMode(ActionEvent event) {
        enviarModo("versus");
    }

    public void enviarModo(String modo){
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Login.class.getResource("/vista/dificultad.fxml"));
            Pane ventana = (Pane) loader.load();

            Dificultad nivel = loader.getController();
            nivel.setModo(modo);
            nivel.setGenero(genero);
            nivel.setNombre(this.txtNombre.getText());
            nivel.setPuerto(Integer.parseInt(this.textUnirPuerto.getText()));
            
            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage)this.btn_solo.getScene().getWindow();
            myStage.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Modo(){
        
    }

}