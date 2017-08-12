import javax.swing.DefaultListModel;
public class Student {
	String Name;
	String ID;
	String Password;
	String EmailAddress;
	String Department;
	String Semester;
	//Hashtable AssignmentMarks;
	//Hashtable QuizMarks;
	DefaultListModel Courses;
	
	/*Student(String name, String id, String password, String emailaddress, String department, String semester, DefaultListModel courses)
	{
		Name=name;
		ID=id;
		Password=password;
		EmailAddress=emailaddress;
		Department=department;
		Semester=semester;
		Courses=courses;
	}*/
	
	/*Student()
	{
		Name=null;
		ID=null;
		Password=null;
		EmailAddress=null;
		Department=null;
		Semester=null;
		Courses=null;
	}*/
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public DefaultListModel getCourses() {
		return Courses;
	}

	public void setCourses(DefaultListModel courses) {
		Courses = courses;
	}
}