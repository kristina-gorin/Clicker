package com.example.Clicker;

import org.springframework.data.repository.CrudRepository;

import com.example.Clicker.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}