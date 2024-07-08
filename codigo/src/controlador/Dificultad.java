package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Dificultad {

    @FXML
    private AnchorPane anchor_login;

    @FXML
    private Button btn_dificil;

    @FXML
    private Button btn_facil;

    @FXML
    private Button btn_medio;

    @FXML
    void gameDificil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Login.class.getResource("/vista/game.fxml"));
            Pane ventana = (Pane) loader.load();
            
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

            Stage myStage = (Stage)this.btn_dificil.getScene().getWindow();
            myStage.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void gameFacil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Login.class.getResource("/vista/game.fxml"));
            Pane ventana = (Pane) loader.load();
            
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

    @FXML
    void gameMedio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Login.class.getResource("/vista/game.fxml"));
            Pane ventana = (Pane) loader.load();
            
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

            Stage myStage = (Stage)this.btn_medio.getScene().getWindow();
            myStage.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
