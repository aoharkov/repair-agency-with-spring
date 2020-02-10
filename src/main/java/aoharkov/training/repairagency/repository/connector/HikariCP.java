package aoharkov.training.repairagency.repository.connector;

import aoharkov.training.repairagency.repository.exception.DataBaseSqlRuntimeException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HikariCP implements Connector {
    private static final Logger LOGGER = LogManager.getLogger(HikariCP.class);
    private static final String NO_CONNECTION = "no connection";

    private final HikariDataSource dataSource;

    public HikariCP(String configFileName) {
        ResourceBundle resource = ResourceBundle.getBundle(configFileName);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(resource.getString("db.url"));
        config.setUsername(resource.getString("db.user"));
        config.setPassword(resource.getString("db.password"));
        config.setDriverClassName(resource.getString("db.driver"));
        dataSource = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error(NO_CONNECTION, e);
            throw new DataBaseSqlRuntimeException(NO_CONNECTION);
        }
    }
}
