package com.impetus.serviceplatform.web.multiTenancy;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.Stoppable;

/**
 * Simplisitc implementation for illustration purposes showing a single
 * connection pool used to serve multiple schemas using "connection altering".
 */
/**
 * @author amitb.kumar
 */
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider, Stoppable
{

  /**
	 * 
	 */
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * 
   */
  private final ConnectionProvider connectionProvider = ConnectionProviderUtils
    .getDataBaseConnection(CurrentTenantIdentifierResolver.DEFAULT_TENANT_ID);

  /*
   * (non-Javadoc)
   * @see
   * org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider
   * #getAnyConnection()
   */
  @Override
  public Connection getAnyConnection() throws SQLException
  {
    return connectionProvider.getConnection();
  }

  /*
   * (non-Javadoc)
   * @see
   * org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider
   * #releaseAnyConnection(java.sql.Connection)
   */
  @Override
  public void releaseAnyConnection(Connection connection) throws SQLException
  {
    connectionProvider.closeConnection(connection);
  }

  /*
   * (non-Javadoc)
   * @see
   * org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider
   * #getConnection(java.lang.String)
   */
  @Override
  public Connection getConnection(String tenantIdentifier) throws SQLException
  {
    final Connection connection = getAnyConnection();
    try
    {
      connection.createStatement().execute("USE " + tenantIdentifier);
    }
    catch (SQLException e)
    {
      throw new HibernateException("Could not alter JDBC connection to specified schema ["
        + tenantIdentifier + "]", e);
    }
    return connection;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider
   * #releaseConnection(java.lang.String, java.sql.Connection)
   */
  @Override
  public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException
  {
    try
    {
      connection.createStatement().execute("USE master");
    }
    catch (SQLException e)
    {
      // on error, throw an exception to make sure the connection is not
      // returned to the pool.
      // your requirements may differ
      throw new HibernateException("Could not alter JDBC connection to specified schema ["
        + tenantIdentifier + "]", e);
    }
    connectionProvider.closeConnection(connection);
  }

  /*
   * (non-Javadoc)
   * @see org.hibernate.service.spi.Wrapped#isUnwrappableAs(java.lang.Class)
   */
  @Override
  public boolean isUnwrappableAs(@SuppressWarnings("rawtypes")
  Class unwrapType)
  {
    return false;
  }

  /*
   * (non-Javadoc)
   * @see org.hibernate.service.spi.Wrapped#unwrap(java.lang.Class)
   */
  @Override
  public <T> T unwrap(Class<T> unwrapType)
  {
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.hibernate.service.spi.Stoppable#stop()
   */
  @Override
  public void stop()
  {
  }

  /*
   * (non-Javadoc)
   * @see
   * org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider
   * #supportsAggressiveRelease()
   */
  @Override
  public boolean supportsAggressiveRelease()
  {
    return false;
  }
}