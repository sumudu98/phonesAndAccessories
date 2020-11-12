package scubes.phones_and_accessories.asset.supplier_item.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phones_and_accessories.asset.item.entity.Item;
import scubes.phones_and_accessories.asset.supplier.entity.Supplier;
import scubes.phones_and_accessories.asset.supplier_item.entity.Enum.ItemSupplierStatus;
import scubes.phones_and_accessories.asset.supplier_item.entity.SupplierItem;

import java.util.List;

@Repository
public interface SupplierItemDao extends JpaRepository< SupplierItem, Integer> {
    SupplierItem findBySupplierAndItem(Supplier supplier, Item item);

    List<SupplierItem> findBySupplier(Supplier supplier);

    List<SupplierItem> findBySupplierAndItemSupplierStatus(Supplier supplier, ItemSupplierStatus itemSupplierStatus);

    List<SupplierItem> findByItem(Item item);

    Item findByItemAndSupplier(Item item, Supplier supplier);

    SupplierItem findBySupplierAndItemAndItemSupplierStatus(Supplier supplier, Item item, ItemSupplierStatus itemSupplierStatus);
}
