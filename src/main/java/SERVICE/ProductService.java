package SERVICE;

import POJO.Product;

import java.util.List;

/**
 * @author: Toon
 * @create: 2019-12-20 19:34
 **/
public interface ProductService {
    List<Product> getProductsByBrand(String brand);
    List<Product> getAllProducts();
}
