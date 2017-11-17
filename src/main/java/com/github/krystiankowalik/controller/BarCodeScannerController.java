package com.github.krystiankowalik.controller;

import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barCodeScanner")
public class BarCodeScannerController {

    private ItemService itemService;

    @Autowired
    public BarCodeScannerController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<Item> scanBarCode(long barCode) {
        return new ResponseEntity<>(itemService.getItemByBarCode(barCode), HttpStatus.OK);

    }


}
