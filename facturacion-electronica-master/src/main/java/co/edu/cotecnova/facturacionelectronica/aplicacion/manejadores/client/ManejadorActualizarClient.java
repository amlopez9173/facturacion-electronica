package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoClient;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaClient;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

/**
 * Clase que invoca al servicio de actualizar un cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorActualizarClient {
    private FabricaClient fabricaClient;
    private ClientService clientService;

    public ManejadorActualizarClient(FabricaClient fabricaClient, ClientService clientService) {
        this.fabricaClient = fabricaClient;
        this.clientService = clientService;
    }

    /**
     * Permite invocar al servicio que actualiza los clientes
     * @param comandoClient Objeto con los atributos a actualizar
     * @param clientId Identificador del cliente
     * @return Cliente actualizado
     */

    public Client ejecutar(ComandoClient comandoClient, int clientId){
        Client client = fabricaClient.crear(comandoClient);
        return clientService.update(client, clientId);
    }
}
