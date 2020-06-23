package SERVICE;

import POJO.Gateway;
import POJO.Product;

import java.util.List;
import java.util.Map;

/**
 * @author: Toon
 * @create: 2019-12-20 19:34
 **/
public interface ProductService {
    List<Product> getProductsByBrand(String brand);
    List<Product> getAllProducts();

    List<Gateway> getNeededGateway(Map M);
    List<Gateway> getNeededGateway();
}
