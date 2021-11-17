package info.product.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.product.productmanagement.model.ProductModel;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

}
