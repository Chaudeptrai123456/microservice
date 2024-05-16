package com.example.serverUser.Service;

import com.example.serverUser.Entity.Feature;
import com.example.serverUser.Entity.Inventory;
import com.example.serverUser.Entity.Product;
import com.example.serverUser.Entity.Product_Inventory;
import com.example.serverUser.Repostitory.FeatureRepository;
import com.example.serverUser.Repostitory.InventoryRepository;
import com.example.serverUser.Repostitory.ProductRepository;
import com.example.serverUser.Repostitory.Product_InventoryRepository;
import com.example.serverUser.Service.FindProduct.FindProductImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private Product_InventoryRepository productInventoryRepository;

    @Autowired
    private FindProductImplement findProductImplement;
    public List<Product_Inventory> test() {
        try {
        Product newProduct = new Product();
        newProduct.setCost(121231.1D);
        newProduct.setNameProduct("product_test_slave 5123a@sdas2");
        Inventory inventory = new Inventory();
        inventory.setNameInventory("inventory qwewq");
        inventory.setAddress("ho chi minh vietnam");

        Feature newFeature = new Feature();
        newFeature.setFeature("light red 12asdadasd@sa1");
        newFeature.setNameFeature("color desktop 222asdsasdsad2");

        Feature newFeature1 = new Feature();
        newFeature1.setFeature("light pink 12asdadasd@sa1");
        newFeature1.setNameFeature("color desktop 222asdsasdsad2");
        Feature newFeature2 = new Feature();
        newFeature2.setFeature("light blue 12asdadasd@sa1");
        newFeature2.setNameFeature("color desktop 222asdsasdsad2");

        featureRepository.save(newFeature);
        Product_Inventory pi = new Product_Inventory();
        pi.setProduct(newProduct);
        pi.setQuanlity(10);
        pi.setInventory(inventory);
        pi.setDateCreate(new Date());
        pi.setDateUpdate(new Date());
        Set<Product_Inventory> test = new HashSet<>();
        test.add(pi);
        newProduct.setListInventory(test);
        featureRepository.save(newFeature);
            featureRepository.save(newFeature1);
            featureRepository.save(newFeature2);

        Set<Feature> test1 = new HashSet<>();
        test1.add(newFeature);
        test1.add(newFeature1);
        test1.add(newFeature2);
        newProduct.setListFeature(test1);
        inventoryRepository.save(inventory);
        productRepository.save(newProduct);
        productInventoryRepository.save(pi);

        List<Product> p = productRepository.findAll();
        List<Inventory> a = inventoryRepository.findAll();
        List<Product_Inventory> list =productInventoryRepository.findAll();
        return productInventoryRepository.findAllPI();
        } catch(Exception ex)
        {
            throw  ex;
        }
    }

    public List<Product_Inventory> testNginx(){
        return productInventoryRepository.findAll();
    }



}
