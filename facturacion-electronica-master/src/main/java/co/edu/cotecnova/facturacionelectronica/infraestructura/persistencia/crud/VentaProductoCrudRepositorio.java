package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.VentaProducto;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que extiende de JPA para permitir las tareas de la base de datos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public interface VentaProductoCrudRepositorio extends CrudRepository<VentaProducto, Integer> {
}
