package study.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import study.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
