package com.impetus.process.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.impetus.process.constants.ConfigConstants;

/**
 * @author amitb.kumar
 */
public class UIDGenerator
{
  /**
   * @return
   */
  public static String getNextUID()
  {
    return RandomStringUtils.randomAlphanumeric(ConfigConstants.Tenant.TENANT_ID_LENGTH);
  }
}
