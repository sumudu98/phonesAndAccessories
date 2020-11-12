package scubes.phones_and_accessories.asset.discount_ratio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phones_and_accessories.asset.discount_ratio.entity.DiscountRatio;

@Repository
public interface DiscountRatioDao extends JpaRepository< DiscountRatio, Integer > {
}
