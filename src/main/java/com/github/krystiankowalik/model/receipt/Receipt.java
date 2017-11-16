package com.github.krystiankowalik.model.receipt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "receipts")
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @Setter(onMethod = @_(@JsonManagedReference("receipt_receiptEntries")))
    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<ReceiptEntry> receiptEntries;

    @Transient
    private BigDecimal totalPrice;


}
