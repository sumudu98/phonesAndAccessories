package lk.scubes.phonesAndAccessories.asset.invoice.dao;


import lk.scubes.phonesAndAccessories.asset.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {
}
