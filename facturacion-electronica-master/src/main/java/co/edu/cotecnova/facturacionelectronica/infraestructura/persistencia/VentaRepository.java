package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.SaleRepository;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud.VentaCrudRepositorio;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Venta;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper.SaleMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio que implementa todas las operaciones en base de datos para las ventas
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Repository
public class VentaRepository implements SaleRepository {

    private VentaCrudRepositorio ventaCrudRepositorio;
    private SaleMapper saleMapper;

    public VentaRepository(VentaCrudRepositorio ventaCrudRepositorio, SaleMapper saleMapper) {
        this.ventaCrudRepositorio = ventaCrudRepositorio;
        this.saleMapper = saleMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sale> getAll() {
        List<Venta> ventas = (List<Venta>) ventaCrudRepositorio.findAll();
        return saleMapper.toSales(ventas);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Sale> findById(int saleId) {
        Optional<Venta> venta = ventaCrudRepositorio.findById(saleId);
        return venta.map(sale -> saleMapper.toSale(sale));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sale save(Sale sale) {
        Venta venta = saleMapper.toVenta(sale);
        return saleMapper.toSale(ventaCrudRepositorio.save(venta));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sale update(Sale sale) {
        Venta venta = saleMapper.toVenta(sale);
        return saleMapper.toSale(ventaCrudRepositorio.save(venta));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int saleId) {
        ventaCrudRepositorio.deleteById(saleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Sale> findAll(Pageable pageable) {
        return ventaCrudRepositorio.findAll(pageable).map(venta -> saleMapper.toSale(venta));
    }
}
