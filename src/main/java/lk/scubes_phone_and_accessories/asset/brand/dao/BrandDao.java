package lk.scubes_phone_and_accessories.asset.brand.dao;

import lk.scubes_phone_and_accessories.asset.brand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {
}
