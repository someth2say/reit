package com.someth2say.reit;

import java.util.Collections;
import java.util.Map;

import org.testcontainers.containers.PostgreSQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class PostgresResource implements
        QuarkusTestResourceLifecycleManager {

  static PostgreSQLContainer<?> db =
      new PostgreSQLContainer<>("postgres:13") 
        .withDatabaseName("reit")
        .withUsername("quarkus_test")
        .withPassword("quarkus_test");

  @Override
  public Map<String, String> start() { 
    db.start();
    
    return Collections.singletonMap(
        "quarkus.datasource.reactive.url", "postgresql://" + db.getContainerIpAddress() + ":" + db.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT)
        + "/" + db.getDatabaseName()
    );
  }

  @Override
  public void stop() { 
    db.stop();
  }
}