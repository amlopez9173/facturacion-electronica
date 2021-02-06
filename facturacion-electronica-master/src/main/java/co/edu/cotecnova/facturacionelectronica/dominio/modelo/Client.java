package co.edu.cotecnova.facturacionelectronica.dominio.modelo;

import java.time.LocalDateTime;

/**
 * Clase para crear un cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public class Client {
    private int clientId;
    private String document;
    private String name;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private boolean active;
    private LocalDateTime creationDate;

    public Client() {
    }

    public Client(int clientId, String document, String name, String lastname, String address, String email, String phone, boolean active, LocalDateTime creationDate) {
        this.clientId = clientId;
        this.document = document;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.creationDate = creationDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
