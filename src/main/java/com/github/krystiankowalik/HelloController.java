package com.github.krystiankowalik;

import com.github.krystiankowalik.dao.ReceiptCustomDao;
import com.github.krystiankowalik.dao.ReceiptDao;
import com.github.krystiankowalik.dao.ReceiptEntryDao;
import com.github.krystiankowalik.model.dao.ItemDao;
import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.model.receipt.Receipt;
import com.github.krystiankowalik.model.receipt.ReceiptEntry;
import com.github.krystiankowalik.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RestControllerAdvice
public class HelloController {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ReceiptDao receiptDao;
    @Autowired
    private ReceiptEntryDao receiptEntryDao;
    @Autowired
    private ReceiptCustomDao receiptCustomDao;

    @Autowired
    private ItemService itemService;

    @GetMapping("/hello")
    public String index() {
        Item item1 = new Item(0, "dupa", 16515432, new BigDecimal(25), new BigDecimal(30), new BigDecimal(20));
        Item item2 = new Item(0, "dupa2", 1651561, new BigDecimal(35), new BigDecimal(36), new BigDecimal(22));
        Item item3 = new Item(0, "dupa3", 1652344, new BigDecimal(45), new BigDecimal(15), new BigDecimal(25));
        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);

        ReceiptEntry receiptEntry1 = new ReceiptEntry(0, item1, new BigDecimal(23), null);
        ReceiptEntry receiptEntry2 = new ReceiptEntry(0, item2, new BigDecimal(23), null);
        ReceiptEntry receiptEntry3 = new ReceiptEntry(0, item3, new BigDecimal(23), null);

        receiptEntryDao.save(receiptEntry1);
        receiptEntryDao.save(receiptEntry2);
        receiptEntryDao.save(receiptEntry3);

        Receipt receipt = new Receipt(0, null, null);

        List<ReceiptEntry> receiptEntries = receiptEntryDao.findAll();
        receiptEntries.forEach(e -> e.setReceipt(receipt));
        receipt.setReceiptEntries(receiptEntries);

        receiptDao.saveAndFlush(receipt);
        receiptEntries.forEach(e -> receiptEntryDao.saveAndFlush(e));

        return receiptCustomDao.getTotalPrice(1).toString();
//        return "hello";

    }

    @GetMapping("/showsum")
    public BigDecimal sum() {
        return receiptCustomDao.getTotalPrice(1);

    }

    @PostMapping("/postItem")
    public void post(@RequestBody Item item) {
        itemService.save(item);
    }


}