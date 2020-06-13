package lk.scubes.phonesAndAccessories.asset.supplier.dao;


import lk.scubes.phonesAndAccessories.asset.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
    Supplier findFirstByOrderByIdDesc();
}
