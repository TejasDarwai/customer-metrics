package customer_metrics_consumer.customer_metrics_consumer.service;

import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
@Service
public class MetricsService {
    private final Counter userCreatedCounter;
    private final Counter userLoginCounter;

    public MetricsService(MeterRegistry registry) {
        this.userCreatedCounter = registry.counter("user.created.count");
        this.userLoginCounter = registry.counter("user.login.count");
    }

    public void incrementUserCreated() {
        userCreatedCounter.increment();
    }

    public void incrementUserLogin() {
        userLoginCounter.increment();
    }
}