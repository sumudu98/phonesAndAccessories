package scubes.phones_and_accessories.asset.purchase_order.dao;


import scubes.phones_and_accessories.asset.purchase_order.entity.enums.PurchaseOrderStatus;
import scubes.phones_and_accessories.asset.purchase_order.entity.PurchaseOrder;
import scubes.phones_and_accessories.asset.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderDao extends JpaRepository< PurchaseOrder, Integer> {

    List<PurchaseOrder> findByPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus);

    List<PurchaseOrder> findByPurchaseOrderStatusAndSupplier(PurchaseOrderStatus purchaseOrderStatus, Supplier supplier);


    PurchaseOrder findFirstByOrderByIdDesc();
}
