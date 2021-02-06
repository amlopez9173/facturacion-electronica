package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.databuilder.ProductTestDataBuilder;
import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ProductExcepcion;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ProductRepository;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private List<Product> productList = new ArrayList<>();
    private Product product = new ProductTestDataBuilder().build();

    private Page<Product> productPage;
    private Pageable pageable;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        productList.add(product);
        productPage = new PageImpl<>(productList);
    }

    @Test
    void getAllTest() {
        //ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(productRepository.getAll()).thenReturn(productList);
        //ProductService productService = new ProductService(productRepository);

        List<Product> productListLocal = productService.getAll();

        assertEquals(PRODUCT_ID, productListLocal.get(0).getProductId());
        assertEquals(CODE, productListLocal.get(0).getCode());
        assertEquals(NAME, productListLocal.get(0).getName());
        assertEquals(PRICE, productListLocal.get(0).getPrice());
        assertEquals(ACTIVE, productListLocal.get(0).isActive());
        assertEquals(CREATION_DATE, productListLocal.get(0).getCreationDate());
    }

    @Test
    void findByIdTest() {
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(java.util.Optional.ofNullable(product));

        Optional<Product> productLocal = productService.findById(PRODUCT_ID);

        assertEquals(PRODUCT_ID, productLocal.get().getProductId());
        assertEquals(CODE, productLocal.get().getCode());
        assertEquals(NAME, productLocal.get().getName());
        assertEquals(PRICE, productLocal.get().getPrice());
        assertEquals(ACTIVE, productLocal.get().isActive());
        assertEquals(CREATION_DATE, productLocal.get().getCreationDate());
    }

    @Test
    void findByIdExceptionTest() {
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.empty());
        assertThrows(ProductExcepcion.class, () -> productService.findById(PRODUCT_ID));
    }

    @Test
    void saveTest() {
        Mockito.when(productRepository.findByCode(CODE)).thenReturn(Optional.empty());
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product productLocal = productService.save(product);

        assertEquals(PRODUCT_ID, productLocal.getProductId());
        assertEquals(CODE, productLocal.getCode());
        assertEquals(NAME, productLocal.getName());
        assertEquals(PRICE, productLocal.getPrice());
        assertEquals(ACTIVE, productLocal.isActive());
        assertEquals(CREATION_DATE, productLocal.getCreationDate());
    }

    @Test
    void saveExceptionTest() {
        Mockito.when(productRepository.findByCode(CODE)).thenReturn(Optional.of(product));

        assertThrows(ProductExcepcion.class, () -> productService.save(product));
    }

    @Test
    void deleteTest(){
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        productService.delete(PRODUCT_ID);
        Mockito.verify(productRepository, Mockito.times(1)).delete(PRODUCT_ID);
    }

    @Test
    void deleteExceptionTest(){
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.empty());

        assertThrows(ProductExcepcion.class, () -> productService.delete(PRODUCT_ID));
    }

    @Test
    void updateTest(){
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.update(product)).thenReturn(product);

        Product productLocal = productService.update(product, PRODUCT_ID);

        assertEquals(PRODUCT_ID, productLocal.getProductId());
        assertEquals(CODE, productLocal.getCode());
        assertEquals(NAME, productLocal.getName());
        assertEquals(PRICE, productLocal.getPrice());
        assertEquals(ACTIVE, productLocal.isActive());
        assertEquals(CREATION_DATE, productLocal.getCreationDate());
    }

    @Test
    void updateExceptionTest(){
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.empty());

        assertThrows(ProductExcepcion.class, () -> productService.update(product, PRODUCT_ID));
    }

    @Test
    void findAll(){
        Mockito.when(productRepository.findAll(pageable)).thenReturn(productPage);

        Page<Product> productPageLocal = productService.findAll(pageable);

        assertEquals(productPage.getTotalElements(), productPageLocal.getTotalElements());
    }
}