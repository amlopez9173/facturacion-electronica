package co.edu.cotecnova.facturacionelectronica.infraestructura.error;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ClientException;
import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ProductExcepcion;
import co.edu.cotecnova.facturacionelectronica.dominio.excepion.SaleException;
import co.edu.cotecnova.facturacionelectronica.dominio.excepion.SaleProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {
    private static final String OCURRIO_ERROR_FAVOR_CONTACTAR_ADMINISTRADOR = "Ocurrio un error, favor contactar al administrador";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {
        CODIGOS_ESTADO.put(ProductExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ClientException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(SaleException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(SaleProductException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception){
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if(codigo != null){
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        }else{
            Error error = new Error(excepcionNombre, OCURRIO_ERROR_FAVOR_CONTACTAR_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }

}
