import javax.swing.DefaultListModel;

public class Faculty {
	String Name;
	String ID;
	String Password;
	String Department;
	String EmailAddress;
	DefaultListModel Courses;
	
	/*Faculty(String name, String id, String password, String department, String emailaddress, DefaultListModel courses)
	{
		Name=name;
		ID=id;
		Password=password;
		Department=department;
		EmailAddress=emailaddress;
		Courses=courses;
	}*/
	
	/*Faculty()
	{
		Name=null;
		ID=null;
		Password=null;
		Department=null;
		EmailAddress=null;
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

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public DefaultListModel getCourses() {
		return Courses;
	}

	public void setCourses(DefaultListModel courses) {
		Courses = courses;
	}
	

}