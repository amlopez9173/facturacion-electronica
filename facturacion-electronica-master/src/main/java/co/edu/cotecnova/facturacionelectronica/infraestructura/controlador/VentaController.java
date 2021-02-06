package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSale;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale.*;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Clase que exponde todos los metodos disponibles para interacturar con la venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@RestController
@RequestMapping("/sales")
public class VentaController {
    private ManejadorCrearSale manejadorCrearSale;
    private ManejadorActualizarSale manejadorActualizarSale;
    private ManejadorEliminarSale manejadorEliminarSale;
    private ManejadorListarTodosSale manejadorListarTodosSale;
    private ManejadorListarPorIdSale manejadorListarPorIdSale;
    private ManejadorPaginadorSale manejadorPaginadorSale;

    public VentaController(ManejadorCrearSale manejadorCrearSale, ManejadorActualizarSale manejadorActualizarSale, ManejadorEliminarSale manejadorEliminarSale, ManejadorListarTodosSale manejadorListarTodosSale, ManejadorListarPorIdSale manejadorListarPorIdSale, ManejadorPaginadorSale manejadorPaginadorSale) {
        this.manejadorCrearSale = manejadorCrearSale;
        this.manejadorActualizarSale = manejadorActualizarSale;
        this.manejadorEliminarSale = manejadorEliminarSale;
        this.manejadorListarTodosSale = manejadorListarTodosSale;
        this.manejadorListarPorIdSale = manejadorListarPorIdSale;
        this.manejadorPaginadorSale = manejadorPaginadorSale;
    }

    /**
     * Metodo que permite listar todos las ventas activas de la base de datos
     * @return Estado de la operacion
     */
    @GetMapping
    @ApiOperation("Obtener listado de ventas activos")
    @ApiResponse(code = 200, message = "Listado correctamente")
    public ResponseEntity<List<Sale>> getAll(){
        return new ResponseEntity<>(manejadorListarTodosSale.ejecutar(), HttpStatus.OK);
    }

    /**
     * Metodo que permite listar las ventas de manera paginada
     * @param pageable Objeto con los atributos page y size
     * @return Estado de la operacion
     */
    @GetMapping("/paginador")
    @ApiOperation("Obtener listado de ventas de forma paginada")
    @ApiResponse(code = 200, message = "Listado correctamente")
    public ResponseEntity<Page<Sale>> findAll(@ApiParam(value = "Objeto pageable que contiene cantidad elementos por pagina y la pagina", required = true, example = "page=0, size=3")Pageable pageable){
        return new ResponseEntity<>(manejadorPaginadorSale.ejecutar(pageable), HttpStatus.OK);
    }

    /**
     * Metodo que permite obtener una venta por su id
     * @param saleId Identificador de la venta
     * @return Estado de la operacion
     */
    @GetMapping("/{id}")
    @ApiOperation("Obtener una venta por su id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Listado correctamente"),
            @ApiResponse(code = 400, message = "El id no fue encontrado en la base de datos")
    })
    public ResponseEntity<Optional<Sale>> findById(@ApiParam(value = "El id del producto", required = true, example = "3")@PathVariable("id") int saleId){
        return new ResponseEntity<>(manejadorListarPorIdSale.ejecutar(saleId), HttpStatus.OK);
    }

    /**
     * Metodo que permite guardar una venta
     * @param comandoSale Objeto que mapea los atributos de la venta
     * @return Estado de la operacion
     */
    @PostMapping
    @ApiOperation("Guardar una venta en la base de datos")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Venta almacenado en la base de datos"),
            @ApiResponse(code = 400, message = "El clienteid de la venta ya existe en la base de datos")
    })
    public ResponseEntity<Sale> save(@ApiParam(value = "Objeto venta", required = true, example = "clientId:2, purchaseValue:255500.0")@RequestBody ComandoSale comandoSale){
        comandoSale.setActive(true);
        comandoSale.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(manejadorCrearSale.ejecutar(comandoSale), HttpStatus.CREATED);
    }

    /**
     * Metodo que permite actualizar la informacion de una venta
     * @param comandoSale Objeto que mapea los atributos de la venta
     * @param saleId Identificador de la venta
     * @return Estado de la operacion
     */
    @PutMapping("/{id}")
    @ApiOperation("Permite actualizar la informacion de una venta")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Venta actualizado con exito"),
            @ApiResponse(code = 400, message = "El clienteid de la venta no existe en la base datos"),
    })
    public ResponseEntity<Sale> update(@ApiParam(value = "Objeto venta", required = true, example = "clientId:3, active:true, purchaseValue:11.0, creationDate:2021-01-20T17:45:05.128872")@RequestBody ComandoSale comandoSale, @PathVariable("id") int saleId){
        comandoSale.setSaleId(saleId);
        return new ResponseEntity<>(manejadorActualizarSale.ejecutar(comandoSale, saleId), HttpStatus.OK);
    }

    /**
     * Metodo que permite eliminar una venta
     * @param saleId Identificador de la venta
     * @return Estado de la operacion
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Permite eliminar una venta dando su id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Venta eliminada con exito"),
            @ApiResponse(code = 400, message = "El clienteid de la venta no fue encontrado"),
    })
    public ResponseEntity<Void> delete(@ApiParam(value = "El id de la venta", required = true, example = "3")@PathVariable("id") int saleId){
        manejadorEliminarSale.ejecutar(saleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
