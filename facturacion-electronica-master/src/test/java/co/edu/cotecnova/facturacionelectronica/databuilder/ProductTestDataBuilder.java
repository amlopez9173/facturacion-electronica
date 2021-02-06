package co.edu.cotecnova.facturacionelectronica.databuilder;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;

import java.time.LocalDateTime;

public class ProductTestDataBuilder {
    private static final int PRODUCT_ID = 1;
    private static final int CODE = 9090;
    private static final String NAME = "producto";
    private static final double PRICE = 2500;
    private static final boolean ACTIVE = true;
    private static final LocalDateTime CREATION_DATE = LocalDateTime.of(2021, 01,22,21,05);

    private int productId;
    private int code;
    private String name;
    private double price;
    private boolean active;
    private LocalDateTime creationDate;

    public ProductTestDataBuilder(){
        this.productId = PRODUCT_ID;
        this.code = CODE;
        this.name = NAME;
        this.price = PRICE;
        this.active = ACTIVE;
        this.creationDate = CREATION_DATE;
    }

    public ProductTestDataBuilder conActive(boolean active){
        this.active = active;
        return this;
    }

    public ProductTestDataBuilder conCode(int code){
        this.code = code;
        return this;
    }

    public ProductTestDataBuilder conProductId(int productId){
        this.productId = productId;
        return this;
    }

    public ProductTestDataBuilder conName(String name){
        this.name = name;
        return this;
    }

    public Product build(){
        return new Product(this.productId, this.code, this.name, this.price, this.active, this.creationDate);
    }

    public ComandoProduct buildComando(){
        return new ComandoProduct(this.productId, this.code, this.name, this.price, this.active, this.creationDate);
    }
}
