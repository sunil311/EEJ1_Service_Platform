package com.impetus.serviceplatform.web.multiTenancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author amitb.kumar
 */
public class CurrentTenantIdentifierResolver
  implements org.hibernate.context.spi.CurrentTenantIdentifierResolver
{

  /**
	 * 
	 */
  private static final Logger LOGGER = LoggerFactory
    .getLogger(CurrentTenantIdentifierResolver.class);
  /**
	 * 
	 */
  public static ThreadLocal<String> _tenantIdentifier = new ThreadLocal<String>();
  /**
	 * 
	 */
  public static final String DEFAULT_TENANT_ID = "ServicePlatform";

  /*
   * (non-Javadoc)
   * @see org.hibernate.context.spi.CurrentTenantIdentifierResolver#
   * resolveCurrentTenantIdentifier()
   */
  @Override
  public String resolveCurrentTenantIdentifier()
  {
    LOGGER.debug("from inside resolveCurrentTenantIdentifier....");
    String tenantId = _tenantIdentifier.get();
    if (tenantId == null) tenantId = DEFAULT_TENANT_ID;
    LOGGER.debug("threadlocal tenant id =" + tenantId);
    return tenantId;
  }

  /*
   * (non-Javadoc)
   * @see org.hibernate.context.spi.CurrentTenantIdentifierResolver#
   * validateExistingCurrentSessions()
   */
  @Override
  public boolean validateExistingCurrentSessions()
  {
    return false;
  }

}
