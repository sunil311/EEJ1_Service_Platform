package com.impetus.serviceplatform.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author amitb.kumar
 */
public class GateKeeper implements HandlerInterceptor
{
  
  @Autowired
  SessionFactory sessionFactory;
  
  Logger logger = LoggerFactory.getLogger(getClass());

  	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
  @Override
  public void afterCompletion(
    HttpServletRequest paramHttpServletRequest,
    HttpServletResponse paramHttpServletResponse,
    Object paramObject,
    Exception paramException) throws Exception
  {
    logger.info("Gate Keeper, after completion........");

  }

  /*
   * (non-Javadoc)
   * @see
   * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet
   * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
   * java.lang.Object, org.springframework.web.servlet.ModelAndView)
   */
  @Override
  public void postHandle(
    HttpServletRequest paramHttpServletRequest,
    HttpServletResponse paramHttpServletResponse,
    Object paramObject,
    ModelAndView paramModelAndView) throws Exception
  {
    sessionFactory.getCurrentSession().getTransaction().commit();
    logger.info("Gate Keeper, after request handling........");
  }

  /*
   * (non-Javadoc)
   * @see
   * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet
   * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
   * java.lang.Object)
   */
  @Override
  public boolean preHandle(
    HttpServletRequest paramHttpServletRequest,
    HttpServletResponse paramHttpServletResponse,
    Object paramObject) throws Exception
  {
    sessionFactory.getCurrentSession().getTransaction().begin();
    logger.info("Gate Keeper, before request handling........");
    return true;
  }
}
