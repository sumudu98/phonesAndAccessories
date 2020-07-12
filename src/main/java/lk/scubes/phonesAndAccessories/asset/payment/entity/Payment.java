package lk.scubes.phonesAndAccessories.asset.payment.entity;

import com.fasterxml.jackson.annotation.JsonFilter;


import lk.scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;
import lk.scubes.phonesAndAccessories.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Payment")
public class Payment extends AuditEntity {
    private String bankName;

    private String remarks;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @ManyToOne
    private PurchaseOrder purchaseOrder;
}
