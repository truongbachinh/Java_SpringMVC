package study.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.dao.CustomerRepository;
import study.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired(required = false)
    CustomerRepository repo;

    public void save(Customer customer) {
        repo.save(customer);
    }

    public List<Customer> listAll() {

        return (List<Customer>) repo.findAll();
    }

    public Customer get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
