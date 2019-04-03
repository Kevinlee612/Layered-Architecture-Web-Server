/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that stores the responseCode and responseString from the response received 
 * by the Controller from the service class
 * It inherits from the BaseResponse abstract class.
 * Implements IResponse
 * Contains Student Object as a String by itself or in an ArrayList to relay between layers.
 */
public class StudentResponseString extends BaseResponse implements IResponse {

	private String content;
	private String listContent;
	
	/*
	 * Constructor for the StudentResponseString class.
	 * Will make responseCode, responseString,listContent,and content all equal null by default
	 * when instantiated.
	 */
	public StudentResponseString() {
		super(null,null);
		listContent = null;
		content = null;
	}
	
	/*
	 * Getter method for the content Object.
	 */
	@Override
	public Object getContent() {
		return content;
	}
	
	/*
	 * Setter method for the content Object.
	 */
	@Override
	public void setContent(Object content) {
		this.content = (String) content;
	}
	
	/*
	 * Getter method for the listContent List<Student>.
	 */
	@Override
	public Object getListContent() {
		return listContent;
	}
	
	/*
	 * Setter method for the listContent List<Student>.
	 */
	@Override
	public void setListContent(Object content) {
		this.listContent = (String) content;
	}
	
}
