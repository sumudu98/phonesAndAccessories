package scubes.phonesAndAccessories.asset.discountRatio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phonesAndAccessories.asset.discountRatio.entity.DiscountRatio;

@Repository
public interface DiscountRatioDao extends JpaRepository< DiscountRatio, Integer > {
}
