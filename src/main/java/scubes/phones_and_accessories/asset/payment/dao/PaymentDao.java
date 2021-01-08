package scubes.phones_and_accessories.asset.payment.dao;


import scubes.phones_and_accessories.asset.purchase_order.entity.PurchaseOrder;
import scubes.phones_and_accessories.asset.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentDao extends JpaRepository< Payment,Integer> {
    List< Payment> findByPurchaseOrder(PurchaseOrder purchaseOrder);

    Payment findFirstByOrderByIdDesc();
}
