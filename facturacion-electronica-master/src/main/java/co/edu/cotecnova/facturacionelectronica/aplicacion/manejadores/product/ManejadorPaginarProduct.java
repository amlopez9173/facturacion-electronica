package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Clase para paginar listado de productos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorPaginarProduct {
    private ProductService productService;

    public ManejadorPaginarProduct(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Permite ejecutar la accion de invocar al servicio de paginacion de productos
     * @param pageable Objeto que contiene los atributos page y size
     * @return Paginacion de los productos
     */
    public Page<Product> ejecutar(Pageable pageable){
        return productService.findAll(pageable);
    }
}
