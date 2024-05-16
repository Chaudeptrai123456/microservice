package com.example.serverUser.Service.Product;

import com.example.serverUser.DTO.CategoryDto;
import com.example.serverUser.DTO.FeatureDto;
import com.example.serverUser.DTO.ProductDTO;
import com.example.serverUser.Entity.*;
import com.example.serverUser.Repostitory.*;
import com.example.serverUser.Service.Elasticsearch.ElasticsearchServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private FeatureValueRepository featureValueRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private Product_InventoryRepository productInventoryRepository;
    @Autowired
    private ElasticsearchServiceImplement elasticsearchServiceImplement;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> findAllProduct(String name) {
        List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setNameProduct(productDTO.getNameProduct());
        newProduct.setCost(productDTO.getCost());
        productRepository.save(newProduct);
        Product_Inventory product_inventory = new Product_Inventory();
        product_inventory.setProduct(newProduct);
        product_inventory.setQuanlity(productDTO.getQuantity());
        product_inventory.setPrice(productDTO.getPrice());
        product_inventory.setDateCreate(new Date());
        product_inventory.setDateUpdate(new Date());
        Inventory inventory = inventoryRepository.findInventorybyId(productDTO.getInventoryID());
        System.out.println(inventory.getNameInventory());
        Set<Feature> feature1 = this.featureRepository.findProductFeature("color desktop 222asdsasdsad2");
        newProduct.setListFeature(feature1);
        product_inventory.setInventory(inventory);
        addFeature(productDTO.getFeatureList(),newProduct);
        productInventoryRepository.save(product_inventory);
        this.elasticsearchServiceImplement.create(productDTO.getFeatureList(),newProduct);
        return newProduct;
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) throws Exception {
        try {
            Product newProduct =  productRepository.findProductByName(productDTO.getNameProduct());
            newProduct.setNameProduct(productDTO.getNameProduct());
            newProduct.setCost(productDTO.getCost());
            productRepository.save(newProduct);
            Product_Inventory product_inventory = this.productInventoryRepository.findByInventorynameandProductname(1L,newProduct.getProductID());
            product_inventory.setPrice(productDTO.getPrice());
            product_inventory.setQuanlity(productDTO.getQuantity());
            this.productInventoryRepository.save(product_inventory);
            this.elasticsearchServiceImplement.update(productDTO);
            return newProduct;
        }catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
    private void addFeature(List<FeatureDto> list,Product product){
        Feature feature = new Feature();
        feature.setFeature("Test1");
        feature.setNameFeature("Test feature 1");
        feature.setProduct(product);
        this.featureRepository.save(feature);
        for (FeatureDto index: list) {
            FeatureValue featureValue = new FeatureValue();
            featureValue.setAttribute(index.getAttribute());
            featureValue.setName(index.getName());
            featureValue.setValue(index.getValue());
            featureValue.setFeature(feature);
            this.featureValueRepository.save(featureValue);
        }
    }
    public List<Product_Inventory> getAllPIP() {
        List<Product_Inventory> list = this.productInventoryRepository.findAll();
        return list;
    }
    @Override
    public Product addFeatureToProduct(List<Feature> list) {
        return null;
    }

    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setType(categoryDto.getType());
        category.setName(categoryDto.getName());
        this.categoryRepository.save(category);
        return category;
    }

}
