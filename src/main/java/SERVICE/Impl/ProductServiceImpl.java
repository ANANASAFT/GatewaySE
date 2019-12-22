package SERVICE.Impl;

import DAO.ProductDao;
import POJO.Product;
import org.springframework.stereotype.Service;
import java.util.List;

import SERVICE.ProductService;

/**
 * @author: Toon
 * @create: 2019-12-20 19:54
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProductsByBrand(String brand){
        return ProductDao.getProductListByBrand(brand);
    }
    @Override
    public List<Product> getAllProducts(){ return ProductDao.getAllProducts();}
}
