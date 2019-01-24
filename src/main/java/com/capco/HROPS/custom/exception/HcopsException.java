package com.capco.HROPS.custom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HcopsException extends Exception {

	private static final long serialVersionUID = 1L;

	public static class HcopsServiceException extends BaseException {
		private static final long serialVersionUID = 1L;

		public HcopsServiceException(String msg) {
			super(msg);
		}

		public HcopsServiceException(Throwable msg) {
			super(msg);
		}
	}

	public static class DAOException extends BaseException {
		private static final long serialVersionUID = 1L;

		public DAOException(String msg) {
			super(msg);
		}

		public DAOException(Throwable msg) {
			super(msg);
		}
	}

	public static class NullPointerException extends BaseException {
		private static final long serialVersionUID = 1L;

		public NullPointerException(String msg) {
			super(msg);
		}

		public NullPointerException(Throwable msg) {
			super(msg);
		}
	}

	public static class ParsingException extends BaseException {
		private static final long serialVersionUID = 1L;

		public ParsingException(String msg) {
			super(msg);
		}

		public ParsingException(Throwable msg) {
			super(msg);
		}
	}

	public class IOException extends BaseException {

		private static final long serialVersionUID = 1L;

		public IOException(String msg) {
			super(msg);
		}

		public IOException(Throwable msg) {
			super(msg);
		}

	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public static class ResourceNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		final private String resourceName;
		final private String fieldName;
		final private Object fieldValue;

		public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
			super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
			this.resourceName = resourceName;
			this.fieldName = fieldName;
			this.fieldValue = fieldValue;
		}

		public String getResourceName() {
			return resourceName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Object getFieldValue() {
			return fieldValue;
		}

	}
}
