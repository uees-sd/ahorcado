package modelo;

import java.util.Scanner;

import controlador.Game;

public class Ahorcado {
    String nivel;
    public Ahorcado(){

    }

    public Ahorcado(String nivel){
        this.nivel=nivel;
    }

    public String[] compararLetra(char letra, String palabra, int vidas, int numPalabra, String labelPalabra, int conteo){
        String[] respuesta={"",""};
        respuesta = procesoComparar(letra, palabra, vidas, numPalabra, labelPalabra, conteo);
        return respuesta;
    }

    public String convertirString(char[] charArray){
        String palabra=new String(charArray);
        return palabra;
    }

    public String palabraAGuionesAPalabra(String palabra){
        String respuesta="";
        char[] palabraGuiones = new char[palabra.length()];
        for (int j = 0; j < palabraGuiones.length; j++) {
            palabraGuiones[j]='_';
        }
        return respuesta=convertirString(palabraGuiones);
    }

    public String[] procesoComparar(char letra, String palabra, int vidas, int numPalabra, String labelPalabra, int conteo){
        boolean validacion= false;
        String[] respuesta={"","",""};
        System.out.println("entro al modo facil");
        System.out.println("palabra secreta es: "+palabra);

        char[] palabraGuiones = new char[labelPalabra.length()];
        for (int j = 0; j < palabraGuiones.length; j++) {
            palabraGuiones[j]=labelPalabra.charAt(j);
        }
        if (validacion==false) {
            for (int k = 0; k < palabraGuiones.length; k++) {
                

                if (palabra.charAt(k)==letra) {
                    palabraGuiones[k]=letra;
                    validacion= true;
                    conteo++;
                }
            }
            labelPalabra= convertirString(palabraGuiones);
            System.out.println("nuevos guiones: "+ labelPalabra);
        }
        if (validacion == false) {
            vidas--;
        }
        respuesta[0]= Integer.toString(vidas);
        respuesta[1]=labelPalabra;
        respuesta[2]=Integer.toString(conteo);
        return respuesta;
    }
    
}
