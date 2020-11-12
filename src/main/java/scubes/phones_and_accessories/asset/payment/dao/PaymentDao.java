package scubes.phones_and_accessories.asset.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import scubes.phones_and_accessories.asset.payment.entity.Payment;
import scubes.phones_and_accessories.asset.purchase_order.entity.PurchaseOrder;

import java.util.List;

public interface PaymentDao extends JpaRepository< Payment,Integer> {
    List< Payment> findByPurchaseOrder(PurchaseOrder purchaseOrder);

    Payment findFirstByOrderByIdDesc();
}
