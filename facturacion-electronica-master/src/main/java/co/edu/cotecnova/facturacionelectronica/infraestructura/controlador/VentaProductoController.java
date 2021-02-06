package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSaleProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.saleproduct.ManejadorCrearSaleProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.saleproduct.ManejadorEliminarSaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase que exponde todos los metodos disponibles para interacturar con la venta producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@RestController
@RequestMapping("/saleproducts")
public class VentaProductoController {
    private ManejadorCrearSaleProduct manejadorCrearSaleProduct;
    private ManejadorEliminarSaleProduct manejadorEliminarSaleProduct;

    public VentaProductoController(ManejadorCrearSaleProduct manejadorCrearSaleProduct, ManejadorEliminarSaleProduct manejadorEliminarSaleProduct) {
        this.manejadorCrearSaleProduct = manejadorCrearSaleProduct;
        this.manejadorEliminarSaleProduct = manejadorEliminarSaleProduct;
    }

    /**
     * Metodo que permite guardar una venta producto
     * @param comandoSaleProduct Objeto que mapea los atributos de la venta producto
     * @return Estado de la operacion
     */
    @PostMapping
    @ApiOperation("Guardar una venta producto en la base de datos")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Venta Producto almacenada en la base de datos"),
            @ApiResponse(code = 400, message = "El productoid de la venta producto ya existe en la base de datos")
    })
    public ResponseEntity<SaleProduct> save(@ApiParam(value = "Objeto venta Producto", required = true, example = "productId:29, saleId:3, quantity:10@RequestBody")@RequestBody ComandoSaleProduct comandoSaleProduct){
        return new ResponseEntity<>(manejadorCrearSaleProduct.ejecutar(comandoSaleProduct), HttpStatus.CREATED);
    }

    /**
     * Metodo que permite eliminar una venta producto
     * @param saleProductId Identificador de la venta producto
     * @return Estado de la operacion
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Permite eliminar una venta producto dando su id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Venta Producto eliminada con exito"),
            @ApiResponse(code = 400, message = "El productoid de la venta producto no fue encontrado"),
    })
    public ResponseEntity<Void> delete(@ApiParam(value = "Objeto venta Producto", required = true, example = "2")@PathVariable("id") int saleProductId){
        manejadorEliminarSaleProduct.ejecutar(saleProductId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
