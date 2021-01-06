

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderItemDao extends JpaRepository<lk.scubes.phonesAndAccessories.asset.purchase_order_item.entity.PurchaseOrderItem, Integer> {
    lk.scubes.phonesAndAccessories.asset.purchase_order_item.entity.PurchaseOrderItem findByPurchaseOrderAndItem(PurchaseOrder purchaseOrder, Item item);
    List<lk.scubes.phonesAndAccessories.asset.purchase_order_item.entity.PurchaseOrderItem> findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
