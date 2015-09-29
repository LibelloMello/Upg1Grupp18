package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DAL.ShareAccess;
import _controller.Controller;
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
import java.util.Vector;
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
import javax.swing.JTabbedPane;

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
	private JTable tbluppgift2;
	private DefaultTableModel tablemodeluppgift2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// +UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		frame.setBounds(100, 100, 843, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ButtonGroup buttongroup = new ButtonGroup();

		String[] headerStudents = { "Student ID", "Name", "Address" };
		tablemodelstudents = new DefaultTableModel(headerStudents, 0);
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

		String[] headerStudying = { "Student ID" };
		tablemodelstudying = new DefaultTableModel(headerStudying, 0);

		String[] headerStudied = { "Student ID", "Grade" };
		tablemodelstudied = new DefaultTableModel(headerStudied, 0);

		String[] headerCourse = { "Course ID", "Course Name", "Credits" };
		tablemodelcourse = new DefaultTableModel(headerCourse, 0);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 827, 619);
		frame.getContentPane().add(tabbedPane);

		JPanel panelUppgift1 = new JPanel();
		tabbedPane.addTab("Uppgift1 ", null, panelUppgift1, null);
		panelUppgift1.setLayout(null);

		txtcCode = new JTextField();
		txtcCode.setBounds(108, 8, 178, 20);
		panelUppgift1.add(txtcCode);
		txtcCode.setColumns(10);

		txtcName = new JTextField();
		txtcName.setBounds(108, 33, 178, 20);
		panelUppgift1.add(txtcName);
		txtcName.setColumns(10);

		txtcCredits = new JTextField();
		txtcCredits.setBounds(108, 57, 178, 20);
		panelUppgift1.add(txtcCredits);
		txtcCredits.setColumns(10);

		JLabel lblNewLabel = new JLabel("Course Code");
		lblNewLabel.setBounds(11, 11, 87, 14);
		panelUppgift1.add(lblNewLabel);

		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(11, 36, 87, 14);
		panelUppgift1.add(lblCourseName);

		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(11, 60, 77, 14);
		panelUppgift1.add(lblCredits);

		JButton btnRegisterCourse = new JButton("Register Course");
		btnRegisterCourse.setBounds(210, 120, 144, 23);
		panelUppgift1.add(btnRegisterCourse);

		JButton btnSearchCourse = new JButton("Search Course");
		btnSearchCourse.setBounds(46, 120, 133, 23);
		panelUppgift1.add(btnSearchCourse);

		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setBounds(46, 154, 133, 23);
		panelUppgift1.add(btnDeleteCourse);

		JLabel lblmsgcourse = new JLabel("");
		lblmsgcourse.setBounds(79, 97, 287, 14);
		panelUppgift1.add(lblmsgcourse);

		JLabel lblStudentsStudyingThis = new JLabel("Students studying this course");
		lblStudentsStudyingThis.setBounds(11, 278, 178, 14);
		panelUppgift1.add(lblStudentsStudyingThis);

		JLabel lblStudentsFinishedWith = new JLabel("Students finished with this course");
		lblStudentsFinishedWith.setBounds(210, 278, 196, 14);
		panelUppgift1.add(lblStudentsFinishedWith);

		JLabel lblPercentWi = new JLabel("Percent with highest grade");
		lblPercentWi.setBounds(79, 458, 159, 14);
		panelUppgift1.add(lblPercentWi);

		JButton btnCourseWithHighest = new JButton("Course with highest passed quota  ");
		btnCourseWithHighest.setBounds(32, 483, 239, 23);
		panelUppgift1.add(btnCourseWithHighest);

		tblflow = new JTable();
		tblflow.setBounds(32, 517, 270, 23);
		panelUppgift1.add(tblflow);

		JScrollPane scrollpanestudying = new JScrollPane();
		scrollpanestudying.setBounds(11, 303, 169, 137);
		panelUppgift1.add(scrollpanestudying);

		tblstudying = new JTable(tablemodelstudying);
		scrollpanestudying.setViewportView(tblstudying);

		JScrollPane scrollpanelfinished = new JScrollPane();
		scrollpanelfinished.setBounds(210, 303, 196, 137);
		panelUppgift1.add(scrollpanelfinished);

		tblfinished = new JTable(tablemodelstudied);
		scrollpanelfinished.setViewportView(tblfinished);

		JLabel lblMessage_1 = new JLabel("Message:");
		lblMessage_1.setBounds(11, 97, 69, 14);
		panelUppgift1.add(lblMessage_1);

		JScrollPane scrollcourse = new JScrollPane();
		scrollcourse.setBounds(46, 188, 373, 61);
		panelUppgift1.add(scrollcourse);

		tablecourse = new JTable(tablemodelcourse);
		scrollcourse.setViewportView(tablecourse);

		JLabel lblpercent = new JLabel("");
		lblpercent.setBounds(256, 458, 46, 14);
		panelUppgift1.add(lblpercent);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(449, 36, 95, 14);
		panelUppgift1.add(lblStudentName);

		JLabel lblStudentAddress = new JLabel("Student Address");
		lblStudentAddress.setBounds(449, 60, 95, 14);
		panelUppgift1.add(lblStudentAddress);

		JLabel lblmsgstudent = new JLabel("");
		lblmsgstudent.setBounds(513, 97, 144, 14);
		panelUppgift1.add(lblmsgstudent);
		JScrollPane scrollStudent = new JScrollPane();
		scrollStudent.setBounds(459, 188, 286, 57);
		panelUppgift1.add(scrollStudent);
		scrollStudent.setEnabled(false);

		tabelstudent = new JTable(tablemodelstudents);
		scrollStudent.setViewportView(tabelstudent);

		JButton btnSearchStudentn = new JButton("Search Student");
		btnSearchStudentn.setBounds(459, 120, 130, 23);
		panelUppgift1.add(btnSearchStudentn);

		JButton btnRegisterStudent = new JButton("Register Student");
		btnRegisterStudent.setBounds(615, 120, 130, 23);
		panelUppgift1.add(btnRegisterStudent);

		JLabel lblStudentPnr = new JLabel("Student ID");
		lblStudentPnr.setBounds(449, 11, 80, 14);
		panelUppgift1.add(lblStudentPnr);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(459, 154, 130, 23);
		panelUppgift1.add(btnDeleteStudent);

		txtsaddress = new JTextField();
		txtsaddress.setBounds(554, 57, 159, 20);
		panelUppgift1.add(txtsaddress);
		txtsaddress.setColumns(10);

		txtspnr = new JTextField();
		txtspnr.setBounds(554, 8, 159, 20);
		panelUppgift1.add(txtspnr);
		txtspnr.setColumns(10);

		txtsname = new JTextField();
		txtsname.setBounds(554, 33, 159, 20);
		panelUppgift1.add(txtsname);
		txtsname.setColumns(10);

		JLabel lblMessage = new JLabel("Message: ");
		lblMessage.setBounds(459, 97, 69, 14);
		panelUppgift1.add(lblMessage);

		JComboBox cmbcourse = new JComboBox();
		cmbcourse.setBounds(554, 303, 159, 28);
		panelUppgift1.add(cmbcourse);

		try {
			for (Course c : CourseController.ReadAllCourses())
				cmbcourse.addItem(c.getCcode());
		} catch (CourseExceptions e6) {
			e6.printStackTrace();
		}

		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(449, 278, 108, 14);
		panelUppgift1.add(lblNewLabel_1);

		txtspnrreg = new JTextField();
		txtspnrreg.setBounds(554, 274, 159, 23);
		panelUppgift1.add(txtspnrreg);
		txtspnrreg.setColumns(10);

		JComboBox cmbgrade = new JComboBox();
		cmbgrade.setBounds(707, 365, 38, 20);
		panelUppgift1.add(cmbgrade);
		cmbgrade.setEnabled(false);
		cmbgrade.addItem("A");
		cmbgrade.addItem("B");
		cmbgrade.addItem("C");
		cmbgrade.addItem("D");
		cmbgrade.addItem("E");
		cmbgrade.addItem("U");

		JRadioButton rdbtnregstudent = new JRadioButton("Register student on course");
		rdbtnregstudent.setBounds(449, 338, 209, 23);
		panelUppgift1.add(rdbtnregstudent);
		buttongroup.add(rdbtnregstudent);

		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setBounds(449, 310, 113, 14);
		panelUppgift1.add(lblSelectCourse);

		JRadioButton rdbtnShowStudentsResult = new JRadioButton("Show students result");
		rdbtnShowStudentsResult.setBounds(449, 389, 152, 23);
		panelUppgift1.add(rdbtnShowStudentsResult);
		buttongroup.add(rdbtnShowStudentsResult);

		JRadioButton rdbtnremovestudentfrcourse = new JRadioButton("Remove student from course");
		rdbtnremovestudentfrcourse.setBounds(449, 415, 209, 23);
		panelUppgift1.add(rdbtnremovestudentfrcourse);
		buttongroup.add(rdbtnremovestudentfrcourse);

		JLabel lblFillInGrade = new JLabel("Fill in grade");
		lblFillInGrade.setBounds(643, 368, 122, 14);
		panelUppgift1.add(lblFillInGrade);

		JLabel lblStudentsGrade = new JLabel("Grade:");
		lblStudentsGrade.setBounds(643, 393, 52, 14);
		panelUppgift1.add(lblStudentsGrade);

		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(447, 483, 97, 23);
		panelUppgift1.add(btnApply);

		JRadioButton rdbtnregstudied = new JRadioButton("Register studied");
		rdbtnregstudied.setBounds(449, 364, 188, 23);
		panelUppgift1.add(rdbtnregstudied);
		buttongroup.add(rdbtnregstudied);

		JLabel lblGrade = new JLabel("");
		lblGrade.setBounds(699, 396, 46, 14);
		panelUppgift1.add(lblGrade);

		JLabel lblMessage_2 = new JLabel("Message:");
		lblMessage_2.setBounds(449, 458, 80, 14);
		panelUppgift1.add(lblMessage_2);

		JLabel lblapplymsg = new JLabel("");
		lblapplymsg.setBounds(537, 458, 158, 14);
		panelUppgift1.add(lblapplymsg);

		String[] uppgift2Header = { "1", "2", "3", "4", "5" };
		tablemodeluppgift2 = new DefaultTableModel(uppgift2Header, 0);

		JPanel panelUppgift2 = new JPanel();
		tabbedPane.addTab("Uppgift2", null, panelUppgift2, null);
		panelUppgift2.setLayout(null);

		JComboBox cmbupp2 = new JComboBox();
		cmbupp2.setBounds(24, 11, 300, 23);
		panelUppgift2.add(cmbupp2);
		cmbupp2.addItem("CRONUS Sverige AB$Employee");
		cmbupp2.addItem("CRONUS Sverige AB$Employee Absence");
		cmbupp2.addItem("CRONUS Sverige AB$Employee Portal Setup");
		cmbupp2.addItem("CRONUS Sverige AB$Employee Qualification");
		cmbupp2.addItem("CRONUS Sverige AB$Employee Relative");
		cmbupp2.addItem("CRONUS Sverige AB$Employee Statistics Group");

		JButton btnupp2 = new JButton("Apply");
		btnupp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String tablename;
				tablename = cmbupp2.getSelectedItem().toString();
				if (tablename.equals("CRONUS Sverige AB$Employee Statistics Group")) {

				}

				try {
					tablemodeluppgift2.setDataVector(Controller.getStandardData(tablename),
							Controller.getStandardMetaData(tablename));
				} catch (SQLException e) {
					e.getStackTrace();
				}

			}
		});

		btnupp2.setBounds(21, 45, 89, 24);
		panelUppgift2.add(btnupp2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(34, 113, 788, 460);
		panelUppgift2.add(scrollPane_2);
		tbluppgift2 = new JTable(tablemodeluppgift2);
		scrollPane_2.setViewportView(tbluppgift2);

		JButton btnKeys = new JButton("Keys");
		btnKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					tablemodeluppgift2.setDataVector(Controller.getKeys(), Controller.getKeysMetaData());
				}catch (SQLException e1) {
					e1.getStackTrace();
				}
				
				
			}
		});
		btnKeys.setBounds(620, 11, 89, 23);
		panelUppgift2.add(btnKeys);

		JButton btnIndexes = new JButton("Indexes");
		btnIndexes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					tablemodeluppgift2.setDataVector(Controller.getIndexes(), Controller.getIndexesMetaData());
				}catch (SQLException e3){
					e3.getStackTrace();
				}
				
			}
		});
		btnIndexes.setBounds(620, 46, 89, 23);
		panelUppgift2.add(btnIndexes);

		JButton btnConstraints = new JButton("Constraints");
		btnConstraints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					tablemodeluppgift2.setDataVector(Controller.getConstraints(), Controller.getConstraintsMetaData());
				}catch (SQLException e4) {
					e4.getStackTrace();
				}
			}
		});
		btnConstraints.setBounds(719, 11, 89, 23);
		panelUppgift2.add(btnConstraints);

		JButton btnMaxRows = new JButton("Maxrows");
		btnMaxRows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnMaxRows.setBounds(719, 46, 89, 23);
		panelUppgift2.add(btnMaxRows);

		JComboBox cmbAllEmp = new JComboBox();
		cmbAllEmp.setBounds(347, 46, 90, 23);
		panelUppgift2.add(cmbAllEmp);
		cmbAllEmp.addItem("Solution 1");
		cmbAllEmp.addItem("Solution 2");


		JComboBox cmballTables = new JComboBox();
		cmballTables.setBounds(490, 46, 90, 23);
		panelUppgift2.add(cmballTables);
		cmballTables.addItem("Solution 1");
		cmballTables.addItem("Solution 2");

		JLabel lblAllTablesIn = new JLabel("All tables in database");
		lblAllTablesIn.setBounds(345, 15, 140, 14);
		panelUppgift2.add(lblAllTablesIn);

		JLabel lblAllEmployeesColumn = new JLabel("All employee columns");
		lblAllEmployeesColumn.setBounds(490, 15, 134, 14);
		panelUppgift2.add(lblAllEmployeesColumn);

		JButton btnSearchAllTables = new JButton("Search");
		btnSearchAllTables.setBounds(347, 80, 89, 23);
		panelUppgift2.add(btnSearchAllTables);

		JButton btnSearchAllEmp = new JButton("Search");
		btnSearchAllEmp.setBounds(490, 79, 89, 23);
		panelUppgift2.add(btnSearchAllEmp);

		JPanel panelUppgift3 = new JPanel();
		tabbedPane.addTab("Uppgift3", null, panelUppgift3, null);
		panelUppgift3.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 333, 20);
		panelUppgift3.add(comboBox);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(366, 10, 89, 23);
		panelUppgift3.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 81, 790, 499);
		panelUppgift3.add(scrollPane);
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
				String spnr = txtspnrreg.getText();
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
					} catch (StudentExceptions e6) {
						lblapplymsg.setText("fixa, fungerade inte");
					}
				}
				if (rdbtnregstudied.isSelected()) {
					try {
						SharedView.registerFinishedStudent(spnr, ccode, sgrade);
						lblapplymsg.setText("Ja");
					} catch (StudentExceptions e6) {
						lblapplymsg.setText("Nej");
					}
				}
				if (rdbtnShowStudentsResult.isSelected()) {
					Studied studied1 = new Studied();
					try {
						studied1 = SharedView.readResult(spnr, ccode);
						System.out.println(studied1.getsGrade());
						if (studied1 != null) {
							lblGrade.setText(studied1.getsGrade());
						} else {
							lblapplymsg.setText("Found no result");
						}
					} catch (StudentExceptions e7) {
						lblapplymsg.setText(msg);
					}
				}

			}
		});
		rdbtnremovestudentfrcourse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnremovestudentfrcourse.isSelected()) {
					cmbgrade.setEnabled(false);
				}

			}

		});
		rdbtnShowStudentsResult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnShowStudentsResult.isSelected()) {
					cmbgrade.setEnabled(false);
				}

			}

		});
		rdbtnregstudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnregstudent.isSelected()) {
					cmbgrade.setEnabled(false);
				}

			}

		});
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
