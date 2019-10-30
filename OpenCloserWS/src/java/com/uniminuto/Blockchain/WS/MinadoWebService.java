package com.uniminuto.Blockchain.WS;
import com.uniminuto.Blockchain.service.Minado;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "MinadoWebService")
public class MinadoWebService {

    //Minado m = new Minado();

    @WebMethod(operationName = "Minar")
    public String minar(
            @WebParam(name = "data") String data,
            @WebParam(name = "hash_previo") String hash,
            @WebParam(name = "Id_bloque") int id) {

        return Minado.CrearBloque(data, hash, id);
    }
}
