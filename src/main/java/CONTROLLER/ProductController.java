package CONTROLLER;

import POJO.Product;
import POJO.GatewayParameters;
import SERVICE.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Boolean test(@RequestBody GatewayParameters GP){
        if(GP != null) {
            System.out.println(GP.getIndustrial_grade());
            System.out.println(GP.getCurrent());
            System.out.println(GP.getTemperatureLow());
            System.out.println(GP.getTemperatureHigh());
            return true;
        }
        return false;
    }
}
