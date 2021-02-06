package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Clase para listar todos los productos de la base de datos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorListarTodosProduct {
    private ProductService productService;

    public ManejadorListarTodosProduct(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Permite invocar al servicio que consulta los productos activos
     * @return listado de productos activos
     */
    public List<Product> ejecutar(){
        return productService.getAll();
    }
}
