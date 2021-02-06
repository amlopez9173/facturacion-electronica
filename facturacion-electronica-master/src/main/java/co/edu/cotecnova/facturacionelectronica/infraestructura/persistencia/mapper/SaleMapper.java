package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Cliente;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Venta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Interface que permite mapear una Venta a un Sale y viceversa
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Mapper(componentModel = "spring", uses = {ClientMapper.class, SaleProductMapper.class})
public interface SaleMapper {
    @Mappings({
            @Mapping(source = "id", target = "saleId"),
            @Mapping(source = "clienteId", target = "clientId"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "valorCompra", target = "purchaseValue"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
            @Mapping(source = "cliente", target = "client"),
            @Mapping(source = "ventaProductos", target = "saleProducts"),
    })
    Sale toSale(Venta venta);
    List<Sale> toSales(List<Venta> ventas);

    @InheritInverseConfiguration
    Venta toVenta(Sale sale);
}
