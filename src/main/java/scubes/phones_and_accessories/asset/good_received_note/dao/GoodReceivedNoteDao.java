package scubes.phones_and_accessories.asset.good_received_note.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phones_and_accessories.asset.good_received_note.entity.GoodReceivedNote;
import scubes.phones_and_accessories.asset.purchase_order.entity.PurchaseOrder;

@Repository
public interface GoodReceivedNoteDao extends JpaRepository< GoodReceivedNote, Integer> {
    GoodReceivedNote findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
