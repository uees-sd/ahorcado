package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Login extends Application {

	@FXML
	private AnchorPane anchor_login;

	@FXML
	private Button btn_iniciar;

	@FXML
	void inciar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Login.class.getResource("/vista/modo.fxml"));
			Pane ventana = (Pane) loader.load();

			Scene scene = new Scene(ventana);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			Stage myStage = (Stage) this.btn_iniciar.getScene().getWindow();
			myStage.close();

		} catch (Exception e) {
			// TODO: handle exception
		}


	}


	@Override
	public void start(Stage primaryStage) throws Exception {
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
