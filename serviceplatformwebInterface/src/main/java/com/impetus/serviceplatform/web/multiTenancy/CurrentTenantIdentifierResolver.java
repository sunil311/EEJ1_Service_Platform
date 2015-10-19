package com.impetus.serviceplatform.web.multiTenancy;

public class CurrentTenantIdentifierResolver
  implements org.hibernate.context.spi.CurrentTenantIdentifierResolver
{

  public static ThreadLocal<String> _tenantIdentifier = new ThreadLocal<String>();
  public static String DEFAULT_TENANT_ID = "ServicePlatform";

  @Override
  public String resolveCurrentTenantIdentifier()
  {
    System.out.println("from inside resolveCurrentTenantIdentifier....");
    String tenantId = _tenantIdentifier.get();
    if (tenantId == null) tenantId = DEFAULT_TENANT_ID;
    System.out.println("threadlocal tenant id =" + tenantId);
    return tenantId;
  }

  @Override
  public boolean validateExistingCurrentSessions()
  {
    return false;
  }

}
