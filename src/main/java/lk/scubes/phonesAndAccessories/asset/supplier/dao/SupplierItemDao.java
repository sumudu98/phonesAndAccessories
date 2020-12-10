package lk.scubes.phonesAndAccessories.asset.supplier.dao;


import lk.scubes.phonesAndAccessories.asset.item.entity.Item;
import lk.scubes.phonesAndAccessories.asset.supplier.entity.Enum.ItemSupplierStatus;
import lk.scubes.phonesAndAccessories.asset.supplier.entity.Supplier;
import lk.scubes.phonesAndAccessories.asset.supplier.entity.SupplierItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierItemDao extends JpaRepository<SupplierItem, Integer> {
    SupplierItem findBySupplierAndItem(Supplier supplier, Item item);

    List<SupplierItem> findBySupplier(Supplier supplier);

    List<SupplierItem> findBySupplierAndItemSupplierStatus(Supplier supplier, ItemSupplierStatus itemSupplierStatus);
}
