package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ProductExcepcion;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para realizar las operaciones de los productos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
@Service
public class ProductService {
    private ProductRepository productRepository;
    private final static String CODIGO_YA_EXISTE = "El codigo ya existe en la base de datos";
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /**
     * Permite retornar un listado de productos existentes en la base de datos
     * @return Listado de productos de la base de datos
     */
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    /**
     * Permite buscar un producto enviado su id como parametro
     * @param productId Corresponde al id del producto
     * @return Producto encontrado en la base de datos
     */
    public Optional<Product> findById(int productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            return product;
        }else{
            throw new ProductExcepcion(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite guardar un producto
     * @param product Corresponde al objeto producto con todos sus atributos
     * @return Producto creado en la base de datos
     */
    public Product save(Product product){
        Optional<Product> result = productRepository.findByCode(product.getCode());
        if(result.isPresent()){
            throw new ProductExcepcion(CODIGO_YA_EXISTE);
        }else{
            return productRepository.save(product);
        }
    }

    /**
     * Permite eliminar un producto de la base de datos
     * @param productId Corresponde al id del producto a eliminar
     */
    public void delete(int productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(productId);
        }else{
            throw new ProductExcepcion(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite actualizar un producto de la base de datos
     * @param product Corresponde al objeto producto con los datos a actualizar en la base de datos
     * @param productId Corresponde al id del producto a actualizar
     * @return Producto actualizado
     */
    public Product update(Product product, int productId){
        Optional<Product> result = productRepository.findById(productId);
        if(result.isPresent()){
            return productRepository.update(product);
        }else{
            throw new ProductExcepcion(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite obtener el listado de productos de la base de datos de forma pagina
     * @param pageable Corresponde al objeto que contiene el atributo page y size
     * @return Objeto tipo Page con el listado de productos de la base de datos
     */
    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }
}
