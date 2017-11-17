package com.github.krystiankowalik.dao;

import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.model.receipt.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Repository
public interface ReceiptDao extends JpaRepository<Receipt, Long> {

}
