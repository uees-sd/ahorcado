package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Ahorcado;

public class Game {

	@FXML
	private AnchorPane anchor_login;

	@FXML
	private Button btnEnviar;

	@FXML
	private ImageView img_avatar;

	@FXML
	private Label lblPalabra;

	@FXML
	private Label lbl_nombre;

	@FXML
	private TextField txtLetra;

	private String nivel;
	private String modo;
	private String labelPalabra;
	private String[] listaPalabras;
	private int vidas;
	int numPalabra = 0;
	Ahorcado ahorcado;

	@FXML
	void enviarLetra(ActionEvent event) {

		Ahorcado ahorcado = new Ahorcado(nivel);
		char letra = txtLetra.getText().charAt(0);
		String respuesta[] = ahorcado.compararLetra(letra, listaPalabras[numPalabra], vidas, numPalabra, labelPalabra);
		setVidas(Integer.parseInt(respuesta[0]));
		this.labelPalabra = respuesta[1];
		setLblPalabra(respuesta[1]);
		this.txtLetra.clear();
		System.out.println(this.vidas);
        
        /*try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }*/

	}

	public Game() {

	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public void setPalabras(String[] palabras) {
		this.listaPalabras = palabras;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}


	public void setLblPalabra(String palabra) {
		// TODO Auto-generated method stub
		this.labelPalabra = palabra;
		this.lblPalabra.setText(palabra);
	}
}
