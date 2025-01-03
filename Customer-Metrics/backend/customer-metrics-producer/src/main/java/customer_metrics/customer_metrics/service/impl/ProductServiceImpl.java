package customer_metrics.customer_metrics.service.impl;

import customer_metrics.customer_metrics.entity.Product;
import customer_metrics.customer_metrics.repository.ProductRepository;
import customer_metrics.customer_metrics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "product-topic";
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String productId) {
        kafkaTemplate.send(TOPIC, "User 1234 asked for "+productId);
        return productRepository.findByProductId(productId);
    }
}
