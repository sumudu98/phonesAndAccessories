package scubes.phonesAndAccessories.asset.color.dao;

import scubes.phonesAndAccessories.asset.color.entity.ItemColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemColorDao extends JpaRepository< ItemColor, Integer >{

}