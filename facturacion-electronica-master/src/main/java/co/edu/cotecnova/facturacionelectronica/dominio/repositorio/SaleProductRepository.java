package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;

import java.util.Optional;

/**
 * Interface que define el contrato a realizar por el repositorio
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public interface SaleProductRepository {

    /**
     * Permite guardar una venta producto
     * @param saleProduct Obtjeto con los atributos a almacenar en la base de datos
     * @return Venta Producto almacenada en la base de datos
     */
    SaleProduct save(SaleProduct saleProduct);

    /**
     * Permite eliminar una venta producto
     * @param saleProductId El identificador de la venta producto
     */
    void delete(int saleProductId);

    /**
     * Permite buscar una venta producto por su id
     * @param saleProductId Identificador de la venta producto en la base de datos
     * @return La venta producto
     */
    Optional<SaleProduct> findById(int saleProductId);
}
