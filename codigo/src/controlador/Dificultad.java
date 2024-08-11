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
    String genero;
    int puerto;

    private String nombre;

    public Dificultad(){

    }

    @FXML
    void gameFacil(ActionEvent event) {
        String [] palabras = {"caballo", "paraguas", "consola"};
        String [] pista ={
            "Animal que montan los vaqueros.",
            "Se usa en días de lluvia cuando sales.",
            "Lo utilizas para jugar videojuegos en la TV."
        };
        int vidas = 5;
        enviarNivel("facil", palabras, vidas,pista);
    }

    @FXML
    void gameMedio(ActionEvent event) {
        String [] palabras = {"paralelo", "academia", "ordenador"};
        String [] pista ={
            "Dos lineas juntas que no se tocan van en...",
            "Sinónimo de institución educativa.",
            "Se utiliza para trabajar o jugar en oficinas."
        };
        int vidas = 4;
        enviarNivel("medio", palabras, vidas,pista);
    }

    @FXML
    void gameDificil(ActionEvent event) {
        String [] palabras = {"Parangaracutirimicuaro", "desoxirribonucleico", "anticonstitucionalidad"};
        String [] pista ={
            "Volcan mexicano pequeño.",
            "Ácido nucleico que contiene las instrucciones genéticas.",
            "Cualidad de inconstitucional."
        };
        int vidas = 3;
        enviarNivel("dificil", palabras, vidas,pista);
    }

    public void enviarNivel(String nivel, String[] palabras, int vidas, String[] pista){
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
            game.setVidasOriginales(vidas);
            game.setLblPalabra(ahorcado.palabraAGuionesAPalabra(palabras[0]));
            game.setGenero(this.genero);
            game.setNombre(this.nombre);
            game.setPuerto(this.puerto);
            game.setPista(pista);
            game.setLblPista(pista[0]);

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

    public void setGenero(String genero) {
        this.genero=genero;
        System.out.println("genero2: "+this.genero);
    }

    public void setNombre(String text) {
        this.nombre=text;
    }

    public void setPuerto(int puerto){
        this.puerto=puerto;
    }

}
