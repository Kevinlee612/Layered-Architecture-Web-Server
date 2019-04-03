import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that receives a request from the service layer and sends a message to the service layer.
 * Will send the Student information from the database to the Service layer, which will relay it to the Controller layer.
 * Contains a lastModified long variable that keeps track of when the Student information was last changed.
 * Will read the Student information from a file and assemble the information into Student Objects in an ArrayList<Student>.
 */
public class Database implements IDatabase {

	/*
	 * Constuctor for the Database Class.
	 */
	public Database() {
	}
	 private Date date= new Date();
	 private long lastModified;
	 private List<Student> studentList;
	
	/*
	 * Will read the data off the designated database file and create Student Objects with the student information
	 * and put the students in an ArrayList, which is then saved to studentList and sent to the service layer.
	 */
	@Override
	public Object loadDb(){
		ArrayList<Student> stuarray = new ArrayList<Student>();
		try {
		String[] variables;
		String fileContent;
		String name;String PID;String major;String minor;Double CGPA;String college;String email;
		FileReader datafile = new FileReader("database.db");
		Scanner input = new Scanner(datafile);
		while (input.hasNextLine()) {
			fileContent = input.nextLine();
			if (fileContent != "") {
				variables = fileContent.split("\\|");
				if (variables.length > 2) {
					name = variables[0].substring(6, variables[0].length());
					PID = variables[1].substring(4, variables[1].length());
					major = variables[2].substring(7, variables[2].length());
					minor = variables[3].substring(7, variables[3].length());
					CGPA = Double.valueOf(variables[4].substring(6, variables[4].length()));
					college = variables[5].substring(9, variables[5].length());
					email = variables[6].substring(7, variables[6].length());
					stuarray.add(new Student(name,PID,major,minor,CGPA,college,email));
				}
			}	
		}
			
		input.close();
		lastModified = date.getTime();
		this.studentList = stuarray;
		return stuarray;
		}
		catch (Exception e) {
			System.out.println("File not found.");
		}
		return stuarray;
	}

	/*
	 * Will update the database with the changes made to the Student objects in the studList List.
	 * Is only used when changes are made to the information of the students.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void updateDb(Object studList) {
		ArrayList<Student> temp = (ArrayList<Student>) studList;
		String name;String PID;String major;String minor;String CGPA;String college;String email;
		try {
			PrintWriter printer = new PrintWriter(new FileOutputStream("database.db", false));
			
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) != null) {
					name = checkStringNull(temp.get(i).getName());
					PID = checkStringNull(temp.get(i).getPID());
					major = checkStringNull(temp.get(i).getMajor());
					minor = checkStringNull(temp.get(i).getMinor());
					CGPA = checkStringNull(Double.toString(temp.get(i).getCGPA()));
					college = checkStringNull(temp.get(i).getCollege());
					email = checkStringNull(temp.get(i).getEmail());
					printer.print("name:"+name+"|PID:"+PID+"|major:"+major
							+"|minor:"+minor+"|CGPA:"+CGPA+"|college"+college+"|email:"+email +"\n");
				}
				
			}
			printer.close();
			lastModified = date.getTime();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Will turn String values of null into the String form "null".
	 */
	public String checkStringNull(String input) {
		if (input == null) {
			return "null";
		}
		return input;
	}
	
	/*
	 * Returns the lastModified variable, which is when the database file was last modified.
	 */
	public long getLastModified() {
		return lastModified;
	}
	
	/*
	 * Setter method for the private variable lastModified.
	 */
	public void setLastModified(long num) {
		lastModified = num;
	}
	
	/*
	 * Getter method for studentList, will return the list of Student objects.
	 */
	public List<Student> getStudentList() {
		return studentList;
	}
	
	/*
	 * Setter method for studentList, will set the studentList from the database.
	 */
	@SuppressWarnings("unchecked")
	public void setStudentList(ArrayList<Student> studentList) {
		studentList = (ArrayList<Student>) loadDb();
	}

}
