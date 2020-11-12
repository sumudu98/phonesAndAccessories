package scubes.phonesAndAccessories.asset.item.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phonesAndAccessories.asset.brand.entity.Brand;
import scubes.phonesAndAccessories.asset.category.entity.Category;
import scubes.phonesAndAccessories.asset.color.entity.ItemColor;
import scubes.phonesAndAccessories.asset.item.entity.Enum.ItemStatus;
import scubes.phonesAndAccessories.asset.ledger.entity.Ledger;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrderItem;
import scubes.phonesAndAccessories.asset.supplierItem.entity.SupplierItem;
import scubes.phonesAndAccessories.util.audit.AuditEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Item" )
public class Item extends AuditEntity {

    @Size( min = 5, message = "Your name can not be accepted" )
    private String name;

    @NotEmpty
    private String rop;

    @Column( unique = true )
    private String code;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal sellPrice;

    @Enumerated( EnumType.STRING )
    private ItemStatus itemStatus;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ItemColor itemColor;

    @OneToMany( mappedBy = "item" )
    private List< SupplierItem > supplierItems;

    @OneToMany( mappedBy = "item" )
    @JsonBackReference
    private List< Ledger > ledgers;

    @OneToMany( mappedBy = "item" )
    private List< PurchaseOrderItem > purchaseOrderItems;
}
