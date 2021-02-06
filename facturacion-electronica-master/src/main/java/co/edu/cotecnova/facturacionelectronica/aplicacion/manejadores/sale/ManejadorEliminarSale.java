package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

/**
 * Clase para invocar al servicio que elimina una venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorEliminarSale {
    private SaleService saleService;

    public ManejadorEliminarSale(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * Permite invocar al servicio de eliminar venta
     * @param saleId Identificador de la venta
     */

    public void ejecutar(int saleId){
        saleService.delete(saleId);
    }
}
