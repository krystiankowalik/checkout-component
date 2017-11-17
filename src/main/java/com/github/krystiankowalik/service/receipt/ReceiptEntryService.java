package com.github.krystiankowalik.service.receipt;

import com.github.krystiankowalik.model.receipt.ReceiptEntry;
import com.github.krystiankowalik.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ReceiptEntryService extends BaseService<ReceiptEntry> {

    public ReceiptEntryService(JpaRepository<ReceiptEntry, Long> dao) {
        super(dao);
    }
}
