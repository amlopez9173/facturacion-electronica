package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product.*;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
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
 * Clase que exponde todos los metodos disponibles para interacturar con el producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@RestController
@RequestMapping("/products")
public class ProductoController {
    private ManejadorCrearProduct manejadorCrearProduct;
    private ManejadorActualizarProduct manejadorActualizarProduct;
    private ManejadorEliminarProduct manejadorEliminarProduct;
    private ManejadorListarTodosProduct manejadorListarTodosProduct;
    private ManejadorListarPorIdProduct manejadorListarPorIdProduct;
    private ManejadorPaginarProduct manejadorPaginarProduct;

    public ProductoController(ManejadorCrearProduct manejadorCrearProduct, ManejadorActualizarProduct manejadorActualizarProduct, ManejadorEliminarProduct manejadorEliminarProduct, ManejadorListarTodosProduct manejadorListarTodosProduct, ManejadorListarPorIdProduct manejadorListarPorIdProduct, ManejadorPaginarProduct manejadorPaginarProduct) {
        this.manejadorCrearProduct = manejadorCrearProduct;
        this.manejadorActualizarProduct = manejadorActualizarProduct;
        this.manejadorEliminarProduct = manejadorEliminarProduct;
        this.manejadorListarTodosProduct = manejadorListarTodosProduct;
        this.manejadorListarPorIdProduct = manejadorListarPorIdProduct;
        this.manejadorPaginarProduct = manejadorPaginarProduct;
    }

    /**
     * Metodo que permite listar todos los productos activos de la base de datos
     * @return Estado de la operacion
     */
    @GetMapping
    @ApiOperation("Obtener listado de productos activos")
    @ApiResponse(code = 200, message = "Listado correctamente")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(manejadorListarTodosProduct.ejecutar(), HttpStatus.OK);
    }

    /**
     * Metodo que permite listar los productos de manera paginada
     * @param pageable Objeto con los atributos page y size
     * @return Estado de la operacion
     */
    @GetMapping("/paginador")
    @ApiOperation("Obtener listado de productos de forma paginada")
    @ApiResponse(code = 200, message = "Listado correctamente")
    public ResponseEntity<Page<Product>> findAll(@ApiParam(value = "Objeto pageable que contiene cantidad elementos por pagina y la pagina", required = true, example = "page=0, size=3") Pageable pageable){
        return new ResponseEntity<>(manejadorPaginarProduct.ejecutar(pageable), HttpStatus.OK);
    }

    /**
     * Metodo que permite obtener un producto por su id
     * @param productId Identificador del producto
     * @return Estado de la operacion
     */
    @GetMapping("/{id}")
    @ApiOperation("Obtener un producto por su id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Listado correctamente"),
            @ApiResponse(code = 400, message = "El id no fue encontrado en la base de datos")
    })
    public ResponseEntity<Optional<Product>> findById(@ApiParam(value = "El id del producto", required = true, example = "26") @PathVariable("id") int productId){
        return new ResponseEntity<>(manejadorListarPorIdProduct.ejecutar(productId), HttpStatus.OK);
    }

    /**
     * Metodo que permite guardar un producto
     * @param comandoProduct Objeto que mapea los atributos del producto
     * @return Estado de la operacion
     */
    @PostMapping
    @ApiOperation("Guardar un producto en la base de datos")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Producto almacenado en la base de datos"),
            @ApiResponse(code = 400, message = "El codigo del producto ya existe en la base de datos")
    })
    public ResponseEntity<Product> save(@ApiParam(value = "Objeto Producto", required = true, example = "code=9010, name=cuaderno, price=450") @RequestBody ComandoProduct comandoProduct){
        comandoProduct.setActive(true);
        comandoProduct.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(manejadorCrearProduct.ejecutar(comandoProduct), HttpStatus.CREATED);
    }

    /**
     * Metodo que permite actualizar la informacion de un producto
     * @param comandoProduct Objeto que mapea los atributos del producto
     * @param productId Identificador del producto
     * @return Estado de la operacion
     */
    @PutMapping("/{id}")
    @ApiOperation("Permite actualizar la informacion de un producto, permite desactivar el producto")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Producto actualizado con exito"),
            @ApiResponse(code = 400, message = "El id del producto no existe en la base datos"),
    })
    public ResponseEntity<Product> update(@ApiParam(value = "Objeto producto", required = true, example = "code=9090, name=cuaderno, price=245, active=true, creationDate=2021-01-18T00:00:00") @RequestBody ComandoProduct comandoProduct,@ApiParam(value = "El id del producto a actualizar", required = true, example = "26") @PathVariable("id") int productId){
        comandoProduct.setProductId(productId);
        return new ResponseEntity<>(manejadorActualizarProduct.ejecutar(comandoProduct, productId), HttpStatus.OK);
    }

    /**
     * Metodo que permite eliminar un producto
     * @param productId Identificador del producto
     * @return Estado de la operacion
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Permite eliminar un producto dando su id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Producto eliminado con exito"),
            @ApiResponse(code = 400, message = "El id del producto no fue encontrado"),
    })
    public ResponseEntity<Void> delete(@ApiParam(value = "El id del producto", required = true, example = "26") @PathVariable("id") int productId){
        manejadorEliminarProduct.ejecutar(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
