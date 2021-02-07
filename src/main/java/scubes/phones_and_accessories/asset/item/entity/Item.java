package scubes.phones_and_accessories.asset.item.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phones_and_accessories.asset.brand.entity.Brand;
import scubes.phones_and_accessories.asset.category.entity.Category;
import scubes.phones_and_accessories.asset.color.entity.ItemColor;
import scubes.phones_and_accessories.asset.common_asset.model.enums.LiveDead;
import scubes.phones_and_accessories.asset.item.entity.enums.ItemStatus;
import scubes.phones_and_accessories.asset.item.entity.enums.WarrantyPeriod;
import scubes.phones_and_accessories.asset.ledger.entity.Ledger;
import scubes.phones_and_accessories.asset.purchase_order_item.entity.PurchaseOrderItem;
import scubes.phones_and_accessories.asset.supplier_item.entity.SupplierItem;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.*;
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

  @Size( min = 2, message = "Your name can not be accepted" )
  private String name;

  private String rop;

  @Column( unique = true )
  private String code;

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal sellPrice;

  @Enumerated( EnumType.STRING )
  private ItemStatus itemStatus;

  @Enumerated( EnumType.STRING )
  private WarrantyPeriod warrantyPeriod;

  @ManyToOne( fetch = FetchType.EAGER )
  private Category category;

  @ManyToOne( fetch = FetchType.EAGER )
  private Brand brand;

  @ManyToOne( fetch = FetchType.EAGER )
  private ItemColor itemColor;

  @Enumerated( EnumType.STRING)
  private LiveDead liveDead;


  @OneToMany( mappedBy = "item" )
  private List< SupplierItem > supplierItems;

  @OneToMany( mappedBy = "item" )
  @JsonBackReference
  private List< Ledger > ledgers;

  @OneToMany( mappedBy = "item" )
  private List< PurchaseOrderItem > purchaseOrderItems;
}
