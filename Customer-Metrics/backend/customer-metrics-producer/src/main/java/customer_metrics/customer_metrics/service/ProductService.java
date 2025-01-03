package customer_metrics.customer_metrics.service;

import customer_metrics.customer_metrics.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(String productId);
}
