package customer_metrics.customer_metrics.repository;

import customer_metrics.customer_metrics.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAll();
    Product findByProductId(String productId);
}
