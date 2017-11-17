package com.github.krystiankowalik.controller;

import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.model.receipt.Receipt;
import com.github.krystiankowalik.model.receipt.ReceiptEntry;
import com.github.krystiankowalik.service.item.ItemService;
import com.github.krystiankowalik.service.receipt.ReceiptEntryService;
import com.github.krystiankowalik.service.receipt.ReceiptService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
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
        return new ResponseEntity<>(receiptService.openNewReceipt().getId(), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<Receipt> addItemToReceipt(@PathVariable(name = "id") long receiptId, @RequestBody Item item) throws DataIntegrityViolationException {
        Item savedItem = itemService.saveIfAbsent(item);
        receiptEntryService.addItemToReceiptEntry(savedItem, receiptService.get(receiptId));
        return new ResponseEntity<>(receiptService.get(receiptId), HttpStatus.OK);
    }

    @PostMapping("/{id}/receiptEntries")
    public ResponseEntity<Receipt> addReceiptEntryToReceipt(@PathVariable(name = "id") long receiptId, @RequestBody ReceiptEntry receiptEntry) throws DataIntegrityViolationException {
        Item savedItem = itemService.saveIfAbsent(receiptEntry.getItem());
        receiptEntry.setReceipt(receiptService.get(receiptId));
        receiptEntryService.save(receiptEntry);
        return new ResponseEntity<>(receiptService.get(receiptId), HttpStatus.OK);
    }

    @PutMapping("{id}/receiptEntries")
    public ResponseEntity<Receipt> dupa() {
        throw new NotImplementedException();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> dupa2() {
        throw new NotImplementedException();
    }

    public ResponseEntity<Receipt> getReceipt(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(receiptService.get(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/totalPrice")
    public ResponseEntity<BigDecimal> getTotalPrice(@PathVariable(name = "id") long receiptId) {
        return new ResponseEntity<>(receiptService.getTotalPrice(receiptId), HttpStatus.OK);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleNonUniqueBarCodes(DataIntegrityViolationException e) {
        return new ResponseEntity<>("Data integrity violation: " +
                System.lineSeparator() + ExceptionUtils.getRootCause(e).getMessage(), HttpStatus.BAD_REQUEST);
    }

}
