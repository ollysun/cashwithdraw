package com.test.cashwithdrawal.shared.exception;

public class SqlExceptionError extends Throwable {
	private static final long serialVersionUID = 1L;
    public SqlExceptionError(String message) {
        super(message);
    }
}
