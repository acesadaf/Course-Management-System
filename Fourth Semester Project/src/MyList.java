import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
 
public class MyList{
	private JFrame MainFrame;
	private JPanel ControlPanel;
	private JPanel SecondaryPanel;
	private JButton Button1;
	private JPasswordField PasswordText;
	private JTextField UserText1;
	private JLabel Label1;
	private JLabel Label2;
	private JLabel ImageLabel;
	private JTabbedPane TabbedPane1;
	private JList List;
	private ImageIcon image;
	
	String userid=new String();
	String pass=new String();
	char[] password=new char[15];
	
	MyList(Course[] courses, Faculty []faculties, Student[] student, Admin[] admin){
    	MainFrame= new JFrame("COURSE MANAGEMENT SYSTEM");
		MainFrame.setSize(525, 400);
		//MainFrame.setLocationRelativeTo(null);;
		Button1=new JButton("LOGIN");
		Button1.setBounds(80,100,220,35);
		
		ControlPanel=new JPanel();
		SecondaryPanel=new JPanel();
		MainFrame.add(ControlPanel);
		
		Border loweredEtched;
	    loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    SecondaryPanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Login"));
		
		Label1=new JLabel("USER ID: ",JLabel.LEFT);
		Label2=new JLabel("PASSWORD: ",JLabel.LEFT);
		PasswordText=new JPasswordField(15);
		UserText1=new JTextField(20);
		ControlPanel.add(SecondaryPanel);
	
		SecondaryPanel.setLayout(null);
		ControlPanel.setLayout(null);
		SecondaryPanel.setBounds(50,70,400,150);
		PasswordText.setEchoChar('#');
		
		Button1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				userid=UserText1.getText();
				password=PasswordText.getPassword();
				pass=new String(password);
				
				
		
				
				if(userid.length()==3){
	
					
					for(int i=0; i< student.length; i++){
						System.out.println(student[i].getID());
						if(userid.equals(student[i].getID()) && pass.equals(student[i].getPassword())){
							
							
							
							
							MainFrame.dispose();
							StudentGUI studentgui=new StudentGUI("Course Management System", 1, "boy", courses);
							break;
								
						}
						else JOptionPane.showMessageDialog(null,"Invalid user ID and Password.");
					}
				}
				
				else if(userid.length()<=2){
					
					for(int i=0; i< faculties.length; i++){
						if(userid.equals(faculties[i].getID()) && pass.equals(faculties[i].getPassword())){
							MainFrame.dispose();
							FacultyGUI facultygui=new FacultyGUI("Course Management System", 1, "boy", courses, student);
							break;
								
						}
						else JOptionPane.showMessageDialog(null,"Invalid user ID and Password.");
					}
				}
				
				else if(userid.length()>3){
					for(int i=0; i< admin.length;i++){
						if(userid.equals(admin[i].getID()) && pass.equals(admin[i].getPassword())){
								MainFrame.dispose();	
								AdminGUI admingui= new AdminGUI("Course Management System", 3, "boy", courses, faculties);
								break;
							}
						else JOptionPane.showMessageDialog(null,"Invalid user ID and Password.");
						}
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid user ID and Password.");
				}
				
				}
				
			}
		);
		
		SecondaryPanel.add(PasswordText);
		SecondaryPanel.add(UserText1);
		SecondaryPanel.add(Button1);
		SecondaryPanel.add(Label1);
		SecondaryPanel.add(Label2);
		
		//MainFrame.add(ControlPanel1);
		
		Label1.setBounds(10,10,250,40);
	    Label2.setBounds(10,50,250,40);
	    UserText1.setBounds(170,20,200,20);
	    PasswordText.setBounds(170,60,200,20);
	    
	    
	    
		MainFrame.setVisible(true);
    }
   

	public static void main(String[] args){
    //  StudentGUI  MyList = new StudentGUI("STUDENT",24,"BOY");
	   
	   Faculty[] faculty= new Faculty[4];
	   Course[]courses=new Course[6];
	   Student[] student=new Student[6];
	   Admin[] admin=new Admin[1];
	   
	   DefaultListModel Empty = new DefaultListModel();
	  
	   
	   
	   String[] AssLink1={"Lin Alg 1", "Lin Alg 2"};
	   String[] AssLink2={"DLD 1", "DLD 2"};
	   String[] AssLink3={"PHY 1", "PHY 2"};
	   String[] AssLink4={"VLSI 1", "VLSI 2"};
	   String[] AssLink5={"MATERIALS 1", "MATERIALS 2"};
	   String[] AssLink6={"JAVA 1", "JAVA 2"};
	   
	   String[] MAT1={"Lin Alg 1", "Lin Alg 2"};
	   String[] MAT2={"DLD 1", "DLD 2"};
	   String[] MAT3={"PHY 1", "PHY 2"};
	   String[] MAT4={"VLSI 1", "VLSI 2"};
	   String[] MAT5={"MATERIALS 1", "MATERIALS 2"};
	   String[] MAT6={"JAVA 1", "JAVA 2"};

	   String[] LinkLink={"https://www.google.com/drive/","https://onedrive.live.com/"};
	   
	   
	   
	 
	
	   for(int i=0; i<faculty.length;i++)
	   {
		   faculty[i]= new Faculty();
	   }
	  
	   for(int i=0; i<courses.length;i++)
	   {
		   courses[i]= new Course();
	   }
	  
	   
	   for(int i=0; i<student.length;i++)
	   {
		   student[i]= new Student();
	   }
	   
	   admin[0]= new Admin();
	   
	   admin[0].setID("1001");
	   admin[0].setPassword("asdf");
	   
	   faculty[0].setName("John");
       faculty[0].setID("1");
	   faculty[0].setPassword("oh");
	   faculty[0].setDepartment("CSE");
	   faculty[0].setEmailAddress("john@gmail.com");
	   faculty[0].setCourses(Empty);
	   
	   faculty[1].setName("Katy");
	   faculty[1].setID("2");
	   faculty[1].setPassword("at");
	   faculty[1].setDepartment("EEE");
	   faculty[1].setEmailAddress("katy@gmail.com");
	   faculty[1].setCourses(Empty);
	   
	   faculty[2].setName("Jane");
	   faculty[2].setID("3");
	   faculty[2].setPassword("an");
	   faculty[2].setDepartment("MCE");
	   faculty[2].setEmailAddress("jane@gmail.com");
	   faculty[2].setCourses(Empty);
	   
	   faculty[3].setName("Jack");
	   faculty[3].setID("4");
	   faculty[3].setPassword("ac");
	   faculty[3].setDepartment("CEE");
	   faculty[3].setEmailAddress("jack@gmail.com");
	   faculty[3].setCourses(Empty);
	   
	   courses[0].setName("Linear Algebra");
	   courses[0].setID("1");
	   courses[0].setDepartment("MCE");
	   courses[0].setSemester("3");
	   courses[0].setCredit("4");
	   courses[0].setCourseFaculty("");
	   courses[0].setAssignment(AssLink1);
	   courses[0].setLink(LinkLink);
	   courses[0].setMaterials(MAT1);
	   
	   courses[1].setName("Digital Logic");
	   courses[1].setID("2");
	   courses[1].setDepartment("EEE");
	   courses[1].setSemester("4");
	   courses[1].setCredit("3");
	   courses[1].setCourseFaculty("");
	   courses[1].setAssignment(AssLink2);
	   courses[1].setLink(LinkLink);
	   courses[1].setMaterials(MAT2);
	   
	   courses[2].setName("Physics");
	   courses[2].setID("3");
	   courses[2].setDepartment("EEE");
	   courses[2].setSemester("2");
	   courses[2].setCredit("2");
	   courses[2].setCourseFaculty("");
	   courses[2].setAssignment(AssLink3);
	   courses[2].setLink(LinkLink);
	   courses[2].setMaterials(MAT3);
	   
	   courses[3].setName("VLSI");
	   courses[3].setID("4");
	   courses[3].setDepartment("CSE");
	   courses[3].setSemester("8");
	   courses[3].setCredit("3");
	   courses[3].setCourseFaculty("");
	   courses[3].setAssignment(AssLink4);
	   courses[3].setLink(LinkLink);
	   courses[3].setMaterials(MAT4);
	   
	   courses[4].setName("Materials");
	   courses[4].setID("5");
	   courses[4].setDepartment("CEE");
	   courses[4].setSemester("5");
	   courses[4].setCredit("2");
	   courses[4].setCourseFaculty("");
	   courses[4].setAssignment(AssLink5);
	   courses[4].setLink(LinkLink);
	   courses[4].setMaterials(MAT5);
	   
	   courses[5].setName("Java Programming");
	   courses[5].setID("6");
	   courses[5].setDepartment("CSE");
	   courses[5].setSemester("4");
	   courses[5].setCredit("2");
	   courses[5].setCourseFaculty("");
	   courses[5].setAssignment(AssLink6);
	   courses[5].setLink(LinkLink);
	   courses[5].setMaterials(MAT6);
	   
	   student[0].setName("Sadaf");
	   student[0].setID("101");
	   student[0].setPassword("ada");
	   student[0].setEmailAddress("sadaf@gmail.com");
	   student[0].setDepartment("CSE");
	   student[0].setSemester("4");
	   student[0].setCourses(Empty);
	   
	   student[1].setName("Labib");
	   student[1].setID("102");
	   student[1].setPassword("abi");
	   student[1].setEmailAddress("labib@gmail.com");
	   student[1].setDepartment("EEE");
	   student[1].setSemester("6");
	   student[1].setCourses(Empty);
	   
	   student[2].setName("Saqub");
	   student[2].setID("103");
	   student[2].setPassword("aqu");
	   student[2].setEmailAddress("saqub@gmail.com");
	   student[2].setDepartment("CEE");
	   student[2].setSemester("8");
	   student[2].setCourses(Empty);
	   
	   student[3].setName("Istaq");
	   student[3].setID("104");
	   student[3].setPassword("sta");
	   student[3].setEmailAddress("istaq@gmail.com");
	   student[3].setDepartment("CEE");
	   student[3].setSemester("1");
	   student[3].setCourses(Empty);
	   
	   student[4].setName("Irtza");
	   student[4].setID("105");
	   student[4].setPassword("rtz");
	   student[4].setEmailAddress("irtza@gmail.com");
	   student[4].setDepartment("MCE");
	   student[4].setSemester("5");
	   student[4].setCourses(Empty);
	   
	   student[5].setName("Angel");
	   student[5].setID("106");
	   student[5].setPassword("nge");
	   student[5].setEmailAddress("angel@gmail.com");
	   student[5].setDepartment("EEE");
	   student[5].setSemester("7");
	   student[5].setCourses(Empty);
	   
	   for(int i=0;i<courses.length;i++)
	   {
	    	//  System.out.println(courses[i].getID());
	   }
	   
	   
	   MyList main=new MyList(courses, faculty, student, admin);
   }
}