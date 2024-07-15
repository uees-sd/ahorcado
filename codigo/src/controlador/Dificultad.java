package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Ahorcado;

public class Dificultad {

    @FXML
    private AnchorPane anchor_login;

    @FXML
    private Button btn_dificil;

    @FXML
    private Button btn_facil;

    @FXML
    private Button btn_medio;

    String modo;

    public Dificultad(){

    }

    @FXML
    void gameFacil(ActionEvent event) {
        String [] palabras = {"caballo", "paraguas", "consola"};
        int vidas = 5;
        enviarNivel("facil", palabras, vidas);
    }

    @FXML
    void gameMedio(ActionEvent event) {
        String [] palabras = {"paralelo", "academia", "ordenador"};
        int vidas = 4;
        enviarNivel("facil", palabras, vidas);
    }

    @FXML
    void gameDificil(ActionEvent event) {
        String [] palabras = {"Parangaracutirimicuaro", "desoxirribonucleico", "anticonstitucionalidad"};
        int vidas = 3;
        enviarNivel("facil", palabras, vidas);
    }

    public void enviarNivel(String nivel, String[] palabras, int vidas){
        try {

            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Login.class.getResource("/vista/game.fxml"));
            Pane ventana = (Pane) loader.load();

            Ahorcado ahorcado= new Ahorcado();
            Game game = loader.getController();
            game.setNivel(nivel);
            game.setModo(modo);
            game.setPalabras(palabras);
            game.setVidas(vidas);
            game.setLblPalabra(ahorcado.palabraAGuionesAPalabra(palabras[0]));

            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(Login.class.getResource("/vista/puntaje.fxml"));
            Pane ventana2 = (Pane) loader2.load();
            Scene scene2 = new Scene(ventana2);
            Stage stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.show();

            Stage myStage = (Stage)this.btn_facil.getScene().getWindow();
            myStage.close();

            
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void setModo(String modo){
        this.modo=modo;
    }

}
