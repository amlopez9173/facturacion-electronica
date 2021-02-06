package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Clase para invocar al servicio que lista las ventas
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorListarPorIdSale {
    private SaleService saleService;

    public ManejadorListarPorIdSale(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * Permite invocar al servicio que lista las ventas por id
     * @param saleId Identificador de la venta
     * @return venta filtrada por Id
     */

    public Optional<Sale> ejecutar(int saleId){
        return saleService.findById(saleId);
    }
}
