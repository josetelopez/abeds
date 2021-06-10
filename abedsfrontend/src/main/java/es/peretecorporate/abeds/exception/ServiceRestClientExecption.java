package es.peretecorporate.abeds.exception;

public class ServiceRestClientExecption extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3308299640211640233L;
	private Integer				httpStatusCode;

	public ServiceRestClientExecption(String message, Integer httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	
}
