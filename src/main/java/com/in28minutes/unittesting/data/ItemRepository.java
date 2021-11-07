package com.in28minutes.unittesting.data;

import com.in28minutes.unittesting.controller.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
