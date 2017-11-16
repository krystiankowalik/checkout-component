package com.github.krystiankowalik.dao;

import com.github.krystiankowalik.model.receipt.ReceiptEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptEntryDao extends JpaRepository<ReceiptEntry, Long> {

    ReceiptEntry findByReceiptIdAndItemId(long receiptId,long itemId);

}
