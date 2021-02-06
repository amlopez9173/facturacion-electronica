package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product.*;
import co.edu.cotecnova.facturacionelectronica.databuilder.ProductTestDataBuilder;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductoControllerTest {

    private static final int OK = 200;
    private static final int CREATED = 201;
    private static final int NO_CONTENT = 204;

    private List<Product> productList = new ArrayList<>();
    private Product product = new ProductTestDataBuilder().build();

    private ComandoProduct comandoProduct = new ProductTestDataBuilder().buildComando();

    private Page<Product> productPage;
    private Pageable pageable;

    @Mock
    private ManejadorCrearProduct manejadorCrearProduct;

    @Mock
    private ManejadorActualizarProduct manejadorActualizarProduct;

    @Mock
    private ManejadorEliminarProduct manejadorEliminarProduct;

    @Mock
    private ManejadorListarTodosProduct manejadorListarTodosProduct;

    @Mock
    private ManejadorListarPorIdProduct manejadorListarPorIdProduct;

    @Mock
    private ManejadorPaginarProduct manejadorPaginarProduct;

    @InjectMocks
    private ProductoController productoController;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        productList.add(product);
        productPage = new PageImpl<>(productList);
    }

    @Test
    void getAllTest() {
        Mockito.when(manejadorListarTodosProduct.ejecutar()).thenReturn(productList);

        ResponseEntity<List<Product>> responseEntityLocal = productoController.getAll();

        assertEquals(OK, responseEntityLocal.getStatusCodeValue());
    }

    @Test
    void findAllTest() {
        Mockito.when(manejadorPaginarProduct.ejecutar(pageable)).thenReturn(productPage);

        ResponseEntity<Page<Product>> responseEntityLocal = productoController.findAll(pageable);

        assertEquals(OK, responseEntityLocal.getStatusCodeValue());
    }

    @Test
    void findByIdTest() {
        Mockito.when(manejadorListarPorIdProduct.ejecutar(PRODUCT_ID)).thenReturn(Optional.of(product));

        ResponseEntity<Optional<Product>> responseEntityLocal = productoController.findById(PRODUCT_ID);

        assertEquals(OK, responseEntityLocal.getStatusCodeValue());
    }

    @Test
    void saveTest() {
        Mockito.when(manejadorCrearProduct.ejecutar(comandoProduct)).thenReturn(product);

        ResponseEntity<Product> responseEntityLocal = productoController.save(comandoProduct);

        assertEquals(CREATED, responseEntityLocal.getStatusCodeValue());
    }

    @Test
    void updateTest() {
        Mockito.when(manejadorActualizarProduct.ejecutar(comandoProduct, PRODUCT_ID)).thenReturn(product);
        ResponseEntity<Product> responseEntityLocal = productoController.update(comandoProduct, PRODUCT_ID);
        assertEquals(OK, responseEntityLocal.getStatusCodeValue());
    }

    @Test
    void deleteTest() {
        Mockito.doNothing().when(manejadorEliminarProduct).ejecutar(PRODUCT_ID);

        ResponseEntity<Void> responseEntityLocal = productoController.delete(PRODUCT_ID);

        assertEquals(NO_CONTENT, responseEntityLocal.getStatusCodeValue());
    }
}