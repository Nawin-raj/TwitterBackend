package com.tweet.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class APIException {
	private String message;
	private Throwable throwable;
	private HttpStatus httpstatus;
	private ZonedDateTime datetime;

	public APIException(String message, Throwable throwable, HttpStatus httpstatus, ZonedDateTime datetime) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.datetime = datetime;
	}

	public APIException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}

}
