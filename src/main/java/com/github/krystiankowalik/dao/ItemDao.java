package com.github.krystiankowalik.dao;

import com.github.krystiankowalik.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {

    Item getByBarCode(long barCode);

}
