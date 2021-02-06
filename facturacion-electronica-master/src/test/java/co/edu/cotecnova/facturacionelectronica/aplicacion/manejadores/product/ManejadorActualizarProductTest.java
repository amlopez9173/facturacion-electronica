package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaProduct;
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

import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.*;
import static co.edu.cotecnova.facturacionelectronica.utils.ProductUtils.CREATION_DATE;
import static org.junit.jupiter.api.Assertions.*;

class ManejadorActualizarProductTest {

    Product product = new ProductTestDataBuilder().build();
    ComandoProduct comandoProduct = new ProductTestDataBuilder().buildComando();

    @Mock
    private ProductService productService;

    @Mock
    private FabricaProduct fabricaProduct;

    @InjectMocks
    private ManejadorActualizarProduct manejadorActualizarProduct;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ejecutarTest() {
        Mockito.when(fabricaProduct.crear(comandoProduct)).thenReturn(product);
        Mockito.when(productService.update(product, ProductUtils.PRODUCT_ID)).thenReturn(product);

        Product productLocal = manejadorActualizarProduct.ejecutar(comandoProduct, ProductUtils.PRODUCT_ID);

        assertEquals(PRODUCT_ID, productLocal.getProductId());
        assertEquals(CODE, productLocal.getCode());
        assertEquals(NAME, productLocal.getName());
        assertEquals(PRICE, productLocal.getPrice());
        assertEquals(ACTIVE, productLocal.isActive());
        assertEquals(CREATION_DATE, productLocal.getCreationDate());
    }
}