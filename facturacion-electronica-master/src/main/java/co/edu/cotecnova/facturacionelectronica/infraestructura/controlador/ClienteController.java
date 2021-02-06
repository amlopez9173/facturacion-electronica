package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoClient;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client.*;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
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
 * Clase que expande todos los metodos disponibles para interacturar con el cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@RestController
@RequestMapping("/clients")
public class ClienteController {
    private ManejadorCrearClient manejadorCrearClient;
    private ManejadorActualizarClient manejadorActualizarClient;
    private ManejadorEliminarClient manejadorEliminarClient;
    private ManejadorListarTodosClient manejadorListarTodosClient;
    private ManejadorListarPorIdClient manejadorListarPorIdClient;
    private ManejadorPaginarClient manejadorPaginarClient;

    public ClienteController(ManejadorCrearClient manejadorCrearClient, ManejadorActualizarClient manejadorActualizarClient, ManejadorEliminarClient manejadorEliminarClient, ManejadorListarTodosClient manejadorListarTodosClient, ManejadorListarPorIdClient manejadorListarPorIdClient, ManejadorPaginarClient manejadorPaginarClient) {
        this.manejadorCrearClient = manejadorCrearClient;
        this.manejadorActualizarClient = manejadorActualizarClient;
        this.manejadorEliminarClient = manejadorEliminarClient;
        this.manejadorListarTodosClient = manejadorListarTodosClient;
        this.manejadorListarPorIdClient = manejadorListarPorIdClient;
        this.manejadorPaginarClient = manejadorPaginarClient;
    }

    /**
     * Metodo que permite listar todos los clientes activos de la base de datos
     * @return Estado de la operacion
     */
    @GetMapping
    @ApiOperation("Obtener listado de clientes activos")
    @ApiResponse(code = 200, message = "Listado correctamente")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(manejadorListarTodosClient.ejecutar(), HttpStatus.OK);
    }

    /**
     * Metodo que permite listar los clientes de manera paginada
     * @param pageable Objeto con los atributos page y size
     * @return Estado de la operacion
     */
    @GetMapping("/paginador")
    @ApiOperation("Obtener listado de clientes de forma paginada")
    @ApiResponse(code = 200, message = "Listado correctamente")
    public ResponseEntity<Page<Client>> findAll(@ApiParam(value = "Objeto pageable que contiene cantidad elementos por pagina y la pagina", required = true, example = "page=0, size=3")Pageable pageable){
        return new ResponseEntity<>(manejadorPaginarClient.ejecutar(pageable), HttpStatus.OK);
    }

    /**
     * Metodo que permite obtener un cliente por su id
     * @param clientID Identificador del cliente
     * @return Estado de la operacion
     */
    @GetMapping("/{id}")
    @ApiOperation("Obtener un cliente por su id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Listado correctamente"),
            @ApiResponse(code = 400, message = "El id no fue encontrado en la base de datos")
    })
    public ResponseEntity<Optional<Client>> findById(@ApiParam(value = "El id del cliente", required = true, example = "3")@PathVariable("id") int clientID){
        return new ResponseEntity<>(manejadorListarPorIdClient.ejecutar(clientID), HttpStatus.OK);
    }

    /**
     * Metodo que permite guardar un cliente
     * @param comandoClient Objeto que mapea los atributos del cliente
     * @return Estado de la operacion
     */
    @PostMapping
    @ApiOperation("Guardar un cliente en la base de datos")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cliente almacenado en la base de datos"),
            @ApiResponse(code = 400, message = "El documento del cliente ya existe en la base de datos")
    })
    public ResponseEntity<Client> save(@ApiParam(value = "Objeto cliente", required = true, example = "document:78912312, name:Santiago, lastname:Giraldo, address:Calle 25 # 34-15 email:giraldo@gmail.com, phone:3323232323")@RequestBody ComandoClient comandoClient){
        comandoClient.setActive(true);
        comandoClient.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(manejadorCrearClient.ejecutar(comandoClient), HttpStatus.CREATED);
    }

    /**
     * Metodo que permite actualizar la informacion de un cliente
     * @param comandoClient Objeto que mapea los atributos del cliente
     * @param clientId Identificador del cliente
     * @return Estado de la operacion
     */
    @PutMapping("/{id}")
    @ApiOperation("Permite actualizar la informacion de un cliente, permite desactivar el cliente")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cliente actualizado con exito"),
            @ApiResponse(code = 400, message = "El id del cliente no existe en la base datos"),
    })
    public ResponseEntity<Client> update(@ApiParam(value = "Objeto cliente", required = true, example = "document:78912312, name:Santiago, lastname:Giraldo, address:Calle 25 # 34-15 email:giraldo@gmail.com, phone:3323232323, active:true, creationDate:2021-01-19T23:48:12")@RequestBody ComandoClient comandoClient, @PathVariable("id") int clientId){
        comandoClient.setClientId(clientId);
        return new ResponseEntity<>(manejadorActualizarClient.ejecutar(comandoClient, clientId), HttpStatus.OK);
    }

    /**
     * Metodo que permite eliminar un cliente
     * @param clientId Identificador del cliente
     * @return Estado de la operacion
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Permite eliminar un producto dando su id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Producto eliminado con exito"),
            @ApiResponse(code = 400, message = "El id del producto no fue encontrado"),
    })
    public ResponseEntity<Void> delete(@ApiParam(value = "El id del cliente", required = true, example = "3")@PathVariable("id") int clientId){
        manejadorEliminarClient.ejecutar(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
