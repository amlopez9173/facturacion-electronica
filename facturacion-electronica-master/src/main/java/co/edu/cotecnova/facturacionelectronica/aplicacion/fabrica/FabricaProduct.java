package co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import org.springframework.stereotype.Component;
/**
 * Clase que se encarga de construir un producto dado un comando producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class FabricaProduct {
    public Product crear(ComandoProduct comandoProduct){
        return new Product(comandoProduct.getProductId(), comandoProduct.getCode(), comandoProduct.getName(), comandoProduct.getPrice(), comandoProduct.isActive(),comandoProduct.getCreationDate());
    }
}
