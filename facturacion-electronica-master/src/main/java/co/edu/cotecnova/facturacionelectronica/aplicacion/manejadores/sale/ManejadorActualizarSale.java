package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSale;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaSale;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

/**
 * Clase que invoca al servicio de actualizar una venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorActualizarSale {
    private SaleService saleService;
    private FabricaSale fabricaSale;

    public ManejadorActualizarSale(SaleService saleService, FabricaSale fabricaSale) {
        this.saleService = saleService;
        this.fabricaSale = fabricaSale;
    }

    /**
     * Permite invocar al servicio que actualiza las ventas
     * @param comandoSale Objeto con los atributos a actualizar
     * @param saleId Identificador de la venta
     * @return Venta actualizado
     */

    public Sale ejecutar(ComandoSale comandoSale, int saleId){
        Sale sale = fabricaSale.crear(comandoSale);
        return saleService.update(sale, saleId);
    }
}
