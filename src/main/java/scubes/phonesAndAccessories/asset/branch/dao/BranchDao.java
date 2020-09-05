package scubes.phonesAndAccessories.asset.branch.dao;


import scubes.phonesAndAccessories.asset.branch.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BranchDao extends JpaRepository< Branch, Integer> {
}