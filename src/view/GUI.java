package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.CourseController;
import exceptions.CourseExceptions;
import model.Course;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;

public class GUI {

	private JFrame frame;
	private JTextField txtspnr;
	private JTextField txtsname;
	private JTextField txtsaddress;
	private JTextField txtcCode;
	private JTextField txtcName;
	private JTextField txtcCredits;
	private JTextField txtspnrreg;
	private JTable tblstudent;
	private JTable tblgrade;
	private JTable tblastudyingcourse;
	private JTable tblafinishedwithcourse;
	private JTable tblpercentofA;
	private JTable tblflow;
	private JTable tblcourse;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 843, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblmsgcourse = new JLabel("Message:");
		lblmsgcourse.setBounds(430, 172, 287, 14);
		frame.getContentPane().add(lblmsgcourse);
		
		JLabel lblmsgstudent = new JLabel("Message:");
		lblmsgstudent.setBounds(10, 172, 232, 14);
		frame.getContentPane().add(lblmsgstudent);
		
		JLabel lblStudentPnr = new JLabel("Student ID");
		lblStudentPnr.setBounds(10, 11, 97, 14);
		frame.getContentPane().add(lblStudentPnr);
		
		txtspnr = new JTextField();
		txtspnr.setBounds(117, 8, 159, 20);
		frame.getContentPane().add(txtspnr);
		txtspnr.setColumns(10);
		
