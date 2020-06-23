package CONTROLLER;

import POJO.Gateway;
import POJO.GatewayWorkingEnv;
import POJO.Product;
import POJO.GatewayWorkingEnv;
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
    @RequestMapping("/gateway/industrialGrade")
    public List<Gateway> getNeededGateway(){
        return productService.getNeededGateway();
    }

    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Boolean test(@RequestBody Map M){
        if(M != null) {
            Map sensorParameters = (Map) M.get("sensorParameters");
            Map sensorWorkingEnv = (Map) M.get("sensorWorkingEnv");
            Map gatewayWorkingEnv = (Map) M.get("gatewayWorkingEnv");
            List<Gateway> list=productService.getNeededGateway(gatewayWorkingEnv);
            System.out.println(list);
            return true;
        }
        return false;
    }
}
