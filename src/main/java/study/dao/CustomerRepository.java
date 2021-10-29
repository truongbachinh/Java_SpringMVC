package study.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import study.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
