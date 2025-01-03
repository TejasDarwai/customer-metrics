package customer_metrics.customer_metrics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "product_table")
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productCategoryId;
}
