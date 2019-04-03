/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that includes the information of the Student Objects
 * such as name,PID,major,minor,CGPA,college,email
 * Will keep track of the highest PID in the scenario that another Student object added without a PID
 * must be provided with one.
 */
public class Student {

	private String name;
	private String PID;
	private String major;
	private String minor;
	private Double CGPA;
	private String college;
	private String email;
	private static int newPID = 1;
	
	/*
	 * The default constuctor for the student class.
	 * Will set all private variables to null and will assign a PID to the student
	 * based off the highest existing PID in the database. If no student exists in the database,
	 * The student will start its PID at 1.
	 */
	public Student() {
		this.name = null;
		this.PID = Integer.toString(Student.getNewPID());
		this.major = null;
		this.minor = null;
		this.CGPA = null;
		this.college = null;
		this.email = null;
		if (Integer.parseInt(PID) > newPID) {
			newPID = Integer.parseInt(PID);
		}
	}
	
	/*
	 * The constuctor of the Student Class that will take the given information for the student and assign them to the
	 * corresponding variables.
	 * Similar to the default constructor for the Student Class, will assign the next highest PID if PID is not given for the
	 * student when instantiated.
	 */
	public Student(String name,String PID,String Major, String minor,Double CGPA,String College,String email){
		this.name = name;
		this.PID = PID;
		this.major = Major;
		this.minor = minor;
		this.CGPA = CGPA;
		this.college = College;
		this.email = email;
		if (PID == null) {
			PID = Integer.toString(Student.getNewPID());
		}
		if (Integer.parseInt(PID) > newPID) {
			newPID = Integer.parseInt(PID);
		}
	}
	
	/*
	 * Will check if a String is null. If so, it will return "null".
	 */
	public String checkStringNull(String input) {
		if (input == null) {
			return "null";
		}
		return input;
	}
	
	/*
	 * Assembles the information of a Student Object into a String representation of it.
	 */
	@Override
	public String toString() {
		String stringrepresent = "name:"+checkStringNull(this.name)+"|PID:"+checkStringNull(this.PID)
		+"|major:"+checkStringNull(this.major)+"|minor:"+checkStringNull(this.minor)+"|CGPA:"
				+String.format("%f",this.CGPA)+"|college:"+checkStringNull(this.college)+"|email:"+checkStringNull(this.email); 
		return stringrepresent;
	}
	
	/*
	 * Provides a hashcode for the Student Objects based on their PID Strings. Students with the same PID will have the same
	 * hashCode.
	 */
	@Override
	public int hashCode() {
		return PID.hashCode();
	}
	
	/*
	 * Compares the PID of two Student Objects and returns true if their PIDs are the same.
	 * Will return false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this.PID == ((Student) obj).getPID()) {
			return true;
		}
		return false;
	}
	
	/*
	 * The getter method for the name String variable.
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * The getter method for the PID String variable.
	 */
	public String getPID() {
		return this.PID;
	}
	
	/*
	 * The getter method for the major String variable.
	 */
	public String getMajor() {
		return this.major;
	}
	
	/*
	 * The getter method for the minor String variable.
	 */
	public String getMinor() {
		return this.minor;
	}
	
	/*
	 * The getter method for the CGPA Double Object.
	 */
	public Double getCGPA() {
		return this.CGPA;
	}
	
	/*
	 * The getter method for the college String variable.
	 */
	public String getCollege() {
		return this.college;
	}
	
	/*
	 * The getter method for the email String variable.
	 */
	public String getEmail() {
		 return this.email;
	}
	
	/*
	 * The setter method for the name String variable.
	 */
	public void setName(String name) {
		 this.name = name;
	}
	
	/*
	 * The setter method for the PID String variable.
	 */
	public void setPID(String PID) {
		 this.PID = PID;
	}
	
	/*
	 * The setter method for the major String variable.
	 */
	public void setMajor(String major) {
		 this.major = major;
	}
	
	/*
	 * The setter method for the minor String variable.
	 */
	public void setMinor(String minor) {
		 this.minor = minor;
	}
	
	/*
	 * The setter method for the CGPA Double Object.
	 */
	public void setCGPA(Double CGPA) {
		 this.CGPA = CGPA;
	}
	
	/*
	 * The setter method for the college String variable.
	 */
	public void setCollege(String college) {
		 this.college = college;
	}
	
	/*
	 * The setter method for the email String variable.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * The getter method for the newPID int variable.
	 */
	public static int getNewPID() {
		return newPID;
	}
}
