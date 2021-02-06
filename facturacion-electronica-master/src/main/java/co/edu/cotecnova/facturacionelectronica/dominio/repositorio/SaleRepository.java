package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
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

public interface SaleRepository {

    /**
     * Permite devolver todas las ventas
     * @return Listado de ventas
     */
    List<Sale> getAll();

    /**
     * Permite buscar una venta por su id
     * @param saleId Identificador de la venta en la base de datos
     * @return La venta
     */
    Optional<Sale> findById(int saleId);

    /**
     * Permite guardar una venta
     * @param sale Obtjeto con los atributos a almacenar en la base de datos
     * @return Venta almacenada en la base de datos
     */
    Sale save(Sale sale);

    /**
     * Permite actualizar una venta
     * @param sale Objeto venta con los datos a actualizar
     * @return Venta actualizada
     */
    Sale update(Sale sale);

    /**
     * Permite eliminar una venta
     * @param saleId El identificador de la venta
     */
    void delete(int saleId);

    /**
     * Permite paginar el listado de ventas almacenadas en la base de datos
     * @param pageable Objeto con atributos page y size
     * @return Listado de ventas paginadas
     */
    Page<Sale> findAll(Pageable pageable);
}
