package com.cibertec.api.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 7
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException{

	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}
}
