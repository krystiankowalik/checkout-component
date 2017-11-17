package com.github.krystiankowalik.model.item;

import com.sun.istack.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "items")
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    private String name;

    @Column(unique = true)
    private long barCode;

    private BigDecimal regularPrice;
    /*
     * May be weight units!
     * */
    private BigDecimal minUnitsToApplyDiscount;
    private BigDecimal discountPrice;


}
