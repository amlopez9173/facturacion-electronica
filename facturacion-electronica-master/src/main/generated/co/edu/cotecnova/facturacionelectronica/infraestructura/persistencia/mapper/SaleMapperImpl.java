package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Venta;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.VentaProducto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-27T19:07:28-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private SaleProductMapper saleProductMapper;

    @Override
    public Sale toSale(Venta venta) {
        if ( venta == null ) {
            return null;
        }

        Sale sale = new Sale();

        if ( venta.getId() != null ) {
            sale.setSaleId( venta.getId() );
        }
        if ( venta.getClienteId() != null ) {
            sale.setClientId( venta.getClienteId() );
        }
        if ( venta.getEstado() != null ) {
            sale.setActive( venta.getEstado() );
        }
        if ( venta.getValorCompra() != null ) {
            sale.setPurchaseValue( venta.getValorCompra() );
        }
        sale.setCreationDate( venta.getFechaCreacion() );
        sale.setClient( clientMapper.toClient( venta.getCliente() ) );
        sale.setSaleProducts( ventaProductoListToSaleProductList( venta.getVentaProductos() ) );

        return sale;
    }

    @Override
    public List<Sale> toSales(List<Venta> ventas) {
        if ( ventas == null ) {
            return null;
        }

        List<Sale> list = new ArrayList<Sale>( ventas.size() );
        for ( Venta venta : ventas ) {
            list.add( toSale( venta ) );
        }

        return list;
    }

    @Override
    public Venta toVenta(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        Venta venta = new Venta();

        venta.setId( sale.getSaleId() );
        venta.setClienteId( sale.getClientId() );
        venta.setEstado( sale.isActive() );
        venta.setValorCompra( sale.getPurchaseValue() );
        venta.setFechaCreacion( sale.getCreationDate() );
        venta.setCliente( clientMapper.toCliente( sale.getClient() ) );
        venta.setVentaProductos( saleProductListToVentaProductoList( sale.getSaleProducts() ) );

        return venta;
    }

    protected List<SaleProduct> ventaProductoListToSaleProductList(List<VentaProducto> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleProduct> list1 = new ArrayList<SaleProduct>( list.size() );
        for ( VentaProducto ventaProducto : list ) {
            list1.add( saleProductMapper.toSaleProduct( ventaProducto ) );
        }

        return list1;
    }

    protected List<VentaProducto> saleProductListToVentaProductoList(List<SaleProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<VentaProducto> list1 = new ArrayList<VentaProducto>( list.size() );
        for ( SaleProduct saleProduct : list ) {
            list1.add( saleProductMapper.toVentaProducto( saleProduct ) );
        }

        return list1;
    }
}
