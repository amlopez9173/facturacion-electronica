package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-27T19:07:28-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getId() != null ) {
            product.setProductId( producto.getId() );
        }
        if ( producto.getCodigo() != null ) {
            product.setCode( producto.getCodigo() );
        }
        product.setName( producto.getNombre() );
        if ( producto.getPrecio() != null ) {
            product.setPrice( producto.getPrecio() );
        }
        if ( producto.getEstado() != null ) {
            product.setActive( producto.getEstado() );
        }
        product.setCreationDate( producto.getFechaCreacion() );

        return product;
    }

    @Override
    public List<Product> toProducts(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProduct( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( product.getProductId() );
        producto.setCodigo( product.getCode() );
        producto.setNombre( product.getName() );
        producto.setPrecio( product.getPrice() );
        producto.setEstado( product.isActive() );
        producto.setFechaCreacion( product.getCreationDate() );

        return producto;
    }
}
