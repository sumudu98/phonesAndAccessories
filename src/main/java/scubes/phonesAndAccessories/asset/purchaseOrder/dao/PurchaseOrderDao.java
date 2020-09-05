package scubes.phonesAndAccessories.asset.purchaseOrder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.Enum.PurchaseOrderStatus;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;
import scubes.phonesAndAccessories.asset.supplier.entity.Supplier;

import java.util.List;

@Repository
public interface PurchaseOrderDao extends JpaRepository< PurchaseOrder, Integer> {

    List<PurchaseOrder> findByPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus);

    List<PurchaseOrder> findByPurchaseOrderStatusAndSupplier(PurchaseOrderStatus purchaseOrderStatus, Supplier supplier);


    PurchaseOrder findFirstByOrderByIdDesc();
}
