package lk.scubes.phonesAndAccessories.asset.item.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.scubes.phonesAndAccessories.asset.brand.entity.Brand;
import lk.scubes.phonesAndAccessories.asset.color.entity.ItemColor;
import lk.scubes.phonesAndAccessories.asset.category.entity.Category;
import lk.scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrderItem;
import lk.scubes.phonesAndAccessories.asset.supplier.entity.SupplierItem;
import lk.scubes.phonesAndAccessories.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Item")
public class Item extends AuditEntity {

    @Size(min = 2, message = "Your name cannot be accepted")
    private String name;

    private Integer rop;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private ItemColor itemColor;



    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    @OneToMany(mappedBy = "item")
    private List<PurchaseOrderItem> purchaseOrderItems;



    @OneToMany(mappedBy = "item")
    private List<SupplierItem> supplierItems;
}
