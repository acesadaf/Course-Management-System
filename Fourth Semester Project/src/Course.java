import java.util.Hashtable;

public class Course {
	String Name;
	String ID;
	String Department;
	String Semester;
	String Credit;
	String CourseFaculty;
    String[] Assignment;
    String[] Link;
	String[] Materials;
	/*Course(String name, String id, String department, String semester, String credit, Hashtable assignmentlink, Hashtable quizlink)
	{
		Name=name;
		ID=id;
		Department=department;
		Semester=semester;
		Credit=credit;
		AssignmentLink=assignmentlink;
		QuizLink=quizlink;
	}*/
	
	public String[] getMaterials() {
		return Materials;
	}

	public void setMaterials(String[] materials) {
		Materials = materials;
	}

	Course(){
		Assignment = new String[150];
		Link = new String[150];
		Materials= new String[150];
	}

	public String[] getAssignment() {
		return Assignment;
	}

	public void setAssignment(String[] assignment) {
		Assignment = assignment;
	}

	public String[] getLink() {
		return Link;
	}

	public void setLink(String[] link) {
		Link = link;
	}

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

	public String getCredit() {
		return Credit;
	}

	public void setCredit(String credit) {
		Credit = credit;
	}


	public String getCourseFaculty() {
		return CourseFaculty;
	}

	public void setCourseFaculty(String courseFaculty) {
		CourseFaculty = courseFaculty;
	}


}