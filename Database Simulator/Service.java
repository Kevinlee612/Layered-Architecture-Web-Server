import java.util.ArrayList;
import java.util.List;

/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that sends a request to the database layer and sends a message to the Controller layer.
 * The Service class has a ArrayList of IDatabase objects to keep track of all instances of databases.
 * The List<Student> studList acts as the memory of all changes made to the Database.
 * Is able to remove, add, modify, and get Student object information through requests from the Controller layer and
 * interacting with the database layer.
 */
public class Service implements IService {

	private ArrayList<IDatabase> Databases = new ArrayList<IDatabase>();
	private List<Student> studList = new ArrayList<Student>();
	
	/*
	 * Constuctor for the Service class 
	 */
	public Service() {
	}

	/*
	 * Obtains the List of Student objects from the database layer and stores it to studList.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void loadDb() {
		this.studList = (ArrayList<Student>) Databases.get(0).loadDb();
	}

	/*
	 * Saves the changes made to the database to the file designated in the database layer.
	 */
	@Override
	public void updateDb() {
		checkLoaded();
		Databases.get(0).updateDb(studList);
	}

	/*
	 * Checks if the studList has been loaded from the Database layer.
	 */
	public void checkLoaded() {
		if (this.studList == null) {
			this.loadDb();
		}
	}
	
	/*
	 * Obtains the Student Object with the requested PID from the database layer
	 * and returns it to the Controller layer.
	 * If no student is found with the PID, returns null.
	 */
	@Override
	public Student getStudent(Student student) {
		checkLoaded();
		for (int i =0; i < studList.size();i++) {
			if (studList.get(i).getPID().equals(student.getPID())) {
				return studList.get(i);
			}
		}
		return null;
	}

	/*
	 * Will check if a String's value is null and returns null in string form.
	 */
	public String checkStringNull(String input) {
		if (input == null) {
			return "null";
		}
		return input;
	}
	
	/*
	 * Adds the student with the given information into the database.
	 * If a student with the given PID exists, will be treated as an Update request.
	 * Returns false if update request and true if the request creates a new Student entry.
	 */
	@Override
	public boolean addStudent(Student student) {
		checkLoaded();
		if (student.getPID() != null || student.getPID() != "") {
			for (int i = 0;i < studList.size();i++) {
				if (studList.get(i) != null) {
					if (studList.get(i).getPID() == student.getPID()) {				
						if (studList.get(i).getPID() == student.getPID()) {
							studList.get(i).setName(checkStringNull(student.getName()));
							studList.get(i).setMajor(checkStringNull(student.getMajor()));
							studList.get(i).setMinor(checkStringNull(student.getMinor()));
							studList.get(i).setCollege(checkStringNull(student.getCollege()));
							studList.get(i).setCGPA(student.getCGPA());
							studList.get(i).setEmail(checkStringNull(student.getEmail()));
						}
						updateDb();
						return false;
					}
				}
				
			}
			//studList.add(student);
			//updateDb();
			return true;
		}
		else {
			studList.add(student);
			updateDb();
			return true;
		}
	}

	/*
	 * Removes the student with the given PID from the database. If no student with the PID exists,
	 * irregardless if the student was removed or did not exist, returns true.
	 */
	@Override
	public boolean removeStudent(Student student) {
		this.checkLoaded();
		for (int i = 0; i < studList.size(); i++) {
			if (studList.get(i).getPID() == student.getPID()) {
				studList.remove(i);
				updateDb();
			}
		}
		return true;
	}

	/*
	 * Will update the information of the student with the given PID. If update is successful, will return true.
	 * If no student with the PID was found in the Database, will return false.
	 */
	@Override
	public boolean updateStudent(Student student) {
		this.checkLoaded();
		for (int i = 0; i < studList.size(); i++) {
			if (studList.get(i) != null) {
				if (studList.get(i).getPID() == student.getPID()) {
					studList.get(i).setName(checkStringNull(student.getName()));
					studList.get(i).setMajor(checkStringNull(student.getMajor()));
					studList.get(i).setMinor(checkStringNull(student.getMinor()));
					studList.get(i).setCollege(checkStringNull(student.getCollege()));
					studList.get(i).setCGPA(student.getCGPA());
					studList.get(i).setEmail(checkStringNull(student.getEmail()));
					updateDb();
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Will load all students from the Database if not yet loaded and returns the list as studList to
	 * the Controller layer.
	 */
	@Override
	public List<Student> getAllStudent() {
		this.checkLoaded();
		return studList;
	}

	/*
	 * The getter method for the IDatabase object.
	 * Will obtain the instantiated IDatabase object.
	 */
	@Override
	public IDatabase getDatabase() {
		return Databases.get(0);
	}

	/*
	 * The setter method for the IDatabase object.
	 * Will set the IDatabase object.
	 */
	@Override
	public void setDatabase(IDatabase database) {
		Databases.add(database = new Database());
		loadDb();
	}

}
