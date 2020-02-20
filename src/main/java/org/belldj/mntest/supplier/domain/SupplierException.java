package org.belldj.mntest.supplier.domain;

public class SupplierException extends RuntimeException {

	public SupplierException() {
		super();
	}

	public SupplierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SupplierException(String message, Throwable cause) {
		super(message, cause);
	}

	public SupplierException(String message) {
		super(message);
	}

	public SupplierException(Throwable cause) {
		super(cause);
	}

}
