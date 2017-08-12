import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FacultyGUI extends JFrame {
   private JTabbedPane tabbedPane;
   private String course;
   private int season;
   
   String DeptCompare;
   String StudCompare;
   
   Course[] coursesAdmin= new Course[100];
   Student[] studentsAdmin = new Student[100];
   JPanel tab1Panel     = new JPanel();
   JPanel tab2Panel     = new JPanel();
   JPanel tab3Panel     = new JPanel();
   JPanel tab4Panel     = new JPanel();
   JPanel tab5Panel     = new JPanel();
   JTextField addEntry  = new JTextField();
   
   private JLabel nameAns= new JLabel("");
   private JLabel idAns= new JLabel("");
   private JLabel deptAns= new JLabel("");
   private JLabel creditAns= new JLabel("");
   
   DefaultListModel Courses= new DefaultListModel();
   DefaultListModel SelectedCourses     = new DefaultListModel();
   
   DefaultComboBoxModel ComboModel = new DefaultComboBoxModel();
   DefaultListModel StudentModel = new DefaultListModel();
   
   String n = new String("zzzz");
   String i = new String("sss");
   String d = new String("");
   String c = new String("");
   

   DefaultListModel AssignmentModel = new DefaultListModel();
   DefaultListModel MaterialModel = new DefaultListModel();
   
   DefaultListModel studentName      = new DefaultListModel();
   DefaultListModel studentAge       = new DefaultListModel();
   DefaultListModel studentAddress   = new DefaultListModel();
   DefaultListModel isFirstCourse    = new DefaultListModel();
   DefaultListModel enrolledStudents = new DefaultListModel();

   JList studentNamelist1    = new JList(SelectedCourses);
   JList studentNamelist2    = new JList(StudentModel);
   JList assignmentNameList    = new JList(AssignmentModel);
   JList materialsNameList    = new JList(MaterialModel);
   JList quizNameList    = new JList(studentName);
   JList enrolledStudentlist = new JList(enrolledStudents);
   
   JScrollPane scrollstudentNamelist1     = new JScrollPane(studentNamelist1);
   JScrollPane scrollstudentNamelist2     = new JScrollPane(studentNamelist2);
   JScrollPane scrollassignmentNameList     = new JScrollPane(assignmentNameList);
   JScrollPane scrollQuizNameList     = new JScrollPane(quizNameList);
   JScrollPane scrollMaterialsNameList     = new JScrollPane(materialsNameList);
  
   JScrollPane scrollEnrolledStudentslist = new JScrollPane(enrolledStudentlist);
    
   public FacultyGUI(String title, int season, String course, Course[] courses, Student[] students){

      super(title);
      
      //setLocation(250, 184);
      this.course = course;
      this.season = season;
      
      coursesAdmin=courses;
      studentsAdmin=students;

      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      getContentPane().add(topPanel);

      // Create the tab pages
      createPage1();
      createPage2();
      createPage3();
      createPage4();
      
      
      createPage5();

      studentNamelist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      studentNamelist2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      assignmentNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      materialsNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      quizNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      enrolledStudentlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Create a tabbed pane
      tabbedPane = new JTabbedPane();
      tabbedPane.addTab( "Courses", tab1Panel);
      tabbedPane.addTab( "Assignments", tab2Panel);
     // tabbedPane.addTab( "Quizzes", tab3Panel);
      tabbedPane.addTab( "Materials", tab4Panel);
      tabbedPane.addTab( "Students", tab5Panel);
      topPanel.add(tabbedPane, BorderLayout.CENTER);

      this.pack();
      this.setSize(525, 400);
      this.setBackground(Color.gray);
      this.setVisible(true);
      this.setResizable(false);
     // this.addWindowListener(this);
   }

   public void createPage1(){ 

	  
	      JPanel newStudentPanel  = new JPanel();
	      JPanel courseNamePanel = new JPanel();
	      
	      JLabel nameLabel   = new JLabel("Name:");    
	      JLabel idLabel    = new JLabel("ID:");
	      JLabel deptLabel    = new JLabel("Department:");
	      JLabel creditLabel    = new JLabel("Credit:");   
	      
	      JButton b1              = new JButton("Exit");
	      JPanel blank            = new JPanel();

	      tab1Panel.       setLayout(null);  
	      newStudentPanel. setLayout(null);
	      courseNamePanel.setLayout(null);
	      blank.setLayout(new GridLayout(4,2));

	      Border loweredEtched;
	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	      tab1Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
	      newStudentPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Course Details"));         
	      courseNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Courses"));
	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

	      
	      courseNamePanel.add(scrollstudentNamelist1);
	      
	      
	      
	      newStudentPanel. add(b1);
	      newStudentPanel. add(nameLabel);
	      newStudentPanel. add(idLabel);
	      newStudentPanel. add(deptLabel);
	      newStudentPanel. add(creditLabel);
	      newStudentPanel.add(nameAns);
	      newStudentPanel.add(idAns);
	      newStudentPanel.add(deptAns);
	      newStudentPanel.add(creditAns);
	      
	      
	      newStudentPanel. add(blank);
	      tab1Panel.       add(newStudentPanel);
	      tab1Panel.       add(courseNamePanel);
	      /*b1.addActionListener(this);     
	      b2.addActionListener(this);     
	      b3.addActionListener(this);     
	      b4.addActionListener(this); */

	      scrollstudentNamelist1.setBounds(10,20,155,275);
	      newStudentPanel.       setBounds(5,30,330,305);
	      courseNamePanel.      setBounds(335,30,175,305);
	      nameLabel.      setBounds(335,30,175,305);
	      b1.     setBounds(172,230,145,22);
	      nameLabel.setBounds(50,40,145,22);
	      idLabel.setBounds(50,80,145,22);
	      deptLabel.setBounds(50,120,145,22);
	      creditLabel.setBounds(50,160,145,22);
	      nameAns.setBounds(200, 40, 145, 22);
	      idAns.setBounds(200, 80, 145, 22);
	      deptAns.setBounds(200, 120, 145, 22);
	      creditAns.setBounds(200, 160, 145, 22);
	      blank.  setBounds(10,200,310,5);
	      
	      
	      for(int i=0; i<coursesAdmin.length; i++)
	 	  {
	 	    SelectedCourses.addElement(coursesAdmin[i].getName());
	 	    	
	 	  }
	      
	      studentNamelist1.addListSelectionListener( new ListSelectionListener(){
	    	  public void valueChanged(ListSelectionEvent event){
	    		  if(studentNamelist1.getSelectedIndex()>=0)
	    		  {
	    			  n=(String)SelectedCourses.getElementAt(studentNamelist1.getSelectedIndex());
	    			  for(int j = 0; j < coursesAdmin.length; j++) {
	    				  if(coursesAdmin[j].getName() == n) {
	    					  i = coursesAdmin[j].getID();
	    					  d = coursesAdmin[j].getDepartment();
	    					  c = coursesAdmin[j].getCredit();
	    					  
	    				  }
	    			  }
	    			  
	    			  
	    			  
	    			  nameAns.setText(n);
	    		      idAns.setText(i);
	    		      deptAns.setText(d);
	    		      creditAns.setText(c);

	    		  }
	    		  
	    	  }
	      }
	    		  );
	      
	      
	      
	      b1.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  System.exit(0);
	    	  }
	      });

   	}
 
   	public void createPage2() {

   		
   		JTextField assignmentEntry = new JTextField();
   		JTextField linkEntry  = new JTextField();
   	   

 	      JPanel newAssignmentPanel  = new JPanel();
 	      JPanel assignmentNamePanel = new JPanel();
 	      
 	      JLabel nameLabel   = new JLabel("Enter assignment details below:");    
 	      
 	      JButton b1              = new JButton("Exit");
 	      
 	      JLabel addAssignmentLabel = new JLabel("Assignment:");
 	      JLabel addLinkLabel    = new JLabel("Link:");
 	      
 	      JPanel blank            = new JPanel();

 	      tab2Panel.       setLayout(null);  
 	      newAssignmentPanel. setLayout(null);
 	      assignmentNamePanel.setLayout(null);
 	      blank.setLayout(new GridLayout(4,2));

 	      Border loweredEtched;
 	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
 	      tab2Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
 	      newAssignmentPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Assignment Details"));         
 	      assignmentNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Assignment"));
 	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

 	      
 	      assignmentNamePanel.add(scrollassignmentNameList);
 	      newAssignmentPanel. add(addAssignmentLabel);
 	      newAssignmentPanel. add(assignmentEntry);
 	      newAssignmentPanel. add(addLinkLabel);
 	      newAssignmentPanel. add(linkEntry);
	      
 	      
 	      
 	      newAssignmentPanel. add(b1);
 	      newAssignmentPanel. add(nameLabel);
 	      
 	      newAssignmentPanel. add(blank);
 	      tab2Panel.       add(newAssignmentPanel);
 	      tab2Panel.       add(assignmentNamePanel);
 	      /*b1.addActionListener(this);     
 	      b2.addActionListener(this);     
 	      b3.addActionListener(this);     
 	      b4.addActionListener(this); */

 	      scrollassignmentNameList.setBounds(10,20,155,275);
 	      newAssignmentPanel.       setBounds(5,30,330,305);
 	      assignmentNamePanel.      setBounds(335,30,175,305);
 	      nameLabel.      setBounds(335,30,175,305);
 	     
 	      
 	      b1.     setBounds(172,230,145,22);
 	      nameLabel.setBounds(35,30,250,22);
 	      blank.  setBounds(10,200,310,5);
 	      addAssignmentLabel.setBounds(35,65,250,22);
	      assignmentEntry.  setBounds(120,65,170,22);
	      addLinkLabel.setBounds(35,100,250,22);
	      linkEntry.  setBounds(120,100,170,90);
 	      
 	     
 		JButton LinkButton1 =new JButton("OK");
 		newAssignmentPanel.add(LinkButton1);
 		LinkButton1.setBounds(30,230,145,22);   
 		
 		LinkButton1.addActionListener(new ActionListener()
 				{
 					public void actionPerformed(ActionEvent event)
 					{
 						AssignmentModel.addElement(assignmentEntry.getText());
 						assignmentEntry.setText("");
 						linkEntry.setText("");
 					}
 				}
 				);
 		b1.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  System.exit(0);
	    	  }
	      });
   	}

   	public void createPage3() {


   		JTextField assignmentEntry = new JTextField();
   	   JTextField linkEntry  = new JTextField();
   	   
  	      JPanel newQuizPanel  = new JPanel();
  	      JPanel quizNamePanel = new JPanel();
  	      
  	      JLabel nameLabel   = new JLabel("Enter quiz details below:");    
  	      
  	      JButton b1              = new JButton("Exit");
  	      
  	      JLabel addAssignmentLabel = new JLabel("Quiz:");
  	      JLabel addLinkLabel    = new JLabel("Link:");
  	      
  	      JPanel blank            = new JPanel();

  	      tab3Panel.       setLayout(null);  
  	      newQuizPanel. setLayout(null);
  	      quizNamePanel.setLayout(null);
  	      blank.setLayout(new GridLayout(4,2));

  	      Border loweredEtched;
  	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
  	      tab3Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
  	      newQuizPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Quiz Details"));         
  	      quizNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Quiz"));
  	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

  	      
  	      quizNamePanel.add(scrollQuizNameList);
  	      newQuizPanel. add(addAssignmentLabel);
  	      newQuizPanel. add(assignmentEntry);
  	      newQuizPanel. add(addLinkLabel);
  	      newQuizPanel. add(linkEntry);
 	      
  	      
  	      
  	      newQuizPanel. add(b1);
  	      newQuizPanel. add(nameLabel);
  	      
  	      newQuizPanel. add(blank);
  	      tab3Panel.       add(newQuizPanel);
  	      tab3Panel.       add(quizNamePanel);
  	      /*b1.addActionListener(this);     
  	      b2.addActionListener(this);     
  	      b3.addActionListener(this);     
  	      b4.addActionListener(this); */

  	      scrollQuizNameList.setBounds(10,20,155,275);
  	      newQuizPanel.       setBounds(5,30,330,305);
  	      quizNamePanel.      setBounds(335,30,175,305);
  	      nameLabel.      setBounds(335,30,175,305);
  	     
  	      
  	      b1.     setBounds(172,230,145,22);
  	      nameLabel.setBounds(35,30,250,22);
  	      blank.  setBounds(10,200,310,5);
  	      addAssignmentLabel.setBounds(35,65,250,22);
 	      assignmentEntry.  setBounds(120,65,170,22);
 	      addLinkLabel.setBounds(35,100,250,22);
 	      linkEntry.  setBounds(120,100,170,90);
  	      
  	     
  		JButton LinkButton1 =new JButton("OK");
  		newQuizPanel.add(LinkButton1);
  		LinkButton1.setBounds(30,230,145,22);   
	   
	}
	
	public void createPage4(){


		JTextField assignmentEntry = new JTextField();
		   JTextField linkEntry  = new JTextField();
		   
		
	 	      JPanel newMaterialPanel  = new JPanel();
	 	      JPanel materialNamePanel = new JPanel();
	 	      
	 	      JLabel nameLabel   = new JLabel("Enter material details below:");    
	 	      
	 	      JButton b1              = new JButton("Exit");
	 	      
	 	      JLabel addAssignmentLabel = new JLabel("Material:");
	 	      JLabel addLinkLabel    = new JLabel("Link:");
	 	      
	 	      JPanel blank            = new JPanel();

	 	      tab4Panel.       setLayout(null);  
	 	      newMaterialPanel. setLayout(null);
	 	      materialNamePanel.setLayout(null);
	 	      blank.setLayout(new GridLayout(4,2));

	 	      Border loweredEtched;
	 	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	 	      tab4Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
	 	      newMaterialPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Material Details"));         
	 	      materialNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Material"));
	 	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

	 	      
	 	      materialNamePanel.add(scrollMaterialsNameList);
	 	      newMaterialPanel. add(addAssignmentLabel);
	 	      newMaterialPanel. add(assignmentEntry);
	 	      newMaterialPanel. add(addLinkLabel);
	 	      newMaterialPanel. add(linkEntry);
		      
	 	      
	 	      
	 	      newMaterialPanel. add(b1);
	 	      newMaterialPanel. add(nameLabel);
	 	      
	 	      newMaterialPanel. add(blank);
	 	      tab4Panel.       add(newMaterialPanel);
	 	      tab4Panel.       add(materialNamePanel);
	 	      /*b1.addActionListener(this);     
	 	      b2.addActionListener(this);     
	 	      b3.addActionListener(this);     
	 	      b4.addActionListener(this); */

	 	      scrollMaterialsNameList.setBounds(10,20,155,275);
	 	      newMaterialPanel.       setBounds(5,30,330,305);
	 	      materialNamePanel.      setBounds(335,30,175,305);
	 	      nameLabel.      setBounds(335,30,175,305);
	 	     
	 	      
	 	      b1.     setBounds(172,230,145,22);
	 	      nameLabel.setBounds(35,30,250,22);
	 	      blank.  setBounds(10,200,310,5);
	 	      addAssignmentLabel.setBounds(35,65,250,22);
		      assignmentEntry.  setBounds(120,65,170,22);
		      addLinkLabel.setBounds(35,100,250,22);
		      linkEntry.  setBounds(120,100,170,90);
	 	      
	 	     
	 		JButton LinkButton1 =new JButton("OK");
	 		newMaterialPanel.add(LinkButton1);
	 		LinkButton1.setBounds(30,230,145,22);   
	 		
	 		
	 		
	 		LinkButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						MaterialModel.addElement(assignmentEntry.getText());
						assignmentEntry.setText("");
						linkEntry.setText("");
					}
				}
				);
	 		
	 		
	 		b1.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e) {
		    		  System.exit(0);
		    	  }
		      });
	}
		
		public void createPage5(){
			
				

			      JPanel newStudentPanel  = new JPanel();
			      JPanel courseNamePanel = new JPanel();
			      
			      JLabel nameLabel   = new JLabel("Name:");    
			      JLabel idLabel    = new JLabel("ID:");
			      JLabel semLabel    = new JLabel("Semester:");
			      JLabel creditLabel    = new JLabel("E-mail:");   
			      JLabel DropLabel = new JLabel("Select Department:");
			      
			      JLabel nameAns = new JLabel("");
			      JLabel idAns = new JLabel("");
			      JLabel semAns = new JLabel("");
			      JLabel creditAns = new JLabel("");
			      
			      JButton b1              = new JButton("Exit");
			      JPanel blank            = new JPanel();

			      tab5Panel.       setLayout(null);  
			      newStudentPanel. setLayout(null);
			      courseNamePanel.setLayout(null);
			      blank.setLayout(new GridLayout(4,2));

			      Border loweredEtched;
			      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			      tab5Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
			      newStudentPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Student Details"));         
			      courseNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Students"));
			      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

			      
			      courseNamePanel.add(scrollstudentNamelist2);
			      
			      
			      for(int i=0; i<studentsAdmin.length; i++)
				      {
				    	  if(studentsAdmin[i].Department.equals("CSE"))StudentModel.addElement(studentsAdmin[i].Name);
				      }
			      
			      
			      newStudentPanel. add(b1);
			      newStudentPanel. add(nameLabel);
			      newStudentPanel. add(idLabel);
			      newStudentPanel. add(semLabel);
			      newStudentPanel. add(creditLabel);
			      newStudentPanel.add(DropLabel);
			      newStudentPanel.add(nameAns);
			      newStudentPanel.add(idAns);
			      newStudentPanel.add(semAns);
			      newStudentPanel.add(creditAns);
			      
			      newStudentPanel. add(blank);
			      tab5Panel.       add(newStudentPanel);
			      tab5Panel.       add(courseNamePanel);
			      /*b1.addActionListener(this);     
			      b2.addActionListener(this);     
			      b3.addActionListener(this);     
			      b4.addActionListener(this); */

			      scrollstudentNamelist2.setBounds(10,20,155,275);
			      newStudentPanel.       setBounds(5,30,330,305);
			      courseNamePanel.      setBounds(335,30,175,305);
			      nameLabel.      setBounds(335,30,175,305);
			      b1.     setBounds(172,230,145,22);
			      nameLabel.setBounds(50,40,145,22);
			      idLabel.setBounds(50,80,145,22);
			      semLabel.setBounds(50,120,145,22);
			      creditLabel.setBounds(50,160,145,22);
			      nameAns.setBounds(170, 40,145,22);
			      idAns.setBounds(170, 80 ,145,22);
			      semAns.setBounds(170,120 ,145,22);
			      creditAns.setBounds(170,160 ,145,22);
			      
			      blank.  setBounds(10,200,310,5);
			      DropLabel.setBounds(48, 15, 145, 22);
			      
			   //   String []a ={"whatever", "hmm", "Ya", "no"};
			      JComboBox Drop1= new JComboBox(ComboModel);
			      
			      
			    /*  for(int i=0; i<coursesAdmin.length;i++)
			      {
			    	  ComboModel.addElement(coursesAdmin[i].Name);
			      }*/
			      
			      ComboModel.addElement("CSE");
			      ComboModel.addElement("MCE");
			      ComboModel.addElement("EEE");
			      ComboModel.addElement("CEE");
			      Drop1.setSelectedIndex(0);
			      Drop1.setMaximumRowCount(5);
			      Drop1.setForeground(Color.BLACK);
			      Drop1.setBackground(Color.WHITE);
			      Drop1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			      newStudentPanel.add(Drop1);
			      Drop1.setBounds(160,20,155,20);
			   
			      Drop1.addItemListener(
			 			   new ItemListener()
			 			   {
			 				   public void itemStateChanged(ItemEvent event)
			 				   {
			 					   if(event.getStateChange()==ItemEvent.SELECTED)
			 					   {
			 						   nameAns.setText("");
			 						  idAns.setText("");
			 						  creditAns.setText("");
			 						  semAns.setText("");
			 						   DeptCompare=(String)ComboModel.getElementAt(Drop1.getSelectedIndex());
			 						   StudentModel.removeAllElements();
			 						  for(int i=0; i<studentsAdmin.length; i++)
			 					      {
			 					    	  if(studentsAdmin[i].Department==DeptCompare)StudentModel.addElement(studentsAdmin[i].Name);
			 					      }
			 						  //System.out.println(DeptCompare);
			 					   }
			 				   }
			 			   }
			 			   );
			      
			      b1.addActionListener(new ActionListener(){
			    	  public void actionPerformed(ActionEvent e) {
			    		  System.exit(0);
			    	  }
			      });
			      
			      
			      
			      studentNamelist2.addListSelectionListener(new ListSelectionListener()
			 	   {
			 		   public void valueChanged(ListSelectionEvent event)
			 		   {
			 			   if(studentNamelist2.getSelectedIndex()>=0)
			 			   {  StudCompare=(String)StudentModel.getElementAt(studentNamelist2.getSelectedIndex());
			 			   for(int i=0;i<studentsAdmin.length;i++)
			 			   {
			 				   if(studentsAdmin[i].Name.equals(StudCompare))
			 				   {
			 					   nameAns.setText(studentsAdmin[i].getName());
			 					   idAns.setText(studentsAdmin[i].getID());
			 					   semAns.setText(studentsAdmin[i].getSemester());
			 					   creditAns.setText(studentsAdmin[i].getEmailAddress());
			 				   }
			 			   } }
			 			
			 			   }
			 		   }
			 	    );
			   /*public void actionPerformed(ActionEvent e){
				   
			   };
			   
			   public void windowClosing(WindowEvent e)
			   {
			         //Short_Course_Management.b1.setEnabled(true);
			         //Short_Course_Management.b2.setEnabled(true);
			         //Short_Course_Management.b3.setEnabled(true);
			         this.dispose();
			   }

			  public void windowOpened(WindowEvent e) {}
			  public void windowClosed(WindowEvent e) {}
			  public void windowIconified(WindowEvent e) {}
			  public void windowDeiconified(WindowEvent e) {}
			  public void windowActivated(WindowEvent e) {}
			  public void windowDeactivated(WindowEvent e) {}*/
		}
		
}
	