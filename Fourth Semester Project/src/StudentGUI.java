import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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



public class StudentGUI extends JFrame {
	private JTabbedPane tabbedPane;
   private String course;
   private int season;
   
   String pqr="http://www.wikipedia.com";
   String xyz="http://www.wikipedia.com";
   Course[] coursesAdmin= new Course[100];
   
   private JLabel nameAns= new JLabel("");
   private JLabel idAns= new JLabel("");
   private JLabel deptAns= new JLabel("");
   private JLabel creditAns= new JLabel("");
   
   String n = new String("zzzz");
   String i = new String("sss");
   String d = new String("");
   String c = new String("");
   
   String Compare = new String("");
   
   String CourseCompare1;
   String CourseCompare2;
   
   JPanel tab1Panel     = new JPanel();
   JPanel tab2Panel     = new JPanel();
   JPanel tab3Panel     = new JPanel();
   JPanel tab4Panel     = new JPanel();
   JPanel tab5Panel     = new JPanel();
   JTextField nameEntry = new JTextField();
   JTextField ageEntry  = new JTextField();
   JTextField addEntry  = new JTextField();
  

   DefaultListModel Courses= new DefaultListModel();
   DefaultListModel EnrolledCourses=new DefaultListModel();
   DefaultListModel SelectedCourses     = new DefaultListModel();
   DefaultListModel Assignments= new DefaultListModel();
   DefaultListModel Material= new DefaultListModel();
   /*DefaultListModel studentAddress   = new DefaultListModel();
   DefaultListModel isFirstCourse    = new DefaultListModel();
   DefaultListModel enrolledStudents = new DefaultListModel();*/
  
   String [] studentName= {"sadaf" , "labib", "irtiza"};
  // String[] SelectedCourses = new String[100];
   
   JList studentNamelist1    = new JList(SelectedCourses );
   JList studentNamelist2    = new JList(Courses); //AVAILABLE COURSE LIST
   JList assignmentNameList    = new JList(Assignments); //ASSIGNMENT LIST
   JList materialsNameList    = new JList(Material);
   JList quizNameList    = new JList(studentName);
   JList enrolledStudentlist = new JList(EnrolledCourses); //SELECTED COURSE LIST

   JScrollPane scrollstudentNamelist1     = new JScrollPane(studentNamelist1);
   JScrollPane scrollstudentNamelist2     = new JScrollPane(studentNamelist2);
   JScrollPane scrollassignmentNameList     = new JScrollPane(assignmentNameList);
   JScrollPane scrollQuizNameList     = new JScrollPane(quizNameList);
   JScrollPane scrollMaterialsNameList     = new JScrollPane(materialsNameList);
   JScrollPane scrollEnrolledStudentslist = new JScrollPane(enrolledStudentlist);
    
