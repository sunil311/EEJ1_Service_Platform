package com.impetus.serviceplatform.web.multiTenancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentTenantIdentifierResolver implements
		org.hibernate.context.spi.CurrentTenantIdentifierResolver {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CurrentTenantIdentifierResolver.class);
	public static ThreadLocal<String> _tenantIdentifier = new ThreadLocal<String>();
	public static final String DEFAULT_TENANT_ID = "ServicePlatform";

	@Override
	public String resolveCurrentTenantIdentifier() {
		LOGGER.debug("from inside resolveCurrentTenantIdentifier....");
		String tenantId = _tenantIdentifier.get();
		if (tenantId == null)
			tenantId = DEFAULT_TENANT_ID;
		LOGGER.debug("threadlocal tenant id =" + tenantId);
		return tenantId;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return false;
	}

}
