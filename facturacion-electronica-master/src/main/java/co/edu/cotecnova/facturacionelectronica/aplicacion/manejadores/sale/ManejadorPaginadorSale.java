package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Clase para paginar listado de ventas
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class ManejadorPaginadorSale {
    private SaleService saleService;

    public ManejadorPaginadorSale(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * Permite ejecutar la accion de invocar al servicio de paginacion de ventas
     * @param pageable Objeto que contiene los atributos page y size
     * @return Paginacion de las ventas
     */

    public Page<Sale> ejecutar(Pageable pageable){
        return saleService.findAll(pageable);
    }
}
