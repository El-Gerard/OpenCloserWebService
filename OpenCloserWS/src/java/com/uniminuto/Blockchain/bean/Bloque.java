package com.uniminuto.Blockchain.bean;
import com.uniminuto.Blockchain.service.Minado;
import java.util.Date;

public class Bloque {

    public int Id;
    public static String hash; //Hash que se va a crear
    public static String hashAnterior; //Hash del bloque anterior
    public static String datos; //los datos del bloque(transacciones)
    public static long marcaTiempo; //Marca de tiempo obtenida de la fecha (se puede omitir)
    public static int nonce; //Número aleatorio para minar el bloque

    //Constructor de bloque.  
    public Bloque(String datos, String hashAnterior, int Id) {

        this.Id = Id;
        Bloque.datos = datos;
        Bloque.hashAnterior = hashAnterior;
        Bloque.marcaTiempo = new Date().getTime();
        Bloque.hash = Minado.calcularHash();
    }

    //Getters y setters estan en desuso
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public void setHashAnterior(String hashAnterior) {
        this.hashAnterior = hashAnterior;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public long getMarcaTiempo() {
        return marcaTiempo;
    }

    public void setMarcaTiempo(long marcaTiempo) {
        this.marcaTiempo = marcaTiempo;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

}
