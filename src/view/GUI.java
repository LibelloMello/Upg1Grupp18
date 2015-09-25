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
		
		JComboBox cmbcourse = new JComboBox();
		cmbcourse.setBounds(117, 41, 230, 28);
		panel_1.add(cmbcourse);
		
		
		
		
		
		ButtonGroup buttongroup = new ButtonGroup();

		JPanel panelstudent = new JPanel();
		panelstudent.setBounds(0, 0, 402, 271);
		frame.getContentPane().add(panelstudent);
		panelstudent.setLayout(null);
		
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

		JButton btnSearchStudentn = new JButton("Search Student");
		btnSearchStudentn.setBounds(86, 116, 107, 23);
		panelstudent.add(btnSearchStudentn);
		btnSearchStudentn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String spnr = txtspnr.getText(); 
				try {
					tablemodelstudents.addRow(StudentView.getStudent(spnr));
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
/**
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
**/
		

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
		
				tblgrade = new JTable();
				tblgrade.setBounds(270, 160, 77, 23);
				panel_1.add(tblgrade);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(398, 0, 429, 582);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
				txtcCode = new JTextField();
				txtcCode.setBounds(108, 11, 178, 20);
				panel.add(txtcCode);
				txtcCode.setColumns(10);
				
						txtcName = new JTextField();
						txtcName.setBounds(108, 42, 178, 20);
						panel.add(txtcName);
						txtcName.setColumns(10);
						
								txtcCredits = new JTextField();
								txtcCredits.setBounds(108, 69, 178, 20);
								panel.add(txtcCredits);
								txtcCredits.setColumns(10);
								
										JLabel lblNewLabel = new JLabel("Course Code");
										lblNewLabel.setBounds(11, 14, 87, 14);
										panel.add(lblNewLabel);
										
												JLabel lblCourseName = new JLabel("Course Name");
												lblCourseName.setBounds(11, 45, 87, 14);
												panel.add(lblCourseName);
												
														JLabel lblCredits = new JLabel("Credits");
														lblCredits.setBounds(11, 72, 77, 14);
														panel.add(lblCredits);
														
														

														JButton btnRegisterCourse = new JButton("Register Course");
														btnRegisterCourse.setBounds(36, 100, 144, 23);
														panel.add(btnRegisterCourse);
														
																JButton btnSearchCourse = new JButton("Search Course");
																btnSearchCourse.setBounds(190, 100, 133, 23);
																panel.add(btnSearchCourse);
																
																		JButton btnDeleteCourse = new JButton("Delete Course");
																		btnDeleteCourse.setBounds(126, 134, 123, 23);
																		panel.add(btnDeleteCourse);
																		
																				JLabel lblmsgcourse = new JLabel("Message:");
																				lblmsgcourse.setBounds(36, 168, 287, 14);
																				panel.add(lblmsgcourse);
																				
																						tblcourse = new JTable();
																						tblcourse.setBounds(11, 197, 375, 20);
																						panel.add(tblcourse);
																						
																								JLabel lblStudentsStudyingThis = new JLabel("Students studying this course");
																								lblStudentsStudyingThis.setBounds(10, 245, 178, 14);
																								panel.add(lblStudentsStudyingThis);
																								
																										JLabel lblStudentsFinishedWith = new JLabel("Students finished with this course");
																										lblStudentsFinishedWith.setBounds(211, 245, 196, 14);
																										panel.add(lblStudentsFinishedWith);
																										
																												tblafinishedwithcourse = new JTable();
																												tblafinishedwithcourse.setBounds(217, 281, 169, 152);
																												panel.add(tblafinishedwithcourse);
																												
																												

																												tblastudyingcourse = new JTable();
																												tblastudyingcourse.setBounds(11, 281, 162, 152);
																												panel.add(tblastudyingcourse);
																												
																														JLabel lblPercentWi = new JLabel("Percent with highest grade");
																														lblPercentWi.setBounds(90, 444, 159, 14);
																														panel.add(lblPercentWi);
																														
																																tblpercentofA = new JTable();
																																tblpercentofA.setBounds(261, 444, 62, 14);
																																panel.add(tblpercentofA);
																																
																																		JButton btnCourseWithHighest = new JButton("Course with highest passed quota  ");
																																		btnCourseWithHighest.setBounds(36, 500, 239, 23);
																																		panel.add(btnCourseWithHighest);
																																		
																																				tblflow = new JTable();
																																				tblflow.setBounds(32, 534, 270, 23);
																																				panel.add(tblflow);
																																		btnCourseWithHighest.addActionListener(new ActionListener() {
																																			public void actionPerformed(ActionEvent e) {
																																			}
																																		});
																		btnDeleteCourse.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				String ccode = txtcCode.getText();
																				String msg = "";
																				msg = CourseView.deleteCourse(ccode);
																				lblmsgcourse.setText(msg);
																			}
																		});
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
