package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoClient;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaClient;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

/**
 * Clase para crear un cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorCrearClient {
    private FabricaClient fabricaClient;
    private ClientService clientService;

    public ManejadorCrearClient(FabricaClient fabricaClient, ClientService clientService) {
        this.fabricaClient = fabricaClient;
        this.clientService = clientService;
    }

    /**
     * Metodo que se encarga de llamar al servicio y ejecutar la accion
     * @param comandoClient Objeto que contiene los parametros ingresados por el usuario
     * @return Client almacenado en la base de datos
     */

    public Client ejecutar(ComandoClient comandoClient){
        Client client = fabricaClient.crear(comandoClient);
        return clientService.save(client);
    }
}
