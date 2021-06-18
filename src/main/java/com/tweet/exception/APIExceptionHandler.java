package com.tweet.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
	@ExceptionHandler(value = { APIRequestException.class })
	public ResponseEntity<APIException> handleApiRequestException(APIRequestException e) {
		HttpStatus badrequest = HttpStatus.UNAUTHORIZED;
		APIException apiException = new APIException(e.getMessage(), e, badrequest,
				ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, badrequest);
	}
}
