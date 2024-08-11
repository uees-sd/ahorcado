package controlador;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Ahorcado;
import modelo.Cliente;
import modelo.Servidor;

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

    @FXML
    private Label lblPista;

    private String nivel;
    private String modo;
    private String labelPalabra;
    private String[] listaPalabras;
    private String[] pista;
    private int vidas;
    private int vidasOriginales;
    int numPalabra=0;
    int conteo=0;
    int conteoLista=0;
    int puntaje=0;
    Ahorcado ahorcado;

    private int puerto;

    @FXML
    void enviarLetra(ActionEvent event) {
        
        Ahorcado ahorcado = new Ahorcado(nivel);
        char letra =txtLetra.getText().charAt(0);
        String palabra = listaPalabras[numPalabra];
        String respuesta[]=ahorcado.compararLetra(letra,palabra,vidas,numPalabra,labelPalabra,conteo);
        setVidas(Integer.parseInt(respuesta[0]));
        this.labelPalabra= respuesta[1];
        setLblPalabra(respuesta[1]);
        this.txtLetra.clear();
        this.conteo=Integer.parseInt(respuesta[2]);
        System.out.println("vidas: "+this.vidas);
        System.out.println("conteo: "+this.conteo);
        int comparacion= listaPalabras.length;
        if (conteoLista<comparacion) {
            System.out.println(this.conteoLista+"_"+comparacion);
            if (conteo==palabra.length() && vidas>0) {
                System.out.println(conteo+"__"+palabra.length());
                this.conteoLista++;
                this.puntaje=puntaje+100;
                System.out.println("Puntaje: "+this.puntaje);
                System.out.println(this.conteoLista+"_"+comparacion);
                if(conteoLista<comparacion){
                    cambiarPalabra(ahorcado);
                }else{
                    enviarPuntaje();
                    System.out.println("juego terminado");
                }
            }
        }
    }

    private void cambiarPalabra(Ahorcado ahorcado) {
        this.numPalabra++;
        setLblPalabra(ahorcado.palabraAGuionesAPalabra(this.listaPalabras[this.numPalabra]));
        setLblPista(this.pista[this.numPalabra]);
        this.vidas=this.vidasOriginales;
        this.conteo=0;
        
    }

    public Game(){
        
    }

    public void setNivel(String nivel){
        this.nivel=nivel;
    }

    public void setModo(String modo){
        this.modo=modo;
    }

    public void setPalabras(String[] palabras){
        this.listaPalabras=palabras;
    }

    public void setVidas(int vidas){
        this.vidas=vidas;
    }


    public void setLblPalabra(String palabra) {
        // TODO Auto-generated method stub
        this.labelPalabra=palabra;
        this.lblPalabra.setText(palabra);
    }

    public void setGenero(String genero) {
        if (genero=="nina") {
            Image imagen = new Image("/nina.png");
            this.img_avatar.setImage(imagen);
            System.out.println("genero3: "+genero);
        }else{
            Image imagen = new Image("/nino.png");
            this.img_avatar.setImage(imagen);
            System.out.println("genero3: "+genero);
        }
        
    }

    public void setNombre(String nombre) {
        this.lbl_nombre.setText(nombre);
    }

    public void setVidasOriginales(int vidas2) {
        this.vidasOriginales=vidas2;
    }

    public void enviarPuntaje(){
        String[] mensaje = {this.lbl_nombre.getText(),Integer.toString(this.puntaje)};
        Cliente c = new Cliente(this.puerto, mensaje);
        c.setPuerto(this.puerto);
        c.Conectar(mensaje);
    }

    public void setPuerto(int puerto) {
        this.puerto=puerto;
    }

    public void setPista(String[] pista){
        this.pista=pista;
    }

    public void setLblPista(String pista) {
        this.lblPista.setText(pista);
    }
}
