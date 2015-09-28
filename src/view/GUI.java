package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAL.ShareAccess;
import controller.CourseController;
import controller.SharedController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;
import model.Studied;
import model.Studying;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.List;
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
	private JTable tblflow;
	private DefaultTableModel tablemodelstudents;
	private JTable table;
	private JTable tabelstudent;
	private JTable tblstudying;
	private JTable tblfinished;
	private DefaultTableModel tablemodelstudying;
	private DefaultTableModel tablemodelstudied;
	private JTable tablecourse;
	private DefaultTableModel tablemodelcourse;

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

		JPanel panelstudent = new JPanel();
		panelstudent.setBounds(0, 0, 402, 271);
		frame.getContentPane().add(panelstudent);
		panelstudent.setLayout(null);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 37, 95, 14);
		panelstudent.add(lblStudentName);

		JLabel lblStudentAddress = new JLabel("Student Address");
		lblStudentAddress.setBounds(10, 65, 95, 14);
		panelstudent.add(lblStudentAddress);

		JLabel lblmsgstudent = new JLabel("");
		lblmsgstudent.setBounds(68, 93, 144, 14);
		panelstudent.add(lblmsgstudent);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 276, 401, 271);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JComboBox cmbcourse = new JComboBox();
		try {
			for (Course c : CourseController.ReadAllCourses())
				cmbcourse.addItem(c.getCcode());
		} catch (CourseExceptions e6) {
			e6.printStackTrace();
		}

		cmbcourse.setBounds(117, 41, 230, 28);
		panel_1.add(cmbcourse);

		ButtonGroup buttongroup = new ButtonGroup();
		JScrollPane scrollStudent = new JScrollPane();
		scrollStudent.setEnabled(false);
		scrollStudent.setBounds(37, 185, 286, 57);
		panelstudent.add(scrollStudent);

		String[] headerStudents = { "Student ID", "Name", "Address" };
		tablemodelstudents = new DefaultTableModel(headerStudents, 0);

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
		btnSearchStudentn.setBounds(63, 116, 130, 23);
		panelstudent.add(btnSearchStudentn);
		btnSearchStudentn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = null;
				String spnr = txtspnr.getText();
				String sname = "";
				String saddress = "";
				String msg = "";

				while (tablemodelstudents.getRowCount() > 0) {
					tablemodelstudents.removeRow(0);
				}

				try {

					student = StudentView.getStudent(spnr);

					if (student == null) {
						lblmsgstudent.setText("No student found");
					} else {

						spnr = student.getSpnr();
						sname = student.getsName();
						saddress = student.getsAddress();
						Object[] data = { spnr, sname, saddress };
						tablemodelstudents.addRow(data);
					}

				} catch (StudentExceptions e2) {
					msg = e2.getMessage();
					lblmsgstudent.setText(msg);

				}

			}
		});

		JButton btnRegisterStudent = new JButton("Register Student");
		btnRegisterStudent.setBounds(209, 116, 130, 23);
		panelstudent.add(btnRegisterStudent);
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String spnr = txtspnr.getText();
				String sname = txtsname.getText();
				String saddress = txtsaddress.getText();
				String msg = "";
				while (tablemodelstudents.getRowCount() > 0) {
					tablemodelstudents.removeRow(0);
				}

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
		lblStudentPnr.setBounds(10, 9, 80, 14);
		panelstudent.add(lblStudentPnr);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(63, 151, 130, 23);
		panelstudent.add(btnDeleteStudent);
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String msg = "";
				int selRow = tabelstudent.getSelectedRow();
				if (selRow != -1) {
					String spnr = (String) tabelstudent.getValueAt(selRow, 0);
					while (tablemodelstudents.getRowCount() > 0) {
						tablemodelstudents.removeRow(0);
					}
					try {
						msg = StudentView.deleteStudent(spnr);

					} catch (StudentExceptions e1) {
						msg = e1.getMessage();
						lblmsgstudent.setText(msg);
					}
					lblmsgstudent.setText(msg);
				} else {
					lblmsgstudent.setText("Select a student");
				}

			}
		});

		JComboBox cmbgrade = new JComboBox();
		cmbgrade.setEnabled(false);
		cmbgrade.setBounds(302, 131, 38, 20);
		panel_1.add(cmbgrade);
		cmbgrade.addItem("A");
		cmbgrade.addItem("B");
		cmbgrade.addItem("C");
		cmbgrade.addItem("D");
		cmbgrade.addItem("E");
		cmbgrade.addItem("U");

		txtsaddress = new JTextField();
		txtsaddress.setBounds(129, 62, 159, 20);
		panelstudent.add(txtsaddress);
		txtsaddress.setColumns(10);

		txtspnr = new JTextField();
		txtspnr.setBounds(129, 6, 159, 20);
		panelstudent.add(txtspnr);
		txtspnr.setColumns(10);

		txtsname = new JTextField();
		txtsname.setBounds(129, 34, 159, 20);
		panelstudent.add(txtsname);
		txtsname.setColumns(10);

		JLabel lblMessage = new JLabel("Message: ");
		lblMessage.setBounds(10, 93, 69, 14);
		panelstudent.add(lblMessage);
		/*
		 * JScrollPane scrollStudent = new JScrollPane();
		 * scrollStudent.setBounds(37, 185, 286, 57);
		 * panelstudent.add(scrollStudent);
		 * 
		 * String[] headerStudents = { "Student ID", "Name", "Address" };
		 * tablemodelstudents = new DefaultTableModel(headerStudents, 3);
		 * 
		 * 
		 * tabelstudent = new JTable(tablemodelstudents);
		 * scrollStudent.setViewportView(tabelstudent);
		 * 
		 * 
		 * 
		 * 
		 * JLabel lblNewLabel_1 = new JLabel("Student ID");
		 * lblNewLabel_1.setBounds(10, 11, 97, 14); panel_1.add(lblNewLabel_1);
		 * 
		 * txtspnrreg = new JTextField(); txtspnrreg.setBounds(117, 7, 230, 23);
		 * panel_1.add(txtspnrreg); txtspnrreg.setColumns(10);
		 */

		JRadioButton rdbtnregstudent = new JRadioButton("Register student on course");
		rdbtnregstudent.setBounds(10, 78, 209, 23);
		panel_1.add(rdbtnregstudent);
		buttongroup.add(rdbtnregstudent);
		rdbtnregstudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnregstudent.isSelected()) {
					cmbgrade.setEnabled(false);
				}

			}

		});

		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setBounds(10, 48, 87, 14);
		panel_1.add(lblSelectCourse);

		JRadioButton rdbtnShowStudentsResult = new JRadioButton("Show students result");
		rdbtnShowStudentsResult.setBounds(10, 156, 188, 23);
		panel_1.add(rdbtnShowStudentsResult);
		buttongroup.add(rdbtnShowStudentsResult);
		rdbtnShowStudentsResult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnShowStudentsResult.isSelected()) {
					cmbgrade.setEnabled(false);
				}

			}

		});

		JRadioButton rdbtnremovestudentfrcourse = new JRadioButton("Remove student from course");
		rdbtnremovestudentfrcourse.setBounds(10, 104, 209, 23);
		panel_1.add(rdbtnremovestudentfrcourse);
		buttongroup.add(rdbtnremovestudentfrcourse);
		rdbtnremovestudentfrcourse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnremovestudentfrcourse.isSelected()) {
					cmbgrade.setEnabled(false);
				}

			}

		});

		JLabel lblFillInGrade = new JLabel("Fill in grade");
		lblFillInGrade.setBounds(225, 134, 122, 14);
		panel_1.add(lblFillInGrade);

		JLabel lblStudentsGrade = new JLabel("Grade:");
		lblStudentsGrade.setBounds(225, 160, 80, 14);
		panel_1.add(lblStudentsGrade);

		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(10, 190, 97, 23);
		panel_1.add(btnApply);

		JRadioButton rdbtnregstudied = new JRadioButton("Register studied");
		rdbtnregstudied.setBounds(10, 130, 188, 23);
		panel_1.add(rdbtnregstudied);
		buttongroup.add(rdbtnregstudied);
		
		JLabel lblGrade = new JLabel("");
		lblGrade.setBounds(290, 160, 46, 14);
		panel_1.add(lblGrade);
		
		JLabel lblMessage_2 = new JLabel("Message:");
		lblMessage_2.setBounds(10, 224, 46, 14);
		panel_1.add(lblMessage_2);
		
		JLabel lblapplymsg = new JLabel("");
		lblapplymsg.setBounds(61, 224, 158, 14);
		panel_1.add(lblapplymsg);
		rdbtnregstudied.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnregstudied.isSelected()) {
					cmbgrade.setEnabled(true);
				}

			}
		});

		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccode = (String) cmbcourse.getSelectedItem();
				String spnr = txtspnr.getText();
				String sgrade = (String) cmbgrade.getSelectedItem();
				String msg = "";
				Studied studied = null;
				
				if (rdbtnregstudent.isSelected()) {
					int i = 0;
					try {
						i = SharedView.registerStudentOnCourse(spnr, ccode);
					} catch (StudentExceptions e1) {
						lblapplymsg.setText(Integer.toString(i));
					}
					lblapplymsg.setText(Integer.toString(i));
				}
				if (rdbtnremovestudentfrcourse.isSelected()) {
					try {
						SharedView.deleteStudyingFromCourse(spnr, ccode);
						lblapplymsg.setText("Fixa (funka)");
					}catch(StudentExceptions e6) {
						lblapplymsg.setText("fixa, fungerade inte");
					}
				}
				if (rdbtnregstudied.isSelected()) {
					try {
						SharedView.registerFinishedStudent(spnr, ccode, sgrade);
						lblapplymsg.setText("Ja");
					}catch(StudentExceptions e6) {
						lblapplymsg.setText("Nej");
					}
				}
				if (rdbtnShowStudentsResult.isSelected()) {
					Studied studied1 =  new Studied();
					try {
						studied1 = SharedView.readResult(spnr, ccode);
						if (studied1 == null) {
							lblapplymsg.setText("Found no result");
						}
						else{
							lblGrade.setText(studied1.getsGrade());
						}
					}catch(StudentExceptions e7) {
						lblapplymsg.setText(msg);
					}
				}
				
				

			

			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(398, 0, 429, 582);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtcCode = new JTextField();
		txtcCode.setBounds(108, 8, 178, 20);
		panel.add(txtcCode);
		txtcCode.setColumns(10);

		txtcName = new JTextField();
		txtcName.setBounds(108, 33, 178, 20);
		panel.add(txtcName);
		txtcName.setColumns(10);

		txtcCredits = new JTextField();
		txtcCredits.setBounds(108, 57, 178, 20);
		panel.add(txtcCredits);
		txtcCredits.setColumns(10);

		JLabel lblNewLabel = new JLabel("Course Code");
		lblNewLabel.setBounds(11, 11, 87, 14);
		panel.add(lblNewLabel);

		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(11, 36, 87, 14);
		panel.add(lblCourseName);

		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(11, 60, 77, 14);
		panel.add(lblCredits);

		JButton btnRegisterCourse = new JButton("Register Course");
		btnRegisterCourse.setBounds(210, 120, 144, 23);
		panel.add(btnRegisterCourse);

		JButton btnSearchCourse = new JButton("Search Course");
		btnSearchCourse.setBounds(46, 120, 133, 23);
		panel.add(btnSearchCourse);

		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setBounds(46, 154, 133, 23);
		panel.add(btnDeleteCourse);

		JLabel lblmsgcourse = new JLabel("");
		lblmsgcourse.setBounds(79, 97, 287, 14);
		panel.add(lblmsgcourse);

		JLabel lblStudentsStudyingThis = new JLabel("Students studying this course");
		lblStudentsStudyingThis.setBounds(11, 278, 178, 14);
		panel.add(lblStudentsStudyingThis);

		JLabel lblStudentsFinishedWith = new JLabel("Students finished with this course");
		lblStudentsFinishedWith.setBounds(210, 278, 196, 14);
		panel.add(lblStudentsFinishedWith);

		JLabel lblPercentWi = new JLabel("Percent with highest grade");
		lblPercentWi.setBounds(79, 458, 159, 14);
		panel.add(lblPercentWi);

		JButton btnCourseWithHighest = new JButton("Course with highest passed quota  ");
		btnCourseWithHighest.setBounds(36, 500, 239, 23);
		panel.add(btnCourseWithHighest);

		tblflow = new JTable();
		tblflow.setBounds(32, 534, 270, 23);
		panel.add(tblflow);

		JScrollPane scrollpanestudying = new JScrollPane();
		scrollpanestudying.setBounds(11, 303, 169, 137);
		panel.add(scrollpanestudying);

		String[] headerStudying = { "Student ID" };
		tablemodelstudying = new DefaultTableModel(headerStudying, 0);

		tblstudying = new JTable(tablemodelstudying);
		scrollpanestudying.setViewportView(tblstudying);

		JScrollPane scrollpanelfinished = new JScrollPane();
		scrollpanelfinished.setBounds(210, 303, 196, 137);
		panel.add(scrollpanelfinished);

		String[] headerStudied = { "Student ID", "Grade" };
		tablemodelstudied = new DefaultTableModel(headerStudied, 0);

		tblfinished = new JTable(tablemodelstudied);
		scrollpanelfinished.setViewportView(tblfinished);

		JLabel lblMessage_1 = new JLabel("Message:");
		lblMessage_1.setBounds(11, 97, 69, 14);
		panel.add(lblMessage_1);

		JScrollPane scrollcourse = new JScrollPane();
		scrollcourse.setBounds(46, 188, 373, 61);
		panel.add(scrollcourse);

		String[] headerCourse = { "Course ID", "Course Name", "Credits" };
		tablemodelcourse = new DefaultTableModel(headerCourse, 0);

		tablecourse = new JTable(tablemodelcourse);
		scrollcourse.setViewportView(tablecourse);

		JLabel lblpercent = new JLabel("");
		lblpercent.setBounds(256, 458, 46, 14);
		panel.add(lblpercent);

		btnCourseWithHighest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				int selRow = tablecourse.getSelectedRow();
				if (selRow != -1) {
					String ccode = (String) tablecourse.getValueAt(selRow, 0);
					while (tablemodelcourse.getRowCount() > 0) {
						tablemodelcourse.removeRow(0);
					}
					try {
						msg = CourseView.deleteCourse(ccode);
						try {
							cmbcourse.removeAllItems();
							for (Course c : CourseController.ReadAllCourses())
								cmbcourse.addItem(c.getCcode());
						} catch (CourseExceptions e6) {
							e6.printStackTrace();
						}
					} catch (CourseExceptions e5) {
						msg = e5.getMessage();
						lblmsgcourse.setText(msg);
					}
					lblmsgcourse.setText(msg);
				} else {
					lblmsgcourse.setText("Select a course");
				}

			}
		});
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course c = null;
				String ccode = txtcCode.getText();
				String cname;
				int credits;
				String msg = "";
				List<Studying> studyingList = null;
				List<Studied> studiedList = null;
				int percentA;

				while (tablemodelcourse.getRowCount() > 0) {
					tablemodelcourse.removeRow(0);
				}
				while (tablemodelstudying.getRowCount() > 0) {
					tablemodelstudying.removeRow(0);
				}
				while (tablemodelstudied.getRowCount() > 0) {
					tablemodelstudied.removeRow(0);
				}
				try {
					c = CourseView.getCourse(ccode);

					if (c == null) {
						lblmsgcourse.setText("No course Found");
					} else {
						ccode = c.getCcode();
						cname = c.getCname();
						credits = c.getCredits();
						Object[] data = { ccode, cname, credits };
						tablemodelcourse.addRow(data);

						try {
							percentA = SharedView.readPercentAonCourse(ccode);
							String a;
							a = Integer.toString(percentA);
							lblpercent.setText(a + "%");

						} catch (StudentExceptions e5) {
							e5.getMessage();
						}

						try {
							studiedList = SharedView.readAllFinishedStudents(ccode);
						} catch (StudentExceptions e1) {

							e1.printStackTrace();
						}
						for (int i = 0; i < studiedList.size(); i++) {
							String spnr = studiedList.get(i).getsPnr();
							String grade = studiedList.get(i).getsGrade();

							Object[] data2 = { spnr, grade };

							tablemodelstudied.addRow(data2);

						}

						try {
							studyingList = SharedView.readAllStudentsOnCourse(ccode);
						} catch (StudentExceptions e1) {

							e1.printStackTrace();
						}
						for (int i = 0; i < studyingList.size(); i++) {
							String spnr = studyingList.get(i).getSpnr();

							Object[] data2 = { spnr };

							tablemodelstudying.addRow(data2);

						}

					}

				} catch (CourseExceptions e3) {
					msg = e3.getMessage();
					lblmsgcourse.setText(msg);
				}
			}
		});
		btnRegisterCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ccode = txtcCode.getText();
				String cname = txtcName.getText();
				String creditsString = txtcCredits.getText();
				int credits = Integer.parseInt(creditsString);
				String msg = "";
				while (tablemodelcourse.getRowCount() > 0) {
					tablemodelcourse.removeRow(0);
				}
				try {
					msg = CourseView.addCourse(ccode, cname, credits);
				} catch (CourseExceptions e4) {
					msg = e4.getMessage();
					lblmsgcourse.setText(msg);
				}
				lblmsgcourse.setText(msg);

			}
		});

	}
}
