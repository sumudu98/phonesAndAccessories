package scubes.phones_and_accessories.asset.invoice_item.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phones_and_accessories.asset.common_asset.model.enums.LiveDead;
import scubes.phones_and_accessories.asset.invoice.entity.Invoice;
import scubes.phones_and_accessories.asset.ledger.entity.Ledger;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("InvoiceLedger")
public class InvoiceLedger extends AuditEntity {

    @Column(nullable = false)
    private String quantity;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal sellPrice;

    @Enumerated( EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne
    private Ledger ledger;

    @ManyToOne
    private Invoice invoice;

}
