package scubes.phones_and_accessories.asset.good_received_note.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phones_and_accessories.asset.common_asset.model.enums.LiveDead;
import scubes.phones_and_accessories.asset.good_received_note.entity.enums.GoodReceivedNoteState;
import scubes.phones_and_accessories.asset.ledger.entity.Ledger;
import scubes.phones_and_accessories.asset.purchase_order.entity.PurchaseOrder;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("GoodReceivedNote")
public class GoodReceivedNote extends AuditEntity {
    private String remarks;

    @Column( precision = 10, scale = 2 )
    private BigDecimal totalAmount;

    @Enumerated( EnumType.STRING )
    private GoodReceivedNoteState goodReceivedNoteState;

    @Enumerated(EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @OneToMany( mappedBy = "goodReceivedNote", cascade = CascadeType.PERSIST)
    private List< Ledger > ledgers;


}
