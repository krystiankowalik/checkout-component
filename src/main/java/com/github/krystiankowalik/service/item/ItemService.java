package com.github.krystiankowalik.service.item;

import com.github.krystiankowalik.model.dao.ItemDao;
import com.github.krystiankowalik.model.item.Item;
import com.github.krystiankowalik.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemService extends BaseService<Item> {


    public ItemService(JpaRepository<Item, Long> dao) {
        super(dao);
    }


}
