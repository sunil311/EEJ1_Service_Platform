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

@ControllerAdvice("com.impetus")
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SessionFactory sessionFactory;

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		sessionFactory.getCurrentSession().getTransaction().rollback();
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError(Exception exception) {
		sessionFactory.getCurrentSession().getTransaction().rollback();
		exception.printStackTrace();
		logger.info(exception.getMessage());
		return "databaseError";
	}
}
