package co.edu.cotecnova.facturacionelectronica.dominio.modelo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase para crear una venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public class Sale {
    private int saleId;
    private int clientId;
    private boolean active;
    private double purchaseValue;
    private LocalDateTime creationDate;
    private Client client;
    private List<SaleProduct> saleProducts;

    public Sale() {
    }

    public Sale(int saleId, int clientId, boolean active, double purchaseValue, LocalDateTime creationDate, Client client, List<SaleProduct> saleProducts) {
        this.saleId = saleId;
        this.clientId = clientId;
        this.active = active;
        this.purchaseValue = purchaseValue;
        this.creationDate = creationDate;
        this.client = client;
        this.saleProducts = saleProducts;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SaleProduct> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(List<SaleProduct> saleProducts) {
        this.saleProducts = saleProducts;
    }
}