   public StudentGUI(String title, int season, String course, Course[] courses){
	   super(title);
	   
	  //setLocation(250, 184);
	 
	   coursesAdmin=courses;
     
      this.course = course;
      this.season = season;

      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      getContentPane().add(topPanel);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the tab pages
      createPage1();
      try {
		createPage2();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      try {
		createPage3();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      try {
		createPage4();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
      tabbedPane.addTab( "Enrollment", tab5Panel);
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
	      newStudentPanel. add(nameEntry);
	      
	      
	      
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
 
   	public void createPage2() throws URISyntaxException{
   		
 	      JPanel newAssignmentPanel  = new JPanel();
 	      JPanel assignmentNamePanel = new JPanel();
 	      
 	      JLabel nameLabel   = new JLabel("Go to the link below to see the assignment.");    
 	      
 	      JButton b1              = new JButton("Exit");
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

 	      
 	     for(int i=0; i<coursesAdmin.length; i++)
 	     {
 	    	 for(int j=0; j<2;j++)
 	    	 {
 	    		Assignments.addElement(coursesAdmin[i].Assignment[j]);   
 	    	 }	   
 	     }
 	     
 	    
 	    
 	    
 	    
 	      
 	      
 	      assignmentNamePanel.add(scrollassignmentNameList);
 	      newAssignmentPanel. add(nameEntry);
 	      
 	      
 	      
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
 	      nameLabel.setBounds(35,40,250,22);
 	      blank.  setBounds(10,200,310,5);
 	      
 	     JButton LinkButton1 =new JButton();
  		LinkButton1.setText("<HTML>Click this <FONT color=\"#000099\"><U>button</U></FONT>"
  		        + "</HTML>");
 	     newAssignmentPanel.add(LinkButton1);
 	    LinkButton1.setBounds(70, 100, 175, 35);
 	    
 		 /*final URI uri = new URI(pqr);
 		 class OpenUrlAction implements ActionListener {
 		      @Override public void actionPerformed(ActionEvent e) {
 		        open(uri);
 		      }
 		 }
 		JButton LinkButton1 =new JButton();
 		LinkButton1.setText("<HTML>Click this <FONT color=\"#000099\"><U>button</U></FONT>"
 		        + "</HTML>");
 		//LinkButton1.addActionListener(new OpenUrlAction());
 		
 		   */
 	    
 	    
 	    
 	/*   if (! event.getValueIsAdjusting())
		  {
			 if (! assignmentNameList.isSelectionEmpty())assignmentNameList.clearSelection();
		  }*/
 		
 		
 		assignmentNameList.addListSelectionListener( new ListSelectionListener(){
	    	  public void valueChanged(ListSelectionEvent event){
	    		 
	    		  
	    		  if((assignmentNameList.getSelectedIndex()%2)==0)
	    		  {
	    			  pqr=coursesAdmin[0].Link[0];
	    		  }  
	    		  
	    		  else
	    		  {  		
	    			 pqr=coursesAdmin[0].Link[1];
	    			  
	    			  System.out.println("Hmm");
	    		  }
	    	  }
	    		  
	    		  }
 		
	    		  );
 		
 		
 		
		  
		
		  LinkButton1.addActionListener(new ActionListener()
				  {
			  				
			  				public void actionPerformed(ActionEvent e) {
			  					final URI uri=URI.create(pqr);
			  						open(uri);
			  				}
				  }
		  
				  );
				  
		  b1.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  System.exit(0);
	    	  }
	      });
 		
 		
   	}

   	public void createPage3() throws URISyntaxException{
   	

   		JPanel newQuizPanel  = new JPanel();
	      JPanel quizNamePanel = new JPanel();
	      
	      JLabel nameLabel   = new JLabel("Go to the link below to see the quiz document.");    
	      
	      JButton b1              = new JButton("Exit");
	      JPanel blank            = new JPanel();

  	      tab3Panel.       setLayout(null);  
  	      newQuizPanel. setLayout(null);
  	      quizNamePanel.setLayout(null);
  	      blank.setLayout(new GridLayout(4,2));

  	      Border loweredEtched;
  	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
  	      tab3Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
  	      newQuizPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Quiz Details"));         
  	      quizNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Quizzes"));
  	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

  	      
  	      quizNamePanel.add(scrollQuizNameList);
  	      newQuizPanel. add(nameEntry);
  	      
  	      
  	      
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
  	      nameLabel.setBounds(30,40,300,22);
  	      
  	      blank.  setBounds(10,200,310,5);
  	      
  	    String pqr="http://www.wikipedia.com";
 		final URI uri = new URI(pqr);
 		 class OpenUrlAction implements ActionListener {
 		      @Override public void actionPerformed(ActionEvent e) {
 		        open(uri);
 		      }
 		 }
 		JButton LinkButton2 =new JButton();
 		LinkButton2.setText("<HTML>Click this <FONT color=\"#000099\"><U>button</U></FONT>"
 		        + "</HTML>");
 		LinkButton2.addActionListener(new OpenUrlAction());
 		newQuizPanel.add(LinkButton2);
 		LinkButton2.setBounds(70, 100, 175, 35);   
	   
	}
	
	public void createPage4() throws URISyntaxException{
		
	
			JPanel newMaterialPanel  = new JPanel();
			JPanel materialNamePanel= new JPanel();
			
			JLabel nameLabel   = new JLabel("Go to the link below to see the materials.");    
	      
			JButton b1              = new JButton("Exit");
			JPanel blank            = new JPanel();

	  	      tab4Panel.       setLayout(null);  
	  	      newMaterialPanel. setLayout(null);
	  	      materialNamePanel.setLayout(null);
	  	      blank.setLayout(new GridLayout(4,2));

	  	      Border loweredEtched;
	  	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	  	      tab4Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
	  	      newMaterialPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Materials Details"));         
	  	      materialNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Materials"));
	  	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

	  	    for(int i=0; i<coursesAdmin.length; i++)
	 	     {
	 	    	 for(int j=0; j<2;j++)
	 	    	 {
	 	    		Material.addElement(coursesAdmin[i].Materials[j]);   
	 	    	 }	   
	 	     }
	  	      
	  	      materialNamePanel.add(scrollMaterialsNameList);
	  	      newMaterialPanel. add(nameEntry);
	  	      
	  	      
	  	      
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
	  	      nameLabel.setBounds(50,40,250,22);
	  	      blank.  setBounds(10,200,310,5);
	  	 
	  	  
	 	
	 		JButton LinkButton3 =new JButton();
	 		LinkButton3.setText("<HTML>Click this <FONT color=\"#000099\"><U>button</U></FONT>"
	 		        + "</HTML>");
	 		
	 	   newMaterialPanel.add(LinkButton3);
	 		LinkButton3.setBounds(70, 100, 175, 35);
	 		
	 		materialsNameList.addListSelectionListener( new ListSelectionListener(){
		    	  public void valueChanged(ListSelectionEvent event){
		    		 
		    		  
		    		  if((materialsNameList.getSelectedIndex()%2)==0)
		    		  {
		    			  xyz=coursesAdmin[0].Link[0];
		    		  }  
		    		  
		    		  else
		    		  {  		
		    			 xyz=coursesAdmin[0].Link[1];
		    			  
		    			  System.out.println("Hmm");
		    		  }
		    	  }
		    		  
		    		  }
	 		
		    		  );
	  	      
	 		
	 		 LinkButton3.addActionListener(new ActionListener()
			  {
		  				
		  				public void actionPerformed(ActionEvent e) {
		  					final URI uri=URI.create(xyz);
		  						open(uri);
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

			
				for(int i=0;i<coursesAdmin.length;i++)
				{
					Courses.addElement(coursesAdmin[i].Name);
				}
			
			
			      JPanel studentNamePanel = new JPanel();
			      JPanel enrolledStudentPanel = new JPanel();
			      JLabel l1  = new JLabel("Season "+ this.season + ": "+ this.course);
			      JButton b1 = new JButton("Add to course >");
			      JButton b2 = new JButton("<html><center>"+"Remove from"+"<br>"+"course ..."+
			                                                               "</center></html>");
			      JButton b3 = new JButton("Exit");
			      JButton b4 = new JButton("OK");

			      tab5Panel.           setLayout(null);  
			      studentNamePanel.    setLayout(null);
			      enrolledStudentPanel.setLayout(null);
			      Border loweredEtched;
			      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			      tab5Panel.           setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
			      studentNamePanel.    setBorder(BorderFactory.createTitledBorder(loweredEtched, 
			                                                               "Courses"));
			      enrolledStudentPanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, 
			                                                                    "Enrolled courses"));

			      studentNamePanel.    add(scrollstudentNamelist2);
			      enrolledStudentPanel.add(scrollEnrolledStudentslist);
			      tab5Panel.           add(studentNamePanel);
			      tab5Panel.           add(enrolledStudentPanel);
			      studentNamePanel.    add(b1);
			      studentNamePanel.    add(b2);
			      studentNamePanel.    add(b3);
			//      tab5Panel.           add(l1);
			     // studentNamePanel.    add(b4);
			      /*b1.addActionListener(this);     
			      b2.addActionListener(this);     
			      b3.addActionListener(this);     
			      b4.addActionListener(this); */

			      scrollstudentNamelist2.    setBounds(10,20,155,275);
			      scrollEnrolledStudentslist.setBounds(10,20,155,275);
			      studentNamePanel.          setBounds(5,30,330,305);
			      enrolledStudentPanel.      setBounds(335,30,175,305);
			      l1.setBounds(180,10,250,20);
			      b1.setBounds(172,20,145,22);
			      b2.setBounds(172,50,145,40);
			      b3.setBounds(172,272,138,22);
			      b4.setBounds(260,272,58,22);
			      l1.setForeground(Color.red);
			      b2.setActionCommand("Remove from course");
			   
			      studentNamelist2.addListSelectionListener( new ListSelectionListener(){
			    	  public void valueChanged(ListSelectionEvent event){
			    		  if(studentNamelist2.getSelectedIndex()>=0)
			    		 CourseCompare1= (String) Courses.getElementAt(studentNamelist2.getSelectedIndex());
			    	  }
			      }
			    		  );
			      
			      enrolledStudentlist.addListSelectionListener( new ListSelectionListener(){
			    	  public void valueChanged(ListSelectionEvent event){
			    		  if(enrolledStudentlist.getSelectedIndex()>=0)
					    	CourseCompare2= (String) EnrolledCourses.getElementAt(enrolledStudentlist.getSelectedIndex());
			    	  }
			      }
			    		  );
			      
			      b1.addActionListener(new ActionListener()
			    		  {
			    	  public void actionPerformed(ActionEvent e)
			    	  {
			    		  if(!EnrolledCourses.contains(CourseCompare1))
			    		  {EnrolledCourses.addElement(CourseCompare1);}
			    		 // studentNamelist2.clearSelection();
			    		  Courses.removeElement(CourseCompare1);
			    		  CourseCompare1=null;
			    	  }

			    		  });
			      
			      b2.addActionListener(new ActionListener()
	    		  {
			    	  public void actionPerformed(ActionEvent e)
			    	  	{
			    		  if(!Courses.contains(CourseCompare2))
			    		  {Courses.addElement(CourseCompare2);}
				    		 // studentNamelist2.clearSelection();
			    		  EnrolledCourses.removeElement(CourseCompare2);
			    		  CourseCompare2=null;
	    		  		}
	    	  });
			      
			      b3.addActionListener(new ActionListener(){
			    	  public void actionPerformed(ActionEvent e) {
			    		  System.exit(0);
			    	  }
			      });
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
		private static void open(URI uri) {
		    if (Desktop.isDesktopSupported()) {
		      try {
		        Desktop.getDesktop().browse(uri);
		      } catch (IOException e) { /* TODO: error handling */ }
		    } else { /* TODO: error handling */ }
		  }
}
	