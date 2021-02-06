package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;
/**
 * Clase para crear un producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorCrearProduct {
    private ProductService productService;
    private FabricaProduct fabricaProduct;

    public ManejadorCrearProduct(ProductService productService, FabricaProduct fabricaProduct) {
        this.productService = productService;
        this.fabricaProduct = fabricaProduct;
    }

    /**
     * Metodo que se encarga de llamar al servicio y ejecutar la accion
     * @param comandoProduct Objeto que contiene los parametros ingresados por el usuario
     * @return Product almacenado en la base de datos
     */
    public Product ejecutar(ComandoProduct comandoProduct){
        Product product = fabricaProduct.crear(comandoProduct);
        return productService.save(product);
    }
}
