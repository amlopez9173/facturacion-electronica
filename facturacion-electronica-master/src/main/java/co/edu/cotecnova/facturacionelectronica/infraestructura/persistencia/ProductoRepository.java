package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ProductRepository;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud.ProductoCrudRepositorio;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Producto;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio que implementa todas las operaciones en base de datos para los productos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepositorio productoCrudRepositorio;
    private ProductMapper productMapper;

    public ProductoRepository(ProductoCrudRepositorio productoCrudRepositorio, ProductMapper productMapper){
        this.productoCrudRepositorio = productoCrudRepositorio;
        this.productMapper = productMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepositorio.findByEstadoTrue();
        return productMapper.toProducts(productos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Product> findById(int productId) {
        Optional<Producto> producto = productoCrudRepositorio.findById(productId);
        return producto.map(prod -> productMapper.toProduct(prod));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepositorio.save(producto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int productId) {
        productoCrudRepositorio.deleteById(productId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product update(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepositorio.save(producto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Product> findByCode(int code) {
        Optional<Producto> producto = productoCrudRepositorio.findByCodigo(code);
        return producto.map(prod -> productMapper.toProduct(prod));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productoCrudRepositorio.findAll(pageable).map(producto -> productMapper.toProduct(producto));
    }
}
