package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.databuilder.ProductTestDataBuilder;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import co.edu.cotecnova.facturacionelectronica.utils.ProductUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.*;
import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.CREATION_DATE;
import static org.junit.jupiter.api.Assertions.*;

class ManejadorListarPorIdProductTest {

    private Product product = new ProductTestDataBuilder().build();

    @Mock
    private ProductService productService;

    @InjectMocks
    private ManejadorListarPorIdProduct manejadorListarPorIdProduct;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ejecutar() {
        Mockito.when(productService.findById(ProductUtils.PRODUCT_ID)).thenReturn(Optional.of(product));

        Optional<Product> productLocal = manejadorListarPorIdProduct.ejecutar(ProductUtils.PRODUCT_ID);

        assertEquals(PRODUCT_ID, productLocal.get().getProductId());
        assertEquals(CODE, productLocal.get().getCode());
        assertEquals(NAME, productLocal.get().getName());
        assertEquals(PRICE, productLocal.get().getPrice());
        assertEquals(ACTIVE, productLocal.get().isActive());
        assertEquals(CREATION_DATE, productLocal.get().getCreationDate());
    }
}