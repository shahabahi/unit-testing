package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.controller.Item;
import com.in28minutes.unittesting.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    private final ItemRepository itemRepository;

    public ItemBusinessService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> retrieveAllItem() {
        List<Item> items =itemRepository.findAll();
        for (Item item:items){
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }

    public Item retrieveHardcodedItem() {
        return new Item(1, "Shahab", 100, 1000);
    }
}
