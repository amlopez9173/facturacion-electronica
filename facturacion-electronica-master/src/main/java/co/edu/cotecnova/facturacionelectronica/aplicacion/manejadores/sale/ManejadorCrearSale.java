package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSale;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaSale;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

/**
 * Clase para crear una venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorCrearSale {
    private SaleService saleService;
    private FabricaSale fabricaSale;

    public ManejadorCrearSale(SaleService saleService, FabricaSale fabricaSale) {
        this.saleService = saleService;
        this.fabricaSale = fabricaSale;
    }

    /**
     * Metodo que se encarga de llamar al servicio y ejecutar la accion
     * @param comandoSale Objeto que contiene los parametros ingresados por el usuario
     * @return Venta almacenada en la base de datos
     */

    public Sale ejecutar(ComandoSale comandoSale){
        Sale sale = fabricaSale.crear(comandoSale);
        return saleService.save(sale);
    }
}