		tblcourse = new JTable();
		tblcourse.setBounds(412, 209, 375, 20);
		frame.getContentPane().add(tblcourse);
		
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 36, 97, 14);
		frame.getContentPane().add(lblStudentName);
		
		txtsname = new JTextField();
		txtsname.setBounds(117, 33, 159, 20);
		frame.getContentPane().add(txtsname);
		txtsname.setColumns(10);
		
		JLabel lblStudentAddress = new JLabel("Student Address");
		lblStudentAddress.setBounds(10, 61, 97, 14);
		frame.getContentPane().add(lblStudentAddress);
		
		txtsaddress = new JTextField();
		txtsaddress.setBounds(117, 58, 159, 20);
		frame.getContentPane().add(txtsaddress);
		txtsaddress.setColumns(10);
		
		JButton btnRegisterStudent = new JButton("Register Student");
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spnr = txtspnr.getText();
				String sname = txtsname.getText();
				String saddress = txtsaddress.getText();
				String msg = "";
				msg = StudentView.addStudent(spnr, sname, saddress);
				lblmsgstudent.setText(msg);
				
			}
		});
		btnRegisterStudent.setBounds(10, 103, 133, 23);
		frame.getContentPane().add(btnRegisterStudent);
		
		JButton btnSearchStudentn = new JButton("Search Student");
		btnSearchStudentn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchStudentn.setBounds(153, 103, 133, 23);
		frame.getContentPane().add(btnSearchStudentn);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spnr = txtspnr.getText();
				String msg = "";
				msg = StudentView.deleteStudent(spnr);
				lblmsgstudent.setText(msg);
				
			}
		});
		btnDeleteStudent.setBounds(75, 137, 123, 23);
		frame.getContentPane().add(btnDeleteStudent);
		
		txtcCode = new JTextField();
		txtcCode.setBounds(513, 8, 178, 20);
		frame.getContentPane().add(txtcCode);
		txtcCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Course Code");
		lblNewLabel.setBounds(412, 11, 87, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(412, 36, 87, 14);
		frame.getContentPane().add(lblCourseName);
		
		txtcName = new JTextField();
		txtcName.setBounds(513, 33, 178, 20);
		frame.getContentPane().add(txtcName);
		txtcName.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(412, 61, 77, 14);
		frame.getContentPane().add(lblCredits);
		
		txtcCredits = new JTextField();
		txtcCredits.setBounds(513, 58, 178, 20);
		frame.getContentPane().add(txtcCredits);
		txtcCredits.setColumns(10);
		
		JButton btnRegisterCourse = new JButton("Register Course");
		btnRegisterCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				String ccode = txtcCode.getText();
				String cname = txtcName.getText();
				String creditsString = txtcCredits.getText();
				int credits = Integer.parseInt(creditsString);
				String msg = "";
				msg = CourseView.addCourse(ccode,cname,credits);
				lblmsgcourse.setText(msg);
				
				
				 
			}
		});
		btnRegisterCourse.setBounds(430, 103, 144, 23);
		frame.getContentPane().add(btnRegisterCourse);
		
		JButton btnSearchCourse = new JButton("Search Course");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccode = txtcCode.getText();
				String cname = txtcName.getText();
				String creditsString = txtcCredits.getText();
				int credits = Integer.parseInt(creditsString);
				String msg = "";
				msg = CourseView.addCourse(ccode,cname,credits);
				lblmsgcourse.setText(msg);
				
			}
		});
		btnSearchCourse.setBounds(584, 103, 133, 23);
		frame.getContentPane().add(btnSearchCourse);
		
		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccode = txtcCode.getText();
				String msg = "";
				msg = CourseView.deleteCourse(ccode);
				lblmsgcourse.setText(msg);
			}
		});
		btnDeleteCourse.setBounds(526, 137, 123, 23);
		frame.getContentPane().add(btnDeleteCourse);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(10, 282, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtspnrreg = new JTextField();
		txtspnrreg.setBounds(117, 276, 230, 23);
		frame.getContentPane().add(txtspnrreg);
		txtspnrreg.setColumns(10);
		
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setBounds(10, 307, 87, 14);
		frame.getContentPane().add(lblSelectCourse);
		

/**		.add(new JScrollPane())
		String studentList[] = new String[] {
				"Student ID", "Name", "Address" 
		};
//// FIX THIS PLEASE. Måste kolla på hur detta fungerar.
		DefaultTableModel model1 = new DefaultTableModel();	
		tblstudent = new JTable(model1);
		JScrollPane jpane = new JScrollPane(tblstudent);
		
		
	model1.setColumnIdentifiers(studentList); 
	tblstudent.setBounds(25, 196, 322, 47);
		frame.getContentPane().add(tblstudent);  **/
		
		JComboBox cmbcourse = new JComboBox();
		cmbcourse.setBounds(117, 304, 230, 28);
		frame.getContentPane().add(cmbcourse);
		try {
			for (Course c : CourseController.ReadAllCourses()) {
				cmbcourse.addItem(c.getCcode() + ", " + c.getCname());
			}
		} catch (CourseExceptions e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
		JRadioButton rdbtnregstudent = new JRadioButton("Register student on course");
		rdbtnregstudent.setBounds(6, 339, 209, 23);
		frame.getContentPane().add(rdbtnregstudent);
		
		JRadioButton rdbtnremovestudentfrcourse = new JRadioButton("Remove student from course");
		rdbtnremovestudentfrcourse.setBounds(6, 365, 209, 23);
		frame.getContentPane().add(rdbtnremovestudentfrcourse);
		
		JRadioButton rdbtnregonstudied = new JRadioButton("Register finished student");
		rdbtnregonstudied.setBounds(6, 391, 209, 23);
		frame.getContentPane().add(rdbtnregonstudied);
		
		JComboBox cmbgrade = new JComboBox();
		cmbgrade.setBounds(309, 392, 38, 20);
		frame.getContentPane().add(cmbgrade);
		
		JLabel lblFillInGrade = new JLabel("Fill in grade");
		lblFillInGrade.setBounds(225, 395, 122, 14);
		frame.getContentPane().add(lblFillInGrade);
		
		JRadioButton rdbtnShowStudentsResult = new JRadioButton("Show students result");
		rdbtnShowStudentsResult.setBounds(6, 417, 188, 23);
		frame.getContentPane().add(rdbtnShowStudentsResult);
		
		tblgrade = new JTable();
		tblgrade.setBounds(270, 421, 77, 23);
		frame.getContentPane().add(tblgrade);
		
		JLabel lblStudentsGrade = new JLabel("Grade:");
		lblStudentsGrade.setBounds(225, 426, 80, 14);
		frame.getContentPane().add(lblStudentsGrade);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(147, 462, 97, 23);
		frame.getContentPane().add(btnApply);
		
		tblastudyingcourse = new JTable();
		tblastudyingcourse.setBounds(412, 282, 162, 152);
		frame.getContentPane().add(tblastudyingcourse);
		
		JLabel lblStudentsStudyingThis = new JLabel("Students studying this course");
		lblStudentsStudyingThis.setBounds(414, 246, 178, 14);
		frame.getContentPane().add(lblStudentsStudyingThis);
		
		tblafinishedwithcourse = new JTable();
		tblafinishedwithcourse.setBounds(618, 282, 169, 152);
		frame.getContentPane().add(tblafinishedwithcourse);
		
		JLabel lblStudentsFinishedWith = new JLabel("Students finished with this course");
		lblStudentsFinishedWith.setBounds(621, 246, 196, 14);
		frame.getContentPane().add(lblStudentsFinishedWith);
		
		JLabel lblPercentWi = new JLabel("Percent with highest grade");
		lblPercentWi.setBounds(490, 442, 159, 14);
		frame.getContentPane().add(lblPercentWi);
		
		tblpercentofA = new JTable();
		tblpercentofA.setBounds(659, 442, 62, 14);
		frame.getContentPane().add(tblpercentofA);
		
		JButton btnCourseWithHighest = new JButton("Course with highest passed quota  ");
		btnCourseWithHighest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCourseWithHighest.setBounds(430, 498, 239, 23);
		frame.getContentPane().add(btnCourseWithHighest);
		
		tblflow = new JTable();
		tblflow.setBounds(430, 532, 270, 23);
		frame.getContentPane().add(tblflow);
		
		
		
	}
}
	

