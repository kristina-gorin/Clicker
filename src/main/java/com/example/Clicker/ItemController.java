package com.example.Clicker;

import java.lang.Iterable;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping()
    public Iterable<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable("id") Integer id) {
        return this.itemRepository.findById(id);
    }


    @PostMapping()
    public Item addItem(@RequestBody Item item) {
        return this.itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public Item deleteItem(@PathVariable("id") Integer id) {
        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            return null;
        }
        Item item = itemOptional.get();
        this.itemRepository.delete((item));
        return item;
    }

    @PutMapping("/{id}/title")
    public Item updateTitle(@PathVariable("id") Integer id, @RequestBody Item updatedItem) {
        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            return null;
        }
        Item item = itemOptional.get();
        item.setTitle(updatedItem.getTitle());
        return this.itemRepository.save(item);

    }

    @PutMapping("/{id}/notes")
    public Item updateNotes(@PathVariable("id") Integer id, @RequestBody Item updatedItem) {
        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            return null;
        }
        Item item = itemOptional.get();
        item.setNotes(updatedItem.getNotes());
        return this.itemRepository.save(item);

    }

    @PutMapping("/{id}/count/increase")
    public Item increaseCount(@PathVariable("id") Integer id) {
        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            return null;
        }
        Item item = itemOptional.get();
        item.setCount(item.getCount() + 1);
        this.itemRepository.save(item);
        return item;
    }

    @PutMapping("/{id}/count/decrease")
    public Item decreaseCount(@PathVariable("id") Integer id) {
        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            return null;
        }
        Item item = itemOptional.get();
        if (item.getCount() > 0) {
            item.setCount(item.getCount() - 1);
        }
        return this.itemRepository.save(item);
    }
}



