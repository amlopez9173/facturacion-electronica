package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.SaleProductRepository;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud.VentaProductoCrudRepositorio;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.VentaProducto;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper.SaleProductMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio que implementa todas las operaciones en base de datos para las ventas productos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Repository
public class VentaProductoRepository implements SaleProductRepository {

    private VentaProductoCrudRepositorio ventaProductoCrudRepositorio;
    private SaleProductMapper saleProductMapper;

    public VentaProductoRepository(VentaProductoCrudRepositorio ventaProductoCrudRepositorio, SaleProductMapper saleProductMapper) {
        this.ventaProductoCrudRepositorio = ventaProductoCrudRepositorio;
        this.saleProductMapper = saleProductMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleProduct save(SaleProduct saleProduct) {
        VentaProducto ventaProducto = saleProductMapper.toVentaProducto(saleProduct);
        return saleProductMapper.toSaleProduct(ventaProductoCrudRepositorio.save(ventaProducto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int saleProductId) {
        ventaProductoCrudRepositorio.deleteById(saleProductId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<SaleProduct> findById(int saleProductId) {
        Optional<VentaProducto> ventaProducto = ventaProductoCrudRepositorio.findById(saleProductId);
        return ventaProducto.map(saleProduct -> saleProductMapper.toSaleProduct(saleProduct));
    }
}
