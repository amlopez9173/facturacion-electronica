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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorPaginarProductTest {

    private Product product = new ProductTestDataBuilder().build();
    private List<Product> productList = new ArrayList<>();

    private Pageable pageable;
    private Page<Product> productPage = new PageImpl<>(productList);

    @Mock
    private ProductService productService;

    @InjectMocks
    private ManejadorPaginarProduct manejadorPaginarProduct;

    @BeforeEach
    public void init(){
        productList.add(product);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ejecutarTest() {
        Mockito.when(productService.findAll(pageable)).thenReturn(productPage);

        Page<Product> productPageLocal = manejadorPaginarProduct.ejecutar(pageable);

        assertEquals(productPage.getTotalElements(), productPageLocal.getTotalElements());
    }
}