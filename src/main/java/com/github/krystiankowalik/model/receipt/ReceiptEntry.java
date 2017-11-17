package com.github.krystiankowalik.model.receipt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.krystiankowalik.model.item.Item;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "receipt_entries")
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @OneToOne
    private Item item;

    private BigDecimal units;

    @JsonIgnore
    //@Setter(onMethod = @_(@JsonBackReference("receipt_receiptEnries")))
    @ManyToOne
    private Receipt receipt;

    public void incrementUnits() {
        units = units.add(BigDecimal.ONE);
    }

}


