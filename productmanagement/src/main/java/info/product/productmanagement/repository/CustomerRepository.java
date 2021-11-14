package info.product.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.product.productmanagement.model.CustomerModel;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

}
