package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
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
public interface ProductRepository {
    /**
     * Permite devolver todos los productos
     * @return Listado de productos
     */
    List<Product> getAll();

    /**
     * Permite buscar un producto por su id
     * @param productId Identificador del producto en la base de datos
     * @return El producto
     */
    Optional<Product> findById(int productId);

    /**
     * Permite guardar un producto
     * @param product Obtjeto con los atributos a almacenar en la base de datos
     * @return Producto almacenado en la base de datos
     */
    Product save(Product product);

    /**
     * Permite eliminar un producto
     * @param productId El identificador del producto
     */
    void delete(int productId);

    /**
     * Permite actualizar un producto
     * @param product Objeto producto con los datos a actualizar
     * @return Producto actualizado
     */
    Product update(Product product);

    /**
     * Permite buscar un producto en la base de datos filtrado por su codigo
     * @param code Codigo del producto almacenado en la base de datos
     * @return Producto buscado
     */
    Optional<Product> findByCode(int code);

    /**
     * Permite paginar el listado de productos almacenado en la base de datos
     * @param pageable Objeto con atributos page y size
     * @return Listado de productos paginados
     */
    Page<Product> findAll(Pageable pageable);
}
