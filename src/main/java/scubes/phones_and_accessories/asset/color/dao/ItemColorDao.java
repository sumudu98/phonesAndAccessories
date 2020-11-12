package scubes.phones_and_accessories.asset.color.dao;

import scubes.phones_and_accessories.asset.color.entity.ItemColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemColorDao extends JpaRepository< ItemColor, Integer >{

}