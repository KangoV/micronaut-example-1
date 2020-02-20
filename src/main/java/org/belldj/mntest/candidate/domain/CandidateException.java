package org.belldj.mntest.candidate.domain;

public class CandidateException extends RuntimeException {

	public CandidateException() {
		super();
	}

	public CandidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CandidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public CandidateException(String message) {
		super(message);
	}

	public CandidateException(Throwable cause) {
		super(cause);
	}

}
