package scubes.phonesAndAccessories.asset.purchaseOrder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phonesAndAccessories.asset.item.entity.Item;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrderItem;

import java.util.List;

@Repository
public interface PurchaseOrderItemDao extends JpaRepository< PurchaseOrderItem, Integer> {
    PurchaseOrderItem findByPurchaseOrderAndItem(PurchaseOrder purchaseOrder, Item item);
    List<PurchaseOrderItem> findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
