package com.github.krystiankowalik.service.receipt;

import com.github.krystiankowalik.dao.ReceiptCustomDao;
import com.github.krystiankowalik.model.receipt.Receipt;
import com.github.krystiankowalik.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class ReceiptService extends BaseService<Receipt> {

    private ReceiptCustomDao receiptCustomDao;

    @Autowired
    public ReceiptService(JpaRepository<Receipt, Long> dao, ReceiptCustomDao receiptCustomDao) {
        super(dao);
        this.receiptCustomDao = receiptCustomDao;
    }

    public BigDecimal getTotalPrice(long id) {
        return receiptCustomDao.getTotalPrice(id);
    }
}
