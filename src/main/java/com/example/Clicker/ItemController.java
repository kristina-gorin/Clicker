package com.example.Clicker;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.Clicker.ItemRepository;
import com.example.Clicker.Item;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(final ItemRepository itemRepository) {
        this.itemRepository= itemRepository;
    }

    @GetMapping("/")
    public Iterable<Item> getAllItems() {
        return this.itemRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable("id") Integer id){
        return this.itemRepository.findById(id);
    }
//    @GetMapping("items/{title}")
//    public Optional<Item> getItemByTitle(@PathVariable("title")String title){
//        return this.itemRepo.findBy(title);
//
//    }
    @PostMapping("/")
    public Item addItem(@RequestBody Item item){
        Item newItem = this.itemRepository.save(item);
        return newItem;
    }
//    @DeleteMapping("/{id}")
//    public Boot deleteBoot(@PathVariable("id") Integer id){
//        Optional<Boot> bootToDeleteOptional = this.bootRepository.findById(id);
//        if(!bootToDeleteOptional.isPresent()){
//            return null;
//        }
//        Boot bootToDelete = bootToDeleteOptional.get();
//        this.bootRepository.delete(bootToDelete);
//        return bootToDelete;
//    }
}