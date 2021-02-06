package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Clase para listar todos las ventas de la base de datos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Component
public class ManejadorListarTodosSale {
    private SaleService saleService;

    public ManejadorListarTodosSale(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * Permite invocar al servicio que consulta las ventas activas
     * @return listado de ventas activas
     */

    public List<Sale> ejecutar(){
        return saleService.getAll();
    }
}
