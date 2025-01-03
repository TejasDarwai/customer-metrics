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
@Table(name = "user_table")
public class User {
    @Id
    String id;
    String name;
    String emailId;
    String password;
}
