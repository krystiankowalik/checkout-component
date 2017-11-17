package com.github.krystiankowalik.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
public class ReceiptCustomDao {

    private EntityManager entityManager;

    @Autowired
    public ReceiptCustomDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BigDecimal getTotalPrice(long receiptId) {
        return (BigDecimal) entityManager.createNativeQuery(
                "SELECT sum(i.regularprice * re.units)\n" +
                        " FROM receipt_entries re\n" +
                        " JOIN items i ON re.item_id = i.id\n" +
                        " JOIN receipts r ON re.receipt_id = r.id\n" +
                        " WHERE r.id=1\n" +
                        " AND\n" +
                        "      re.units < i.minunitstoapplydiscount").getSingleResult();
    }
}
