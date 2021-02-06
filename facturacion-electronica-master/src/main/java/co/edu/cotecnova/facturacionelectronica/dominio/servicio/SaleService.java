package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.SaleException;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para realizar las operaciones de las ventas
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Service
public class SaleService {
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";
    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    /**
     * Permite retornar un listado de ventas existentes en la base de datos
     * @return Listado de ventas de la base de datos
     */
    public List<Sale> getAll(){
        return saleRepository.getAll();
    }

    /**
     * Permite buscar una venta enviando su id como parametro
     * @param saleId Corresponde al id de la venta
     * @return Venta encontrada en la base de datos
     */
    public Optional<Sale> findById(int saleId){
        Optional<Sale> sale = saleRepository.findById(saleId);
        if(sale.isPresent()){
            return sale;
        }else{
            throw new SaleException(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite guardar una venta
     * @param sale Corresponde al objeto venta con todos sus atributos
     * @return Venta creada en la base de datos
     */
    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }

    /**
     * Permite actualizar una venta de la base de datos
     * @param sale Corresponde al objeto venta con los datos a actualizar en la base de datos
     * @param saleId Corresponde al id de la venta a actualizar
     * @return Venta actualizado
     */
    public Sale update(Sale sale, int saleId){
        Optional<Sale> result = saleRepository.findById(saleId);
        if(result.isPresent()) {
            return saleRepository.update(sale);
        }else{
            throw new SaleException(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite eliminar una venta de la base de datos
     * @param saleId Corresponde al id de la venta a eliminar
     */
    public void delete(int saleId){
        Optional<Sale> sale = saleRepository.findById(saleId);
        if(sale.isPresent()) {
            saleRepository.delete(saleId);
        }else{
            throw new SaleException(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite obtener el listado de ventas de la base de datos de forma pagina
     * @param pageable Corresponde al objeto que contiene el atributo page y size
     * @return Objeto tipo Page con el listado de ventas de la base de datos
     */
    public Page<Sale> findAll(Pageable pageable){
        return saleRepository.findAll(pageable);
    }
}
