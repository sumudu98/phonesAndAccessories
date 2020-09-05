package scubes.phonesAndAccessories.asset.supplier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phonesAndAccessories.asset.supplier.entity.Supplier;
import scubes.phonesAndAccessories.asset.supplierItem.entity.Enum.ItemSupplierStatus;

@Repository
public interface SupplierDao extends JpaRepository< Supplier, Integer> {
    Supplier findFirstByOrderByIdDesc();

    Supplier findByIdAndItemSupplierStatus(Integer supplierId, ItemSupplierStatus itemSupplierStatus);
}
