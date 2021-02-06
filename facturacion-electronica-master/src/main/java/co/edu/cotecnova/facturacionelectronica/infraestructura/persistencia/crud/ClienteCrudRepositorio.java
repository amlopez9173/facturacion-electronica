package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interface que extiende de JPA para permitir las tareas de la base de datos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public interface ClienteCrudRepositorio extends PagingAndSortingRepository<Cliente, Integer> {
    Optional<Cliente> findByDocumento(String documento);
    List<Cliente> findByEstadoTrue();
}
