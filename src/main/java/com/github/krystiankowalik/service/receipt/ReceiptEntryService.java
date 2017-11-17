package com.github.krystiankowalik.service.receipt;

import com.github.krystiankowalik.dao.ReceiptEntryDao;
import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.model.receipt.Receipt;
import com.github.krystiankowalik.model.receipt.ReceiptEntry;
import com.github.krystiankowalik.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@Service
public class ReceiptEntryService extends BaseServiceImpl<ReceiptEntry> {

    private ReceiptEntryDao receiptEntryDao;

    @Autowired
    public ReceiptEntryService(ReceiptEntryDao dao, ReceiptEntryDao receiptEntryDao) {
        super(dao);
        this.receiptEntryDao = receiptEntryDao;
    }

    public ReceiptEntry addItemToReceiptEntry(final Item item, final Receipt receipt) {
        ReceiptEntry receiptEntry = receiptEntryDao.findByReceiptId(receipt.getId());
        if (receiptEntry != null) {
            receiptEntry.incrementUnits();
        } else {
            receiptEntry = new ReceiptEntry(0, item, BigDecimal.ONE, receipt);
        }
        receiptEntry = save(receiptEntry);

        return receiptEntry;
    }


}
