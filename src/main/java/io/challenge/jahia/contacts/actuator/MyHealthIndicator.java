package io.challenge.jahia.contacts.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

  @Override
  public Health health() {
    int errorCode = check(); // perform some specific health check
    if (errorCode != 0) {
      return Health.down().withDetail("Error Code", errorCode).build();
    }
    return Health.up().build();
  }

  private int check() {
//        Here I would check database connection or some other
//        constraints that makes this api considered health
    return 0;
  }
}
