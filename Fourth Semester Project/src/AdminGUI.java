import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminGUI extends JFrame {
   private JTabbedPane tabbedPane;
   private String course;
   private int season;
   
   Course[] coursesAdmin= new Course[100];
   Faculty [] facultiesAdmin = new Faculty[100];
   
   String deptCompare= new String("CSE");
   
   String courseCompare=new String("");
   
   int delIndex;
   
   String facultyCompare=new String("");

   JPanel tab1Panel     = new JPanel();
   JPanel tab2Panel     = new JPanel();
   JPanel tab3Panel     = new JPanel();
   JPanel tab4Panel     = new JPanel();
   JPanel tab5Panel     = new JPanel();
   JTextField nameEntry = new JTextField();
   JTextField ageEntry  = new JTextField();
   JTextField addEntry  = new JTextField();

   DefaultListModel ListModel1 = new DefaultListModel();
   DefaultListModel ListModel2     = new DefaultListModel();
   
   
   DefaultListModel studentAge       = new DefaultListModel();
   DefaultListModel studentAddress   = new DefaultListModel();
   DefaultListModel isFirstCourse    = new DefaultListModel();
   DefaultListModel enrolledStudents = new DefaultListModel();
   
   DefaultComboBoxModel ComboModel = new DefaultComboBoxModel();

   JList studentNamelist1    = new JList(ListModel1);
   JList assignmentNameList    = new JList(ListModel2);

   JScrollPane scrollstudentNamelist1     = new JScrollPane(studentNamelist1); // course list in courses tab
   JScrollPane scrollassignmentNameList     = new JScrollPane(assignmentNameList); // List of available teachers in allocation tab
   
    AdminGUI(String title, int season, String course, Course[] courses, Faculty []faculties){

      super(title);
      //setLocation(250, 184);
      
      this.course = course;
      this.season = season;

      coursesAdmin=courses;
      facultiesAdmin=faculties;
      
     
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      getContentPane().add(topPanel);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the tab pages
      createPage1();
      createPage2();
	
     
      studentNamelist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      assignmentNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     

      // Create a tabbed pane
      tabbedPane = new JTabbedPane();
      tabbedPane.addTab( "Courses", tab1Panel);
      tabbedPane.addTab( "Allocation", tab2Panel);
      
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
	      
	      JLabel nameLabel   = new JLabel("**Name:");    
	      JLabel idLabel    = new JLabel("**ID:");
	      JLabel deptLabel    = new JLabel("Department:");
	      JLabel semesterLabel    = new JLabel("Semester:");   
	      JLabel creditLabel    = new JLabel("Credit:");   
	      JLabel programmeLabel    = new JLabel("Programme:");   
	      
	      JTextField userText1= new JTextField(20);
	      JTextField userText2= new JTextField(20);
	      JTextField userText3= new JTextField(20);
	      JTextField userText4= new JTextField(20);
	      JTextField userText5= new JTextField(20);
	      JTextField userText6= new JTextField(20);
	      
	      JButton b1              = new JButton("Exit");
	      JButton b2              = new JButton("Add");
	      JButton b3              = new JButton("Delete");
	      JPanel blank            = new JPanel();

	      tab1Panel.       setLayout(null);  
	      newStudentPanel. setLayout(null);
	      courseNamePanel.setLayout(null);
	      blank.setLayout(new GridLayout(4,2));

	      Border loweredEtched;
	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	      tab1Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
	      newStudentPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Add Courses"));         
	      courseNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Courses"));
	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

	 
	      
	      
	      
	      courseNamePanel.add(scrollstudentNamelist1);
	      newStudentPanel. add(nameEntry);
	      
	      
	      
	      newStudentPanel. add(b1);
	      newStudentPanel. add(b2);
	      newStudentPanel. add(b3);

	      newStudentPanel. add(nameLabel);
	      newStudentPanel. add(idLabel);
	      newStudentPanel. add(deptLabel);
	      newStudentPanel. add(creditLabel);
	      newStudentPanel. add(semesterLabel);
	      newStudentPanel. add(programmeLabel);
	      
	      newStudentPanel.add(userText1);
	      newStudentPanel.add(userText2);
	      newStudentPanel.add(userText3);
	      newStudentPanel.add(userText4);
	      newStudentPanel.add(userText5);
	      newStudentPanel.add(userText6);
	      
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
	      
	      userText1.     setBounds(130,40,145,22);
	      userText2.     setBounds(130,70,145,22);
	      userText3.     setBounds(130,100,145,22);
	      userText4.     setBounds(130,130,145,22);
	      userText5.     setBounds(130,160,145,22);
	      userText6.     setBounds(130,190,145,22);
	     
	     
	      
	      b1.     setBounds(172,240,145,22);
	      b2.     setBounds(28,240,72,22);
	      b3.     setBounds(100,240,73,22);
	      nameLabel.setBounds(50,40,145,22);
	      idLabel.setBounds(50,70,145,22);
	      deptLabel.setBounds(50,100,145,22);
	      creditLabel.setBounds(50,130,145,22);
	      semesterLabel.setBounds(50,160,145,22);
	      programmeLabel.setBounds(50,190,145,22);
	      blank.  setBounds(10,220,310,5);
	      
	      
	  	b1.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  System.exit(0);
	    	  }
	      });
	      
	      
	      b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					
					if(userText1.getText().trim().isEmpty() || userText2.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"You must enter at least both the Name and ID to continue. Try again.");
						userText1.setText("");
						userText2.setText("");
						userText3.setText("");
						userText4.setText("");
						userText5.setText("");
						userText6.setText("");
					}
					
					else
					{
						
						ListModel1.addElement(userText1.getText() + "    ID: " +userText2.getText());
						userText1.setText("");
						userText2.setText("");
						userText3.setText("");
						userText4.setText("");
						userText5.setText("");
						userText6.setText("");
						}
					}
					
				}
			
			);
	      
	      b3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					ListModel1.remove(delIndex);
				}
			}
			);
		
		
	
		
		
		 studentNamelist1.addListSelectionListener( new ListSelectionListener(){
		  	  public void valueChanged(ListSelectionEvent event){
		  		  delIndex=studentNamelist1.getSelectedIndex();
		  	  }
		    }
		  		  );

   	}
 
   	public void createPage2(){
   		

 	      JPanel newAssignmentPanel  = new JPanel();
 	      JPanel assignmentNamePanel = new JPanel();
 	      
 	      JRadioButton rb1=new JRadioButton("CSE", true);
 	      JRadioButton rb2=new JRadioButton("MCE", false);
 	      JRadioButton rb3=new JRadioButton("EEE", false);
 	      JRadioButton rb4=new JRadioButton("CEE", false);
 	      
 	      ButtonGroup bg=new ButtonGroup();
 	      bg.add(rb1);
 	      bg.add(rb2);
 	      bg.add(rb3);
 	      bg.add(rb4);
 	      
 	      int counter=0;
 	     for(int i=0; i<coursesAdmin.length; i++)
	      {
	    	  if(coursesAdmin[i].Department=="CSE")
	    	  {
	    		ComboModel.addElement(coursesAdmin[i].getName());
	    		String x = new String();
	    		
	    		x=(String)ComboModel.getElementAt(counter);
	    		counter++;
	    		System.out.println(x);
	    		  
	    	  }
	      }
 	     courseCompare =(String) ComboModel.getElementAt(0);
 	     
 	     counter=0;
 	     for(int i=0; i<facultiesAdmin.length; i++)
 	     {
 	    	 if(facultiesAdmin[i].Department=="CSE")
 	    	 {
 	    		 ListModel2.addElement(facultiesAdmin[i].getName());
 	    		 String x = new String();
	    		
	    		x=(String)ComboModel.getElementAt(counter);
	    		counter++;
	    		System.out.println(x);
 	    	 }
 	     }
 	   
 	      
 	      JLabel nameLabel   = new JLabel("Select Course:");    
 	      
 	      JButton b1              = new JButton("Exit");
 	      JButton b2              = new JButton("Add");
 	      JButton b3			 = new JButton("Show Faculty");
 	      
 	      JPanel blank            = new JPanel();

 	      tab2Panel.       setLayout(null);  
 	      newAssignmentPanel. setLayout(null);
 	      assignmentNamePanel.setLayout(null);
 	      blank.setLayout(new GridLayout(4,2));

 	      Border loweredEtched;
 	      loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
 	      tab2Panel.       setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));
 	      newAssignmentPanel. setBorder(BorderFactory.createTitledBorder(loweredEtched, "Select department and teacher"));         
 	      assignmentNamePanel.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Faculty"));
 	      blank.setBorder(BorderFactory.createTitledBorder(loweredEtched, ""));

 	      
 	      assignmentNamePanel.add(scrollassignmentNameList);
 	      newAssignmentPanel. add(nameEntry);
 	      
 	  //    String []a ={"whatever", "hmm", "Ya", "no"};
	      JComboBox Drop1= new JComboBox(ComboModel);
	      Drop1.setSelectedIndex(0);
	      Drop1.setMaximumRowCount(5);
	      Drop1.setForeground(Color.BLACK);
	      Drop1.setBackground(Color.WHITE);
	      Drop1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      newAssignmentPanel.add(Drop1);
	      Drop1.setBounds(130,100,155,20);
 	      
 	      
 	      newAssignmentPanel. add(b1);
 	      newAssignmentPanel. add(b2);
 	     newAssignmentPanel. add(b3);
 	      newAssignmentPanel. add(rb1);
 	      newAssignmentPanel. add(rb2);
 	      newAssignmentPanel. add(rb3);
 	      newAssignmentPanel. add(rb4);
 	      
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
 	     
 	      
 	      b1.     setBounds(172,240,145,22);
 	      b2.     setBounds(28,240,145,22);
 	   //   b3.     setBounds(87,170,165,22);
 	      rb1.     setBounds(42,24,60,22);
 	      rb2.     setBounds(102,24,60,22);
 	      rb3.     setBounds(162,24,60,22);
 	      rb4.     setBounds(222,24,60,22);
 	   
 	      nameLabel.setBounds(35,100,250,22);
 	      blank.  setBounds(10,220,310,5);
 	      
 	      rb1.addItemListener(new ItemListener() {
 	         public void itemStateChanged(ItemEvent e) {             
 	            if(e.getStateChange()==1)
 	            {
 	            	int counter=0;
 	            	ComboModel.removeAllElements();
 	            	for(int i=0; i<coursesAdmin.length; i++)
 	     	      {
 	     	    	  if(coursesAdmin[i].Department=="CSE")
 	     	    	  {
 	     	    		ComboModel.addElement(coursesAdmin[i].getName());
 	     	    		String x = new String();
 	     	    		
 	     	    		x=(String)ComboModel.getElementAt(counter);
 	     	    		counter++;
 	     	    		System.out.println(x);
 	     	    		  
 	     	    	  }
 	     	      }
 	            	 courseCompare =(String) ComboModel.getElementAt(0);
 	            	
 	         //   	 if(!assignmentNameList.isSelectionEmpty())assignmentNameList.clearSelection();
 	            	counter=0;
 	            	ListModel2.removeAllElements();
 	       	     for(int i=0; i<facultiesAdmin.length; i++)
 	       	     {
 	       	    	 if(facultiesAdmin[i].Department=="CSE")
 	       	    	 {
 	       	    		 ListModel2.addElement(facultiesAdmin[i].getName());
 	       	    		 String x = new String();
 	      	    		
 	      	    		x=(String)ListModel2.getElementAt(counter);
 	      	    		counter++;
 	      	    		System.out.println(x);
 	       	    	 }
 	       	     }
 	       	     System.out.println(ListModel2.getElementAt(0));
 	            }
 	         }           
 	      });
 	      
 	     rb2.addItemListener(new ItemListener() {
 	         public void itemStateChanged(ItemEvent e) {             
 	            if(e.getStateChange()==1)
 	            {
 	            	int counter=0;
 	            	ComboModel.removeAllElements();
 	            	for(int i=0; i<coursesAdmin.length; i++)
 	     	      {
 	     	    	  if(coursesAdmin[i].Department=="MCE")
 	     	    	  {
 	     	    		ComboModel.addElement(coursesAdmin[i].getName());
 	     	    		String x = new String();
 	     	    		
 	     	    		x=(String)ComboModel.getElementAt(counter);
 	     	    		counter++;
 	     	    		System.out.println(x);
 	     	    		  
 	     	    	  }
 	     	      }
 	            	 courseCompare =(String) ComboModel.getElementAt(0);
 	            //	if(!assignmentNameList.isSelectionEmpty())assignmentNameList.clearSelection();
 	            	counter=0;
 	            	ListModel2.removeAllElements();
 	       	     for(int i=0; i<facultiesAdmin.length; i++)
 	       	     {
 	       	    	 if(facultiesAdmin[i].Department=="MCE")
 	       	    	 {
 	       	    		 ListModel2.addElement(facultiesAdmin[i].getName());
 	       	    		 String x = new String();
 	      	    		
 	      	    		x=(String)ListModel2.getElementAt(counter);
 	      	    		counter++;
 	      	    		System.out.println(x);
 	       	    	 }
 	       	     }
 	       	 System.out.println(ListModel2.getElementAt(0));
 	            }
 	            
 	            
 	         }           
 	      });
 	     
 	    rb3.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {             
	            if(e.getStateChange()==1)
	            {
	            	int counter=0;
 	            	ComboModel.removeAllElements();
 	            	for(int i=0; i<coursesAdmin.length; i++)
 	     	      {
 	     	    	  if(coursesAdmin[i].Department=="EEE")
 	     	    	  {
 	     	    		ComboModel.addElement(coursesAdmin[i].getName());
 	     	    		String x = new String();
 	     	    		
 	     	    		x=(String)ComboModel.getElementAt(counter);
 	     	    		counter++;
 	     	    		System.out.println(x);
 	     	    		  
 	     	    	  }
 	     	      }
 	            	 courseCompare =(String) ComboModel.getElementAt(0);
 	            	//if(!assignmentNameList.isSelectionEmpty())assignmentNameList.clearSelection();
 	            	counter=0;
 	            	ListModel2.removeAllElements();
 	       	     for(int i=0; i<facultiesAdmin.length; i++)
 	       	     {
 	       	    	 if(facultiesAdmin[i].Department=="EEE")
 	       	    	 {
 	       	    		 ListModel2.addElement(facultiesAdmin[i].getName());
 	       	    		 String x = new String();
 	      	    		
 	      	    		x=(String)ListModel2.getElementAt(counter);
 	      	    		counter++;
 	      	    		System.out.println(x);
 	       	    	 }
 	       	     }
 	       	 System.out.println(ListModel2.getElementAt(0));
	            }
	         }           
	      });
 	    
 	   rb4.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {             
	            if(e.getStateChange()==1)
	            {
	            	int counter=0;
 	            	ComboModel.removeAllElements();
 	            	for(int i=0; i<coursesAdmin.length; i++)
 	     	      {
 	     	    	  if(coursesAdmin[i].Department=="CEE")
 	     	    	  {
 	     	    		ComboModel.addElement(coursesAdmin[i].getName());
 	     	    		String x = new String();
 	     	    		
 	     	    		x=(String)ComboModel.getElementAt(counter);
 	     	    		counter++;
 	     	    		System.out.println(x);
 	     	    		  
 	     	    	  }
 	     	      }
 	            	 courseCompare =(String) ComboModel.getElementAt(0);
 	            	//if(!assignmentNameList.isSelectionEmpty())assignmentNameList.clearSelection();
 	            	counter=0;
 	            	ListModel2.removeAllElements();
 	       	     for(int i=0; i<facultiesAdmin.length; i++)
 	       	     {
 	       	    	 if(facultiesAdmin[i].Department=="CEE")
 	       	    	 {
 	       	    		 ListModel2.addElement(facultiesAdmin[i].getName());
 	       	    		 String x = new String();
 	      	    		
 	      	    		x=(String)ListModel2.getElementAt(counter);
 	      	    		counter++;
 	      	    		System.out.println(x);
 	       	    	 }
 	       	     }
 	       	 System.out.println(ListModel2.getElementAt(0));
	            }
	         }           
	      });
 	   
 /*	   Drop1.addItemListener(new ItemListener()
 			   {
 		   			public void itemStateChanged(ItemEvent event)
 		   			{
 		   				//if(event.getStateChange()==ItemEvent.SELECTED)
 		   			}
 			   });*/
 	   
 	   Drop1.addItemListener(
 			   new ItemListener()
 			   {
 				   public void itemStateChanged(ItemEvent event)
 				   {
 					   if(event.getStateChange()==ItemEvent.SELECTED)
 					   {
 						   courseCompare=(String)ComboModel.getElementAt(Drop1.getSelectedIndex());
 						  System.out.println(courseCompare);
 					   }
 				   }
 			   }
 			   );
 	   
 	  assignmentNameList.addListSelectionListener(new ListSelectionListener()
 	   {
 		   public void valueChanged(ListSelectionEvent event)
 		   {
 			   if(assignmentNameList.getSelectedIndex()>=0)
 			   {	  System.out.println(assignmentNameList.getSelectedIndex());
 			   facultyCompare=(String)ListModel2.getElementAt(assignmentNameList.getSelectedIndex());
 			  System.out.println(assignmentNameList.getSelectedIndex());
 			   }
 		   }
 	   } );
   	
   	
   	
   	b2.addActionListener(new ActionListener()
   			{
   				public void actionPerformed(ActionEvent event)
   				{
   					for(int i=0;i<coursesAdmin.length;i++)
   					{
   						if(courseCompare==coursesAdmin[i].getName())
   						{
   							coursesAdmin[i].setCourseFaculty(facultyCompare);
   							System.out.println(coursesAdmin[i].getCourseFaculty());
   							JOptionPane.showMessageDialog(null,facultyCompare+" has been succesfully added to "+courseCompare);
   						}
   					}
   				}
   			}
   			);
   	b1.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
  		  System.exit(0);
  	  }
    });
   
   	
   	}	/*public static void main(String[] args){
			AdminGUI ggg=new AdminGUI("Title", 34, "BOY");
			
		}*/
}