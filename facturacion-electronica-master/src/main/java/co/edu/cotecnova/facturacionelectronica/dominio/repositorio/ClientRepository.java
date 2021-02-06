package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface que define el contrato a realizar por el repositorio
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public interface ClientRepository {

    /**
     * Permite devolver todos los clientes
     * @return Listado de clientes
     */
    List<Client> getAll();

    /**
     * Permite buscar un cliente por su id
     * @param clientId Identificador del cliente en la base de datos
     * @return El cliente
     */
    Optional<Client> findById(int clientId);

    /**
     * Permite guardar un cliente
     * @param client Obtjeto con los atributos a almacenar en la base de datos
     * @return Cliente almacenado en la base de datos
     */
    Client save(Client client);

    /**
     * Permite eliminar un cliente
     * @param clientId El identificador del cliente
     */
    void delete(int clientId);

    /**
     * Permite actualizar un cliente
     * @param client Objeto cliente con los datos a actualizar
     * @return Cliente actualizado
     */
    Client update(Client client);

    /**
     * Permite buscar un cliente en la base de datos filtrado por su documento
     * @param document documento del cliente almacenado en la base de datos
     * @return Cliente buscado
     */
    Optional<Client> findByDocument(String document);

    /**
     * Permite paginar el listado de clientes almacenado en la base de datos
     * @param pageable Objeto con atributos page y size
     * @return Listado de clientes paginados
     */
    Page<Client> findAll(Pageable pageable);
}
