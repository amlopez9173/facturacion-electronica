package co.edu.cotecnova.facturacionelectronica.dominio.modelo;

import java.time.LocalDateTime;

/**
 * Clase para crear un producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
public class Product {
    private int productId;
    private int code;
    private String name;
    private double price;
    private boolean active;
    private LocalDateTime creationDate;

    public Product() {
    }

    public Product(int productId, int code, String name, double price, boolean active, LocalDateTime creationDate) {
        this.productId = productId;
        this.code = code;
        this.name = name;
        this.price = price;
        this.active = active;
        this.creationDate = creationDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
