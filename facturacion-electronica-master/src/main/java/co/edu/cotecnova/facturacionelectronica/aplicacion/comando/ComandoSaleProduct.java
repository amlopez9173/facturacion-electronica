package co.edu.cotecnova.facturacionelectronica.aplicacion.comando;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;

/**
 * Clase para crear venta producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public class ComandoSaleProduct {
    private int saleProductId;
    private int productId;
    private int saleId;
    private int quantity;
    private Product product;

    public ComandoSaleProduct() {
    }

    public ComandoSaleProduct(int saleProductId, int productId, int saleId, int quantity, Product product) {
        this.saleProductId = saleProductId;
        this.productId = productId;
        this.saleId = saleId;
        this.quantity = quantity;
        this.product = product;
    }

    public int getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(int saleProductId) {
        this.saleProductId = saleProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
