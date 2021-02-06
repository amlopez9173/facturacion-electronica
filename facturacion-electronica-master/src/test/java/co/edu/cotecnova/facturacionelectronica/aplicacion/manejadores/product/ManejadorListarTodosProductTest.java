package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.databuilder.ProductTestDataBuilder;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.*;
import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.CREATION_DATE;
import static org.junit.jupiter.api.Assertions.*;

class ManejadorListarTodosProductTest {

    private Product product = new ProductTestDataBuilder().build();
    private List<Product> productList = new ArrayList<>();

    @Mock
    private ProductService productService;

    @InjectMocks
    private ManejadorListarTodosProduct manejadorListarTodosProduct;

    @BeforeEach
    public void init(){
        productList.add(product);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ejecutarTest() {
        Mockito.when(productService.getAll()).thenReturn(productList);

        List<Product> productListLocal = manejadorListarTodosProduct.ejecutar();

        assertEquals(PRODUCT_ID, productListLocal.get(0).getProductId());
        assertEquals(CODE, productListLocal.get(0).getCode());
        assertEquals(NAME, productListLocal.get(0).getName());
        assertEquals(PRICE, productListLocal.get(0).getPrice());
        assertEquals(ACTIVE, productListLocal.get(0).isActive());
        assertEquals(CREATION_DATE, productListLocal.get(0).getCreationDate());
    }
}