package scubes.phones_and_accessories.asset.customer.service;


import scubes.phones_and_accessories.asset.common_asset.model.enums.LiveDead;
import scubes.phones_and_accessories.asset.customer.dao.CustomerDao;
import scubes.phones_and_accessories.asset.customer.entity.Customer;
import scubes.phones_and_accessories.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "customer" )
public class CustomerService implements AbstractService<Customer, Integer> {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public Customer findById(Integer id) {
        return customerDao.getOne(id);
    }

    public Customer persist(Customer customer) {
        if ( customer.getId() == null ) {
            customer.setLiveDead(LiveDead.ACTIVE);
        }
        return customerDao.save(customer);
    }

    public boolean delete(Integer id) {
        Customer customer = customerDao.getOne(id);
        customer.setLiveDead(LiveDead.STOP);
        customerDao.save(customer);
        return false;
    }

    public List<Customer> search(Customer customer) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Customer> customerExample = Example.of(customer, matcher);
        return customerDao.findAll(customerExample);
    }

    public Customer lastCustomer(){
        return customerDao.findFirstByOrderByIdDesc();
    }
}
