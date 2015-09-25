package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAL.ShareAccess;
import controller.CourseController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
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
import javax.swing.ButtonGroup;

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
	private DefaultTableModel tablemodelstudents;
	private JTable table;
	private JTable tabelstudent;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 276, 401, 271);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblmsgcourse = new JLabel("Message:");
		lblmsgcourse.setBounds(430, 172, 287, 14);
		frame.getContentPane().add(lblmsgcourse);

		tblcourse = new JTable();
		tblcourse.setBounds(412, 209, 375, 20);
		frame.getContentPane().add(tblcourse);

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
				msg = CourseView.addCourse(ccode, cname, credits);
				lblmsgcourse.setText(msg);

			}
		});
		
		JComboBox cmbcourse = new JComboBox();
		cmbcourse.setBounds(117, 41, 230, 28);
		panel_1.add(cmbcourse);
		
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
				msg = CourseView.addCourse(ccode, cname, credits);
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
		
		
		
		
		
		ButtonGroup buttongroup = new ButtonGroup();

		tblgrade = new JTable();
		tblgrade.setBounds(270, 421, 77, 23);
		frame.getContentPane().add(tblgrade);
		
		

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

		JPanel panelstudent = new JPanel();
		panelstudent.setBounds(0, 0, 402, 271);
		frame.getContentPane().add(panelstudent);
		panelstudent.setLayout(null);

		JButton btnSearchStudentn = new JButton("Search Student");
		btnSearchStudentn.setBounds(86, 116, 107, 23);
		panelstudent.add(btnSearchStudentn);
		btnSearchStudentn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String spnr = txtspnr.getText(); 
				try {
					
					StudentView.getStudent(spnr);
					
				}catch(StudentExceptions e1) {
					
				}
			}
		});

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 37, 68, 14);
		panelstudent.add(lblStudentName);

		JLabel lblStudentAddress = new JLabel("StudentiAddress");
		lblStudentAddress.setBounds(10, 65, 80, 14);
		panelstudent.add(lblStudentAddress);
		
		JLabel lblmsgstudent = new JLabel("Message:");
		lblmsgstudent.setBounds(10, 100, 46, 14);
		panelstudent.add(lblmsgstudent);

		JButton btnRegisterStudent = new JButton("Register Student");
		btnRegisterStudent.setBounds(210, 116, 113, 23);
		panelstudent.add(btnRegisterStudent);
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spnr = txtspnr.getText();
				String sname = txtsname.getText();
				String saddress = txtsaddress.getText();
				String msg = "";

				try {
					msg = StudentView.addStudent(spnr, sname, saddress);
				} catch (StudentExceptions e1) {
					msg = e1.getMessage();
					lblmsgstudent.setText(msg);
				}

				lblmsgstudent.setText(msg);

			}
		});

		JLabel lblStudentPnr = new JLabel("Student ID");
		lblStudentPnr.setBounds(10, 9, 52, 14);
		panelstudent.add(lblStudentPnr);

		

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(145, 150, 105, 23);
		panelstudent.add(btnDeleteStudent);
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spnr = txtspnr.getText();
				String msg = "";
				msg = StudentView.deleteStudent(spnr);
				lblmsgstudent.setText(msg);

			}
		});

		txtsaddress = new JTextField();
		txtsaddress.setBounds(103, 62, 159, 20);
		panelstudent.add(txtsaddress);
		txtsaddress.setColumns(10);

		txtspnr = new JTextField();
		txtspnr.setBounds(103, 6, 159, 20);
		panelstudent.add(txtspnr);
		txtspnr.setColumns(10);

		txtsname = new JTextField();
		txtsname.setBounds(103, 34, 159, 20);
		panelstudent.add(txtsname);
		txtsname.setColumns(10);

		JScrollPane scrollStudent = new JScrollPane();
		scrollStudent.setBounds(37, 185, 286, 57);
		panelstudent.add(scrollStudent);
		
		String[] headerStudents = { "Student ID", "Name", "Address" };
		tablemodelstudents = new DefaultTableModel(headerStudents, 3);
		

		tabelstudent = new JTable(tablemodelstudents);
		scrollStudent.setViewportView(tabelstudent);
		



		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(10, 11, 97, 14);
		panel_1.add(lblNewLabel_1);

		txtspnrreg = new JTextField();
		txtspnrreg.setBounds(117, 7, 230, 23);
		panel_1.add(txtspnrreg);
		txtspnrreg.setColumns(10);

		

		JRadioButton rdbtnregstudent = new JRadioButton("Register student on course");
		rdbtnregstudent.setBounds(10, 78, 209, 23);
		panel_1.add(rdbtnregstudent);
		buttongroup.add(rdbtnregstudent);

		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setBounds(10, 48, 87, 14);
		panel_1.add(lblSelectCourse);

		JRadioButton rdbtnShowStudentsResult = new JRadioButton("Show students result");
		rdbtnShowStudentsResult.setBounds(10, 156, 188, 23);
		panel_1.add(rdbtnShowStudentsResult);
		buttongroup.add(rdbtnShowStudentsResult);

		

		JRadioButton rdbtnremovestudentfrcourse = new JRadioButton("Remove student from course");
		rdbtnremovestudentfrcourse.setBounds(10, 104, 209, 23);
		panel_1.add(rdbtnremovestudentfrcourse);
		buttongroup.add(rdbtnremovestudentfrcourse);

		JLabel lblFillInGrade = new JLabel("Fill in grade");
		lblFillInGrade.setBounds(225, 134, 122, 14);
		panel_1.add(lblFillInGrade);

		JLabel lblStudentsGrade = new JLabel("Grade:");
		lblStudentsGrade.setBounds(225, 160, 80, 14);
		panel_1.add(lblStudentsGrade);

		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(145, 194, 97, 23);
		panel_1.add(btnApply);


		JComboBox cmbgrade = new JComboBox();
		cmbgrade.setBounds(302, 131, 38, 20);
		panel_1.add(cmbgrade);
		cmbgrade.setEnabled(false);
		cmbgrade.addItem("A");
		cmbgrade.addItem("B");
		cmbgrade.addItem("C");
		cmbgrade.addItem("D");
		cmbgrade.addItem("E");
		cmbgrade.addItem("U");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccode = (String) cmbcourse.getSelectedItem();
				String spnr = txtspnr.getText();
				String msg = "";
				DefaultTableModel dtm = new DefaultTableModel();
				tblgrade.setModel(dtm);
				if (rdbtnShowStudentsResult.isSelected()) {
					try {
						msg = ShareAccess.getResult(spnr, ccode).getsGrade();
						// dtm.ad;
					} catch (StudentExceptions e1) {

					}
					lblmsgstudent.setText(msg);

				}

			}
		});
		
		btnDeleteCourse.setBounds(526, 137, 123, 23);
		frame.getContentPane().add(btnDeleteCourse);
		try {
			for (Course c : CourseController.ReadAllCourses()) {
				cmbcourse.addItem(c.getCcode());
				
				
			}
		} catch (CourseExceptions e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	

	}
}
