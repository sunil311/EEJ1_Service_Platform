package com.impetus.process.exception;

import java.sql.SQLException;

public class ServicePlatformDBException extends SQLException {
	private static final long serialVersionUID = 1L;

	public ServicePlatformDBException(String message) {
		super(message);
	}

}
