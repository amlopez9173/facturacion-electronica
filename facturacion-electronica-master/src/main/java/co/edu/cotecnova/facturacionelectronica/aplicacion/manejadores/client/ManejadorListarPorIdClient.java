package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Clase para invocar al servicio que lista los clientes
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorListarPorIdClient {
    private ClientService clientService;

    public ManejadorListarPorIdClient(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Permite invocar al servicio que lista los clientes por id
     * @param clientId Identificador del cliente
     * @return cliente filtrado por Id
     */

    public Optional<Client> ejecutar(int clientId){
        return clientService.findById(clientId);
    }
}
