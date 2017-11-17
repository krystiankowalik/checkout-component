package com.github.krystiankowalik.model.receipt;

import com.github.krystiankowalik.model.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "receipt_entries")
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Item item;

    private BigDecimal units;

    @ManyToOne
    private Receipt receipt;

}


