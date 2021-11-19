package info.product.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.product.productmanagement.model.SalesModel;

@Repository
public interface SalesRepository extends JpaRepository<SalesModel, Integer> {

}
