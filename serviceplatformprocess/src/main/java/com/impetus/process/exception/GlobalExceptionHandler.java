package com.impetus.process.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author amitb.kumar
 */
@ControllerAdvice("com.impetus")
public class GlobalExceptionHandler
{

  /**
	 * 
	 */
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
	 * 
	 */
  @Autowired
  SessionFactory sessionFactory;

  /**
   * @param req
   * @param exception
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ModelAndView handleError(HttpServletRequest req, Exception exception)
  {
    sessionFactory.getCurrentSession().getTransaction().rollback();
    LOGGER.error("Request: " + req.getRequestURL() + " raised " + exception);
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", exception);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error");
    return mav;
  }

  /**
   * @param exception
   * @return
   */
  @ExceptionHandler({SQLException.class, DataAccessException.class})
  public String databaseError(Exception exception)
  {
    sessionFactory.getCurrentSession().getTransaction().rollback();
    LOGGER.info(exception.getMessage());
    return "databaseError";
  }
}
