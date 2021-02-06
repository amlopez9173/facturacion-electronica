package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.SaleProductException;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.SaleProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para realizar las operaciones de las ventas producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Service
public class SaleProductService {
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";
    private SaleProductRepository saleProductRepository;

    public SaleProductService(SaleProductRepository saleProductRepository) {
        this.saleProductRepository = saleProductRepository;
    }

    /**
     * Permite guardar una venta producto
     * @param saleProduct Corresponde al objeto venta producto con todos sus atributos
     * @return Venta Producto creada en la base de datos
     */
    public SaleProduct save(SaleProduct saleProduct){
        return saleProductRepository.save(saleProduct);
    }

    /**
     * Permite eliminar una venta producto de la base de datos
     * @param saleProductId Corresponde al id de la venta producto a eliminar
     */
    public void delete(int saleProductId){
        Optional<SaleProduct> saleProduct = saleProductRepository.findById(saleProductId);
        if(saleProduct.isPresent()){
            saleProductRepository.delete(saleProductId);
        }else{
            throw new SaleProductException(ID_NO_ENCONTRADO);
        }
    }
}
