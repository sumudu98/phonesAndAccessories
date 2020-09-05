package scubes.phonesAndAccessories.asset.goodReceivedNote.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;
import scubes.phonesAndAccessories.asset.goodReceivedNote.entity.Enum.GoodReceivedNoteState;
import scubes.phonesAndAccessories.asset.ledger.entity.Ledger;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;
import scubes.phonesAndAccessories.util.audit.AuditEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "GoodReceivedNote" )
@ToString
public class GoodReceivedNote extends AuditEntity {

    private String remarks;

    @Column( precision = 10, scale = 2 )
    private BigDecimal totalAmount;

    @Enumerated( EnumType.STRING )
    private GoodReceivedNoteState goodReceivedNoteState;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @OneToMany( mappedBy = "goodReceivedNote", cascade = CascadeType.PERSIST)
    private List< Ledger > ledgers;


}
