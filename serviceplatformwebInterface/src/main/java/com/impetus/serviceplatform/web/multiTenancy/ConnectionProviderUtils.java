package com.impetus.serviceplatform.web.multiTenancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class ConnectionProviderUtils implements ConnectionProvider
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final DatasourceConnectionProviderImpl defaultProvider = new DatasourceConnectionProviderImpl();

  public static ConnectionProvider getDataBaseConnection(String database)
  {
    Properties properties = getConnectionProperties(database);
    DriverManagerConnectionProviderImpl defaultProvider = new DriverManagerConnectionProviderImpl();
    defaultProvider.configure(properties);
    return (ConnectionProvider) defaultProvider;
  }

  private static Properties getConnectionProperties(String database)
  {

    Properties properties = new Properties();
    properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.SQLServerDialect");
    properties.put(AvailableSettings.DRIVER, "net.sourceforge.jtds.jdbc.Driver");
    properties.put(AvailableSettings.URL,
      "jdbc:jtds:sqlserver://192.168.219.51:1433;databaseName=ServicePlatform");
    properties.put(AvailableSettings.USER, "sp");
    properties.put(AvailableSettings.PASS, "impetus@123");
    return properties;

  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean isUnwrappableAs(Class unwrapType)
  {
    return false;
  }

  @Override
  public <T> T unwrap(Class<T> unwrapType)
  {
    return null;
  }

  @Override
  public Connection getConnection() throws SQLException
  {
    return defaultProvider.getConnection();
  }

  @Override
  public void closeConnection(Connection conn) throws SQLException
  {
    conn.close();
  }

  @Override
  public boolean supportsAggressiveRelease()
  {
    return false;
  }

}
