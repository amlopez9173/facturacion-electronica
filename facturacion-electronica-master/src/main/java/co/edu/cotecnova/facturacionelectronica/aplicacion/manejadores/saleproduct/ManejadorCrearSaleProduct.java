package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.saleproduct;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSaleProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaSaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleProductService;
import org.springframework.stereotype.Component;

/**
 * Clase para crear una venta producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorCrearSaleProduct {
    private SaleProductService saleProductService;
    private FabricaSaleProduct fabricaSaleProduct;

    public ManejadorCrearSaleProduct(SaleProductService saleProductService, FabricaSaleProduct fabricaSaleProduct) {
        this.saleProductService = saleProductService;
        this.fabricaSaleProduct = fabricaSaleProduct;
    }

    /**
     * Metodo que se encarga de llamar al servicio y ejecutar la accion
     * @param comandoSaleProduct Objeto que contiene los parametros ingresados por el usuario
     * @return Venta Product almacenado en la base de datos
     */

    public SaleProduct ejecutar(ComandoSaleProduct comandoSaleProduct){
        SaleProduct saleProduct = fabricaSaleProduct.crear(comandoSaleProduct);
        return saleProductService.save(saleProduct);
    }
}
