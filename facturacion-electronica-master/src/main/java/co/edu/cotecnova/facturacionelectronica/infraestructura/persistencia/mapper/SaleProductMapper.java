package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.VentaProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Interface que permite mapear una VentaProducto a un SaleProduct y viceversa
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "saleProductId"),
            @Mapping(source = "productoId", target = "productId"),
            @Mapping(source = "ventaId", target = "saleId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "producto", target = "product")
    })
    SaleProduct toSaleProduct(VentaProducto ventaProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "venta", ignore = true),
    })
    VentaProducto toVentaProducto(SaleProduct saleProduct);
}
