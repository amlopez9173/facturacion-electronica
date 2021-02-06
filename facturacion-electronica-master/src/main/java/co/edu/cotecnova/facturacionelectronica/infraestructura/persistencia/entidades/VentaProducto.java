package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades;

import javax.persistence.*;

/**
 * Entidad que mapea de la base de datos la tabla venta productos
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Entity
@Table(name = "venta_productos")
public class VentaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "venta_id")
    private Integer ventaId;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "venta_id", insertable = false, updatable = false)
    private Venta venta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
