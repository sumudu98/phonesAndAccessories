package lk.scubes_phone_and_accessories.asset.supplier.dao;

import lk.scubes_phone_and_accessories.asset.supplier.entity.Supplier;
import lk.scubes_phone_and_accessories.asset.supplier_item.entity.enums.ItemSupplierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
    Supplier findFirstByOrderByIdDesc();

    Supplier findByIdAndItemSupplierStatus(Integer supplierId, ItemSupplierStatus itemSupplierStatus);
}
