package co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoClient;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import org.springframework.stereotype.Component;

/**
 * Clase que se encarga de construir un cliente dado un comando cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class FabricaClient {
    public Client crear(ComandoClient comandoClient){
        return new Client(comandoClient.getClientId(), comandoClient.getDocument(), comandoClient.getName(), comandoClient.getLastname(), comandoClient.getAddress(), comandoClient.getEmail(), comandoClient.getPhone(), comandoClient.isActive(), comandoClient.getCreationDate());
    }
}
