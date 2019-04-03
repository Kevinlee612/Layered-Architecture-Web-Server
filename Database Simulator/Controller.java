import java.util.ArrayList;
import java.util.List;

/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that sends a request to the service layer and receives a message from the service layer.
 * In response, the validity of the request will be represented by the responseCode and responseString of the IResponse Objects
 * StudentResponseString and StudentResponseObj.
 * Is able to remove, add, modify, and get Student object information through requests made to the service layer.
 */

public class Controller implements IController {

	/*
	 * Constructor for the Controller Class.
	 * Creates an instance of the Controller class.
	 */
	public Controller() {
	}
	
	private ArrayList<IService> services = new ArrayList<IService>();
	private IResponse responseString = new StudentResponseString();
	private IResponse responseObj = new StudentResponseObj();
	
	/*
	 * Getter method for IService object
	 */
	@Override
	public IService getService() {
		if (services.size() > 0) {
			return services.get(0);
		}
		return null;
	}

	/*
	 * Setter method for IService object
	 */
	@Override
	public void setService(IService service) {
		services.add(service);
	}

	/*
	 * Getter method for the IResponse object
	 */
	@Override
	public IResponse getResponse() {
		if (this.responseString.getResponseCode() == null){
			return responseObj;
		}
		return responseString;
	}

	/*
	 * Setter method for the IResponse object.
	 */
	@Override
	public void setResponse(IResponse response) {
		
	}

	/*
	 * Sends a request to get the student object with the corresponding information to the service layer.
	 * Will return responseCode of 400 and responseString of "BAD_REQUEST" for invalid inputs.
	 * responseCode of 404 and responseString of "NOT_FOUND" occurs when Student object with given information
	 * cannot be found.
	 * responseCode of 200 and responseString of "OK" occurs when request is successful and student is found.
	 */
	@Override
	public IResponse getStudent(Student student) {
		if (student == null||student.getPID() == null || student.getPID() == "") {
			responseObj.setResponseCode(400);
			responseObj.setResponseString("BAD_REQUEST");
			return responseObj;
		}
		if (services.get(0).getStudent(student) == null) {
			responseObj.setContent(services.get(0).getStudent(student));
			responseObj.setResponseCode(404);
			responseObj.setResponseString("NOT_FOUND");
		}
		else {
			responseObj.setResponseCode(200);
			responseObj.setResponseString("OK");
			responseObj.setContent(services.get(0).getStudent(student));
		}
		return responseObj;

	}
	
	/*
	 * Adds to the database through the service layer a student object with the given information.
	 * If PID or NAME + EMAIL are not given, the request is invalid.
	 * Will update Student if PID is given and student with the PID already exists in database.
	 * If given PID, but no other student has that PID, another Student will be created in the database.
	 * If given email and name, will create another Student Object with the given information in the database. 
	 */
	@Override
	public IResponse addStudent(Student student) {
		if ((student.getPID() == null || Integer.valueOf(student.getPID()) < 0 )&& student.getName() == null) {
			responseString.setResponseCode(400);
			responseString.setResponseString("BAD_REQUEST");
		}
		else if (student.getPID() != null || (student.getEmail() != null && student.getName() != null)) {
			 if (services.get(0).addStudent(student)) {
				 responseString.setContent(student.toString());
				 responseString.setResponseCode(201);
				 responseString.setResponseString("CREATED");
			 }
			 else {
				 responseString.setContent(student.toString());
				 responseString.setResponseCode(202);
				 responseString.setResponseString("ACCEPTED");
			 }
		}
		return responseString;
	}

	/*
	 * Will send a request to the service layer to remove a student in the database with the given PID.
	 * If the requested Student does not have a PID, the request will return a code of 400 and String "BAD_REQUEST"
	 *  
	 */
	@Override
	public IResponse removeStudent(Student student) {
		if (student.getPID() == null) {
			responseObj.setResponseCode(400);
			responseObj.setResponseString("BAD_REQUEST");
		}
		else {
			responseObj.setContent(student);
			services.get(0).removeStudent(student);
			responseObj.setResponseCode(200);
			responseObj.setResponseString("OK");
		}
		return responseObj;
	}

	/*
	 * Will send a request to the service layer to replace the data of the Student with the PID with the given information.
	 * Without a PID, the request is invalid.
	 * The student must exist in the database for the request to be completed successfully.
	 */
	@Override
	public IResponse updateStudent(Student student) {
		if (student.getPID() == null) {
			responseObj.setResponseCode(400);
			responseObj.setResponseString("BAD_REQUEST");
		}
		else {
			responseObj.setContent(student);
			if (services.get(0).updateStudent(student)) {
				responseObj.setResponseCode(200);
				responseObj.setResponseString("OK");
			}
			else {
				responseObj.setResponseCode(404);
				responseObj.setResponseString("NOT_FOUND");
			}
		}
		return responseObj;
	}

	/*
	 * Sends a request to the service layer to obtain all students from the Database in String form.
	 * If the database does not have any student information, the request will return responseCode 404
	 * and responseString "NOT_FOUND".
	 */
	@Override
	public IResponse getAllStudent() {
		List<Student> list = services.get(0).getAllStudent();
		String temp = "";
		if (list.size() == 0) {
			responseString.setResponseCode(404);
			responseString.setResponseString("NOT_FOUND");
			responseString.setListContent(temp);
		}
		else {
			responseString.setResponseCode(200);
			responseString.setResponseString("OK");
			for (int i = 0 ;i<list.size();i++) {
				temp += list.get(0).toString();
			}
			responseString.setListContent(temp);
		}
		return responseString;
	}
	
	public static void main (String[] args) {
		
	}
}
