package com.impetus.process.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.impetus.process.constants.ConfigConstants;

public class UIDGenerator {
	public static String getNextUID() {
		return RandomStringUtils
				.randomAlphanumeric(ConfigConstants.Tenant.TENANT_ID_LENGTH);
	}
}
