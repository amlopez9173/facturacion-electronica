package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

/**
 * Clase para invocar al servicio que elimina un cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorEliminarClient {
    private ClientService clientService;

    public ManejadorEliminarClient(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Permite invocar al servicio de eliminar cliente
     * @param clientId Identificador del cliente
     */

    public void ejecutar(int clientId){
        clientService.delete(clientId);
    }
}
