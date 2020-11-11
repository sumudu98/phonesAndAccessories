package scubes.phonesAndAccessories.asset.customer.dao;


import scubes.phonesAndAccessories.asset.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository< Customer, Integer> {

    Customer findFirstByOrderByIdDesc();
}
