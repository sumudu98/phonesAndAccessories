

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentDao extends JpaRepository<lk.scubes.phonesAndAccessories.asset.payment.entity.Payment,Integer> {
    List<lk.scubes.phonesAndAccessories.asset.payment.entity.Payment> findByPurchaseOrder(PurchaseOrder purchaseOrder);

    lk.scubes.phonesAndAccessories.asset.payment.entity.Payment findFirstByOrderByIdDesc();
}
