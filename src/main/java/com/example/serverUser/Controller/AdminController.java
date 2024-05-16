package com.example.serverUser.Controller;

import com.example.serverUser.DTO.KafkaEvent.InventoryEvent;
import com.example.serverUser.DTO.KafkaEvent.InventoryEventType;
import com.example.serverUser.DTO.KafkaEvent.Product;
import com.example.serverUser.Entity.Product_Inventory;
import com.example.serverUser.Service.AdminService;
import com.example.serverUser.Service.Inventory.InventoryServiceImplement;
import com.example.serverUser.Service.Kafka.KafkaConsumerService;
import com.example.serverUser.Service.Kafka.KafkaProducerService;
import com.example.serverUser.Service.Product.ProductServiceImplement;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")

public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductServiceImplement productServiceImplement;
    @Autowired
    private InventoryServiceImplement inventoryServiceImplement;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @Autowired
    private KafkaConsumerService kafkaConsumerService;
    @GetMapping("/test")
    public ResponseEntity<List<Product_Inventory>> test() {
        List<Product_Inventory> q =  adminService.test();
        return new ResponseEntity<List<Product_Inventory>>(q, HttpStatus.ACCEPTED);
    }
    @GetMapping("/kafka")
    public ResponseEntity<Object> testKafka() throws JsonProcessingException {
        Product newProduct = new Product("test3");
        newProduct.setProductId(12L);
        newProduct.setPrice(45.5D);
        var result =  kafkaProducerService.sendInventoryEvent_Async(new InventoryEvent(1, InventoryEventType.NEW,newProduct));
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getTask")
    public ResponseEntity<Object> getTask(){
        return new ResponseEntity<>("task",HttpStatusCode.valueOf(200));
    }


}
