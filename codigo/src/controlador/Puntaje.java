package controlador;

import java.util.Observer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelo.Servidor;

public class Puntaje {

    @FXML
    private Button btnIniciar;

    @FXML
    private ListView<?> lst_jugadores;

    @FXML
    private TextField txtEx;

    @FXML
    void iniciarCliente(ActionEvent event) {

    }


    public Puntaje(){
        
    }     

}
