package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
	void generoNina(ActionEvent event) {

	}

	@FXML
	void generoNino(ActionEvent event) {

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

	public void enviarModo(String modo) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Login.class.getResource("/vista/dificultad.fxml"));
			Pane ventana = (Pane) loader.load();

			Dificultad nivel = loader.getController();
			nivel.setModo(modo);

			Scene scene = new Scene(ventana);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			Stage myStage = (Stage) this.btn_solo.getScene().getWindow();
			myStage.close();


		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
