package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.saleproduct;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleProductService;
import org.springframework.stereotype.Component;

/**
 * Clase para invocar al servicio que elimina una venta producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorEliminarSaleProduct {
    private SaleProductService saleProductService;

    public ManejadorEliminarSaleProduct(SaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }

    /**
     * Permite invocar al servicio de eliminar venta producto
     * @param saleProductId Identificador de la venta producto
     */

    public void ejecutar(int saleProductId){
        saleProductService.delete(saleProductId);
    }
}
