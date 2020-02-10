package aoharkov.training.repairagency.repository.connector;

import java.sql.Connection;

public interface Connector {

    Connection getConnection();
}
