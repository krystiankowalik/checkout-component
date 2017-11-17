package com.github.krystiankowalik.controller;

import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.service.item.ItemService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> allItems = itemService.getAll();
        if (allItems.isEmpty()) {
            return new ResponseEntity<>(allItems, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allItems, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> getItem(@PathVariable long id) {
        Item item = itemService.get(id);
        if (item == null) {
            return new ResponseEntity<>(item, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Item> addItem(@RequestBody Item item) throws DataIntegrityViolationException {
        Item addedItem = itemService.save(item);
        if (addedItem == null) {
            return new ResponseEntity<>(addedItem, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(addedItem, HttpStatus.CREATED);

        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable long id) {
        if (!itemService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            itemService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleNonUniqueBarCodes(DataIntegrityViolationException e) {
        return new ResponseEntity<>("Data integrity violation: " +
                System.lineSeparator() + ExceptionUtils.getRootCause(e).getMessage(), HttpStatus.BAD_REQUEST);
    }

}
