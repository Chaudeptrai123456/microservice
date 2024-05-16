package com.example.serverUser.DTO.KafkaEvent;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class InventoryEvent {
    private Integer id;
    private InventoryEventType inventoryEventType;
    private Product product;

    public InventoryEvent(Integer id, InventoryEventType inventoryEventType, Product product) {
        this.id = id;
        this.inventoryEventType = inventoryEventType;
        this.product = product;
    }

    public Integer getInventoryId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InventoryEventType getInventoryEventType() {
        return inventoryEventType;
    }

    public void setInventoryEventType(InventoryEventType inventoryEventType) {
        this.inventoryEventType = inventoryEventType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
