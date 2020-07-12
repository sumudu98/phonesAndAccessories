package lk.scubes.phonesAndAccessories.asset.invoice.dao;

import lk.scubes.phonesAndAccessories.asset.invoice.entity.DiscountRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRatioDao extends JpaRepository<DiscountRatio, Integer> {
}
