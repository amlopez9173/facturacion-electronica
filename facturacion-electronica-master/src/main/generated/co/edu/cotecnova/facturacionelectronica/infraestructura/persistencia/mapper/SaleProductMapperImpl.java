package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.VentaProducto;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-27T19:07:28-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class SaleProductMapperImpl implements SaleProductMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public SaleProduct toSaleProduct(VentaProducto ventaProducto) {
        if ( ventaProducto == null ) {
            return null;
        }

        SaleProduct saleProduct = new SaleProduct();

        if ( ventaProducto.getId() != null ) {
            saleProduct.setSaleProductId( ventaProducto.getId() );
        }
        if ( ventaProducto.getProductoId() != null ) {
            saleProduct.setProductId( ventaProducto.getProductoId() );
        }
        if ( ventaProducto.getVentaId() != null ) {
            saleProduct.setSaleId( ventaProducto.getVentaId() );
        }
        if ( ventaProducto.getCantidad() != null ) {
            saleProduct.setQuantity( ventaProducto.getCantidad() );
        }
        saleProduct.setProduct( productMapper.toProduct( ventaProducto.getProducto() ) );

        return saleProduct;
    }

    @Override
    public VentaProducto toVentaProducto(SaleProduct saleProduct) {
        if ( saleProduct == null ) {
            return null;
        }

        VentaProducto ventaProducto = new VentaProducto();

        ventaProducto.setId( saleProduct.getSaleProductId() );
        ventaProducto.setProductoId( saleProduct.getProductId() );
        ventaProducto.setVentaId( saleProduct.getSaleId() );
        ventaProducto.setCantidad( saleProduct.getQuantity() );
        ventaProducto.setProducto( productMapper.toProducto( saleProduct.getProduct() ) );

        return ventaProducto;
    }
}
