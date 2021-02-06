package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;
/**
 * Clase que invoca al servicio de actualizar un producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorActualizarProduct {
    private FabricaProduct fabricaProduct;
    private ProductService productService;

    public ManejadorActualizarProduct(FabricaProduct fabricaProduct, ProductService productService) {
        this.fabricaProduct = fabricaProduct;
        this.productService = productService;
    }

    /**
     * Permite invocar al servicio que actualiza los productos
     * @param comandoProduct Objeto con los atributos a actualizar
     * @param productId Identificador del producto
     * @return Producto actualizado
     */
    public Product ejecutar(ComandoProduct comandoProduct, int productId){
        Product product = fabricaProduct.crear(comandoProduct);
        return productService.update(product, productId);
    }
}
