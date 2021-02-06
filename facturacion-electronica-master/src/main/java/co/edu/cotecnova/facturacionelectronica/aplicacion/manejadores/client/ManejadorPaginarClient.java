package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Clase para paginar listado de clientes
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorPaginarClient {
    private ClientService clientService;

    public ManejadorPaginarClient(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Permite ejecutar la accion de invocar al servicio de paginacion de clientes
     * @param pageable Objeto que contiene los atributos page y size
     * @return Paginacion de los clientes
     */

    public Page<Client> ejecutar(Pageable pageable){
        return clientService.findAll(pageable);
    }
}
