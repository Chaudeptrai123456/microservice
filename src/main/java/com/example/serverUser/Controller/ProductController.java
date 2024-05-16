package com.example.serverUser.Controller;

import com.example.serverUser.DTO.CategoryDto;
import com.example.serverUser.DTO.FeatureDto;
import com.example.serverUser.DTO.ProductDTO;
import com.example.serverUser.Entity.Category;
import com.example.serverUser.Entity.Product;
import com.example.serverUser.Service.AdminService;
import com.example.serverUser.Service.Inventory.InventoryServiceImplement;
import com.example.serverUser.Service.Product.ProductServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductServiceImplement productServiceImplement;
    @Autowired
    private InventoryServiceImplement inventoryServiceImplement;
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<Product> creatNewProduct(ProductDTO productDTO) {
        ProductDTO productDTO1  = new ProductDTO();
        productDTO1.setNameProduct("test17");
        productDTO1.setPrice(12.3);
        productDTO1.setCost(15.0);
        productDTO1.setQuantity(12);
        productDTO1.setInventoryID(1L);
        List<FeatureDto> featureDtos = new ArrayList<>();
        FeatureDto featureDto = new FeatureDto();
        featureDto.setName("test");
        featureDto.setValue("red");
        featureDto.setAttribute("color");
        FeatureDto featureDto1 = new FeatureDto();
        featureDto1.setName("test1");
        featureDto1.setValue("blue");
        featureDto1.setAttribute("color");
        featureDtos.add(featureDto1);
        featureDtos.add(featureDto);
        productDTO1.setFeatureList(featureDtos);
        Product body = this.productServiceImplement.createProduct(productDTO1);
        return new ResponseEntity<Product>(body,HttpStatusCode.valueOf(200));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity<Product> updateProduct(ProductDTO productDTO) throws Exception {
        System.out.println(productDTO.toString());
        Product res = this.productServiceImplement.updateProduct(productDTO);
        return new ResponseEntity<>(res,HttpStatusCode.valueOf(200));
    }
    @RequestMapping(value="/getAll",method= RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> list = this.productServiceImplement.findAllProduct("test");
        return new ResponseEntity<List<Product>>(list, HttpStatusCode.valueOf(200));
    }
    @RequestMapping(value="/category/create",method = RequestMethod.GET)
    public ResponseEntity<Category> creatCategory(){
        Category category = this.productServiceImplement.createCategory(new CategoryDto("test barnd","sport"));
        return new ResponseEntity<Category>(category,HttpStatusCode.valueOf(200));
    }
}
