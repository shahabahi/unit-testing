package com.in28minutes.unittesting.controller;

import com.in28minutes.unittesting.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Shahab", 100, 1000);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return businessService.retrieveHardcodedItem();
    }
    @GetMapping("/all-items-from-db")
    public List<Item> retrieveAllItem(){
        return businessService.retrieveAllItem();
    }
}
