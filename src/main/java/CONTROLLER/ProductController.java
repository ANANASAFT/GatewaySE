package CONTROLLER;

import POJO.Product;
import SERVICE.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Toon
 * @create: 2019-12-20 19:56
 **/
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin
    @RequestMapping("/product/{brand}")
    public List<Product> getProductsByBrand(@PathVariable("brand") String brand){

        return productService.getProductsByBrand(brand);
    }
    @CrossOrigin
    @RequestMapping("/product/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
