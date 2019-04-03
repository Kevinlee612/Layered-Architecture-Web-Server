import java.util.ArrayList;
import java.util.List;

/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that stores the responseCode and responseString from the response received 
 * by the Controller from the service class
 * It inherits from the BaseResponse abstract class.
 * Implements IResponse
 * Contains Student Object by itself or in an ArrayList to relay between layers.
 */
public class StudentResponseObj extends BaseResponse implements IResponse {
	
	/*
	 * Constructor for the StudentResponseObj class.
	 * Will make responseCode, responseString,listContent,and content all equal null by default
	 * when instantiated.
	 */
	public StudentResponseObj() {
		super(null,null);
		listContent = new ArrayList<Student>();
		content = new Student(null,null,null,null,null,null,null);
	}

	private Student content;
	private List<Student> listContent;
	
	/*
	 * Getter method for the content Object.
	 */
	@Override
	public Object getContent() {
		return content;
		
	/*
	 * Setter method for the content Object.
	 */
	}
	@Override
	public void setContent(Object content) {
		this.content = (Student) content;
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
	@SuppressWarnings("unchecked")
	@Override
	public void setListContent(Object content) {
		this.listContent = (List<Student>) content;
	}
	
}
