package scubes.phonesAndAccessories.asset.goodReceivedNote.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phonesAndAccessories.asset.goodReceivedNote.entity.GoodReceivedNote;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;

@Repository
public interface GoodReceivedNoteDao extends JpaRepository< GoodReceivedNote, Integer> {
    GoodReceivedNote findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
