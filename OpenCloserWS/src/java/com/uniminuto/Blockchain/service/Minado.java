package com.uniminuto.Blockchain.service;

import com.uniminuto.Blockchain.bean.Bloque;
import java.util.ArrayList;

public class Minado {

    //Lista que guardará lo bloques creados
    public static ArrayList<Bloque> blockchain = new ArrayList<Bloque>();
    //dificultad de minado (número de ceros como objetivo)
    public static int dificultad = 5;
    
    public Minado(){        
    }
    
    //Método principal invocado por el service que inicia el programa
    //se reciben los parámetros de data (info del bloque), has previo (Hash del bloque anterior) y el ID
    public static String CrearBloque(String data, String hash, int id) {

        //Se crear y añade un bloque al Arraylist
        añadirBloque(new Bloque(data, hash, id));
        return minar(dificultad);
        
    }

    //método para añadir el bloque a la cadena, no se imprime
    public static void añadirBloque(Bloque nuevo) {
        minar(dificultad);
        blockchain.add(nuevo);
    }

    //Bloque b = new Bloque();
    //Método para calcular el hash utilizando los datos del bloque    
    public static String calcularHash() {

        String hashCalculado = StringCreator.Sha256(
                Bloque.hashAnterior
                + Long.toString(Bloque.marcaTiempo)//<------La marca de tiempo se puede omitir
                + Integer.toString(Bloque.nonce)
                + Bloque.datos
        );
        return hashCalculado;
    }

    //Método para minar el bloque, aumentará el nonce hasta obtener el número de ceros en la dificultad.
    public static String minar(int dificultad) {

        String target = StringCreator.getStringDificultad(dificultad); //Se crea un string con el número de ceros a obtener(dificultad)
        //Ejecutará el ciclo hasta que el substring esté lleno de ceros
        while (!Bloque.hash.substring(0, dificultad).equals(target)) {
            Bloque.nonce++;
            Bloque.hash = calcularHash();
        }
        //System.out.println("El bloque ha sido minado con éxito: " + Bloque.hash);
        //System.out.println("Su nonce es: " + Bloque.nonce);
        return "El bloque ha sido minado con éxito: " + Bloque.hash;
    }

}
