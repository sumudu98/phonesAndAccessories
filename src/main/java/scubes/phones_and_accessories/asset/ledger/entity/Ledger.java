package scubes.phones_and_accessories.asset.ledger.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import scubes.phones_and_accessories.asset.common_asset.model.enums.LiveDead;
import scubes.phones_and_accessories.asset.good_received_note.entity.GoodReceivedNote;
import scubes.phones_and_accessories.asset.invoice_item.entity.InvoiceLedger;
import scubes.phones_and_accessories.asset.item.entity.Item;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Ledger" )
public class Ledger extends AuditEntity {

    @NotEmpty
    private String quantity;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal sellPrice;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private LocalDate manufactureDate;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private LocalDate expiredDate;

    @Enumerated( EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne(fetch=FetchType.EAGER)
    private Item item;

    @ManyToOne
    @JsonIgnore
    private GoodReceivedNote goodReceivedNote;


    @OneToMany(mappedBy = "ledger")
    private List< InvoiceLedger > invoiceLedgers;


}
