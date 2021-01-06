package lk.scubes.phonesAndAccessories.asset.good_received_note.dao;


import lk.scubes.phonesAndAccessories.asset.good_received_note.entity.GoodReceivedNote;
import lk.scubes.phonesAndAccessories.asset.purchase_order_item.entity.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodReceivedNoteDao extends JpaRepository<GoodReceivedNote, Integer> {
  GoodReceivedNote findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
