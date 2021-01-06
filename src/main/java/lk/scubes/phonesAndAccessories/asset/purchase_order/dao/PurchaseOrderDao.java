


import lk.scubes.phonesAndAccessories.asset.purchase_order.entity.enums.PurchaseOrderStatus;
import lk.scubes.phonesAndAccessories.asset.purchase_order.entity.PurchaseOrder;
import lk.scubes.phonesAndAccessories.asset.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDao extends JpaRepository<lk.scubes.phonesAndAccessories.asset.purchase_order.entity.PurchaseOrder, Integer> {

    List<lk.scubes.phonesAndAccessories.asset.purchase_order.entity.PurchaseOrder> findByPurchaseOrderStatus(lk.scubes.phonesAndAccessories.asset.purchase_order.entity.enums.PurchaseOrderStatus purchaseOrderStatus);

    List<lk.scubes.phonesAndAccessories.asset.purchase_order.entity.PurchaseOrder> findByPurchaseOrderStatusAndSupplier(lk.scubes.phonesAndAccessories.asset.purchase_order.entity.enums.PurchaseOrderStatus purchaseOrderStatus, Supplier supplier);


    lk.scubes.phonesAndAccessories.asset.purchase_order.entity.PurchaseOrder findFirstByOrderByIdDesc();
}
