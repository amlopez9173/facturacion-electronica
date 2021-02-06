package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import co.edu.cotecnova.facturacionelectronica.utils.ProductUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorEliminarProductTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ManejadorEliminarProduct manejadorEliminarProduct;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ejecutarTest() {
        Mockito.doNothing().when(productService).delete(ProductUtils.PRODUCT_ID);
        manejadorEliminarProduct.ejecutar(ProductUtils.PRODUCT_ID);

        Mockito.verify(productService, Mockito.times(1)).delete(ProductUtils.PRODUCT_ID);
    }
}