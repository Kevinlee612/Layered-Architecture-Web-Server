/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that stores the responseCode and responseString from the response received 
 * by the Controller from the service class
 * It is also an abstract class.
 */
public abstract class BaseResponse implements IResponse {

	private Integer responseCode;
	private String responseString;

	/**
	 * Creates an instance of the BaseResponse class that stores the response code
	 * and response string of the Controller class
	 * @param responseCode - Code given in response to input for a method (Error or valid)
	 * @param responseString - Message that states if method was successful or not
	 */
	public BaseResponse(Integer responseCode, String responseString) {
		this.responseCode = responseCode;
		this.responseString = responseString;
	}
	
	/**
	 * Obtains responseCode Integer from BaseResponse Object
	 */
	@Override
	public Integer getResponseCode() {
		return this.responseCode;
	}

	/**
	 * Sets the responseCode for the BaseResponse Object
	 */
	@Override
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Obtains the responseString String from BaseResponse Object
	 */
	@Override
	public String getResponseString() {
		return responseString;
	}

	/**
	 * Sets the responseString String for the BaseResponse Object
	 */
	@Override
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
}
