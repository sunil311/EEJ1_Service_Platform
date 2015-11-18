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

import com.impetus.process.SysadminProcess;
import com.impetus.process.dto.DbProfileData;
import com.impetus.process.entities.SecUser;

@Controller
public class SysadminController
{
  Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  private SysadminProcess sysadminProcess;

  @RequestMapping(value = "/admin/findInactiveAggrigator", method = RequestMethod.GET)
  public List<SecUser> preService()
  {
    List<SecUser> result = sysadminProcess.getAllInactiveUsers();
    return result;
  }

  @RequestMapping(value = "/admin/updateAggrigator", method = RequestMethod.POST)
  public @ResponseBody
  String postService(@RequestBody
  DbProfileData dbProfileData)
  {
    String result = "SUCCESS";
    sysadminProcess.updateAggrigator(dbProfileData);
    return result;
  }

}
