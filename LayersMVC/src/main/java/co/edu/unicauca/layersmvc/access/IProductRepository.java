package co.edu.unicauca.layersmvc.access;

import co.edu.unicauca.layersmvc.domain.Product;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface IProductRepository {

    boolean save(Product newProduct);

    boolean update(Product newProduct);
    
    Product find(int id);
    
    boolean delete(int id);

    List<Product> list();
}
