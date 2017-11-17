package com.github.krystiankowalik.service.item;

import com.github.krystiankowalik.dao.ItemDao;
import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional

public class ItemService extends BaseServiceImpl<Item> {


    private ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao dao) {

        super(dao);
        this.itemDao = dao;
    }

    public BigDecimal getPriceByBarCode(long barCode) {
        return itemDao.getByBarCode(barCode).getRegularPrice();
    }

    public Item getItemByBarCode(long barCode) {
        return itemDao.getByBarCode(barCode);
    }

    public Item saveIfAbsent(Item item) {
        if (get(item.getId()) == null) {
            item = save(item);
        }
        return item;
    }

}
