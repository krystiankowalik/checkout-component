package com.github.krystiankowalik.controller;

import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.model.receipt.Receipt;
import com.github.krystiankowalik.service.item.ItemService;
import com.github.krystiankowalik.service.receipt.ReceiptEntryService;
import com.github.krystiankowalik.service.receipt.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/receipts")
@AllArgsConstructor
public class ReceiptController {

    private final ItemService itemService;
    private final ReceiptEntryService receiptEntryService;
    private final ReceiptService receiptService;

    @PostMapping("/")
    public ResponseEntity<Long> openNewReceipt() {
        Receipt receipt = receiptService.openNewReceipt();
        return receipt != null ?
                new ResponseEntity<>(receipt.getId(), HttpStatus.CREATED) :
                new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getReceipt(@PathVariable(name = "id") long id) {
        Receipt receipt = receiptService.get(id);
        return receipt != null ?
                new ResponseEntity<>(receipt, HttpStatus.OK) :
                new ResponseEntity<>(receipt, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<Receipt> addItemToReceipt(@PathVariable(name = "id") long receiptId, @RequestBody Item item){
        Item savedItem = itemService.saveIfAbsent(item);
        receiptEntryService.addItemToReceiptEntry(savedItem, receiptService.get(receiptId));
        return new ResponseEntity<>(receiptService.get(receiptId), HttpStatus.OK);
    }

    @GetMapping("/{id}/totalPrice")
    public ResponseEntity<BigDecimal> getTotalPrice(@PathVariable(name = "id") long receiptId) {
        return new ResponseEntity<>(receiptService.getTotalPrice(receiptId), HttpStatus.OK);
    }

}
