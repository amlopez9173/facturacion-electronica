package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * Clase para invocar al servicio que lista los productos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorListarPorIdProduct {
    private ProductService productService;

    public ManejadorListarPorIdProduct(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Permite invocar al servicio que lista los productos por id
     * @param productId Identificador del producto
     * @return Producto filtrado por Id
     */
    public Optional<Product> ejecutar(int productId){
        return productService.findById(productId);
    }
}
