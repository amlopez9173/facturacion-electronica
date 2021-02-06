package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;
/**
 * Clase para invocar al servicio que elimina un producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorEliminarProduct {
    private ProductService productService;

    public ManejadorEliminarProduct(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Permite invocar al servicio de eliminar producto
     * @param productId Identificador del producto
     */
    public void ejecutar(int productId){
        productService.delete(productId);
    }
}
