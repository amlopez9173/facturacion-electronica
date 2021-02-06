package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Clase para listar todos los clientes de la base de datos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorListarTodosClient {
    private ClientService clientService;

    public ManejadorListarTodosClient(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Permite invocar al servicio que consulta los clientes activos
     * @return listado de clientes activos
     */

    public List<Client> ejecutar(){
        return clientService.getAll();
    }
}
