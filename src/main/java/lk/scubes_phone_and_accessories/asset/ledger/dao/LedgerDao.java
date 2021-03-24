package lk.scubes_phone_and_accessories.asset.ledger.dao;


import lk.scubes_phone_and_accessories.asset.item.entity.Item;
import lk.scubes_phone_and_accessories.asset.ledger.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LedgerDao extends JpaRepository< Ledger, Integer> {
    List<Ledger> findByItem(Item item);

    Ledger findByItemAndSellPrice(Item item, BigDecimal sellPrice);



    List< Ledger > findByCreatedAtBetween(LocalDateTime form, LocalDateTime to);

}
