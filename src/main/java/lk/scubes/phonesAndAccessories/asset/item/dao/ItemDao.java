package lk.scubes.phonesAndAccessories.asset.item.dao;


import lk.scubes.phonesAndAccessories.asset.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
    Item findFirstByOrderByIdDesc();
}
