package com.impetus.serviceplatform.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.process.AdminProcess;
import com.impetus.process.dto.DbProfileData;
import com.impetus.process.dto.UserData;
import com.impetus.process.exception.ServicePlatformException;

/**
 * @author amitb.kumar
 */
@Controller
public class AdminController
{
  /**
   * 
   */
  private static final String SOMETHING_WENT_WRONG = "Something went wrong!";
  /**
   * 
   */
  Logger logger = LoggerFactory.getLogger(getClass());
  /**
   * 
   */
  @Autowired
  private AdminProcess sysadminProcess;

  /**
   * @return
   */
  @RequestMapping(value = "/admin/findInactiveAggrigator", method = RequestMethod.GET)
  @ResponseBody
  public List<UserData> preService()
  {
    List<UserData> result = sysadminProcess.getAllInactiveUsers();
    return result;
  }

  /**
   * @param dbProfileData
   * @return
   */
  @RequestMapping(value = "/admin/updateAggrigator", method = RequestMethod.POST)
  public @ResponseBody
  String postService(@RequestBody
  DbProfileData dbProfileData)
  {
    String result;
    try
    {
      result = sysadminProcess.updateAggrigator(dbProfileData);
    }
    catch (ServicePlatformException e)
    {
      logger.error("Exception occured while updating aggregator : ", e);
      return SOMETHING_WENT_WRONG;
    }
    return result;
  }

}
