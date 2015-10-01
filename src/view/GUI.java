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
import java.io.File;
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
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.javafx.tk.Toolkit;

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
	private Desktop desktop;
	private DefaultTableModel tablemodelstudentstudying;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

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

		try {
			desktop = null;
			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String[] headerStudents = { "Student ID", "Name", "Address" };
		tablemodelstudents = new DefaultTableModel(headerStudents, 0);

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

		JComboBox cmbcourse = new JComboBox();
		cmbcourse.setBounds(554, 303, 159, 28);
		panelUppgift1.add(cmbcourse);

		try {
			for (Course c : CourseController.ReadAllCourses())
				cmbcourse.addItem(c.getCcode());
		} catch (CourseExceptions e6) {
			e6.printStackTrace();
		}

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
		scrollPane_2.setBounds(10, 114, 798, 460);
		panelUppgift2.add(scrollPane_2);
		tbluppgift2 = new JTable(tablemodeluppgift2);
		scrollPane_2.setViewportView(tbluppgift2);

		JButton btnKeys = new JButton("Keys");
		btnKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					tablemodeluppgift2.setDataVector(Controller.getKeys(), Controller.getKeysMetaData());
				} catch (SQLException e1) {
					e1.getStackTrace();
				}

			}
		});
		btnKeys.setBounds(620, 46, 89, 23);
		panelUppgift2.add(btnKeys);

		JButton btnIndexes = new JButton("Indexes");
		btnIndexes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					tablemodeluppgift2.setDataVector(Controller.getIndexes(), Controller.getIndexesMetaData());
				} catch (SQLException e3) {
					e3.getStackTrace();
				}

			}
		});
		btnIndexes.setBounds(620, 80, 89, 23);
		panelUppgift2.add(btnIndexes);

		JButton btnConstraints = new JButton("Constraints");
		btnConstraints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					tablemodeluppgift2.setDataVector(Controller.getConstraints(), Controller.getConstraintsMetaData());
				} catch (SQLException e4) {
					e4.getStackTrace();
				}
			}
		});
		btnConstraints.setBounds(719, 46, 89, 23);
		panelUppgift2.add(btnConstraints);

		JButton btnMaxRows = new JButton("Maxrows");
		btnMaxRows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tablemodeluppgift2.setDataVector(Controller.getMaxRows(), Controller.getMaxRowsMetaData());
				} catch (SQLException e4) {
					e4.getStackTrace();
				}

			}
		});
		btnMaxRows.setBounds(719, 80, 89, 23);
		panelUppgift2.add(btnMaxRows);

		JComboBox cmbAllEmp = new JComboBox();
		cmbAllEmp.setBounds(489, 46, 90, 23);
		panelUppgift2.add(cmbAllEmp);
		cmbAllEmp.addItem("Solution 1");
		cmbAllEmp.addItem("Solution 2");

		JComboBox cmballTables = new JComboBox();
		cmballTables.setBounds(345, 46, 90, 23);
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
		btnSearchAllTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cmballTables.getSelectedIndex();

				if (index == 0) {
					try {
						tablemodeluppgift2.setDataVector(Controller.getAllTables1(),
								Controller.getAllTablesMetaData1());
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				} else if (index == 1) {
					try {
						tablemodeluppgift2.setDataVector(Controller.getAllTables2(),
								Controller.getAllTablesMetaData2());
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		btnSearchAllTables.setBounds(346, 80, 89, 23);
		panelUppgift2.add(btnSearchAllTables);

		JButton btnSearchAllEmp = new JButton("Search");
		btnSearchAllEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = cmbAllEmp.getSelectedIndex();

				if (index == 0) {
					try {
						tablemodeluppgift2.setDataVector(Controller.getAllColumnsEmp1(),
								Controller.getAllColumnsEmpMetaData1());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (index == 1) {
					try {
						tablemodeluppgift2.setDataVector(Controller.getAllColumnsEmp2(),
								Controller.getAllColumnsEmpMetaData2());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnSearchAllEmp.setBounds(490, 80, 89, 23);
		panelUppgift2.add(btnSearchAllEmp);

		JPanel panelUppgift3 = new JPanel();
		tabbedPane.addTab("Uppgift3", null, panelUppgift3, null);
		panelUppgift3.setLayout(null);

		JComboBox cmbaccess = new JComboBox();
		cmbaccess.setBounds(10, 91, 245, 20);
		panelUppgift3.add(cmbaccess);

		cmbaccess.addItem("100 NOK");
		cmbaccess.addItem("MOST CURRENCY IN SEK");
		cmbaccess.addItem("FOTOGRAFERNA AB ADDRESS");
		cmbaccess.addItem("SICK EMPLOYEES");
		cmbaccess.addItem("RELATIVES");
		cmbaccess.addItem("CUSTOMERS OF A.BERGLUND");
		cmbaccess.addItem("CUSTOMER NUMBER 10000");

		JComboBox cmbexcel = new JComboBox();
		cmbexcel.setBounds(10, 48, 245, 20);
		panelUppgift3.add(cmbexcel);

		cmbexcel.addItem("100 NOK");
		cmbexcel.addItem("MOST CURRENCY IN SEK");
		cmbexcel.addItem("FOTOGRAFERNA AB ADDRESS");
		cmbexcel.addItem("SICK EMPLOYEES");
		cmbexcel.addItem("RELATIVES");
		cmbexcel.addItem("CUSTOMERS OF A.BERGLUND");
		cmbexcel.addItem("CUSTOMER NUMBER 10000");

		JButton btnaccess = new JButton("Open Access File");
		btnaccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = cmbaccess.getSelectedIndex();

				if (index == 0) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga1.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 1) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga2.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 2) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga3.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 3) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga4.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 4) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga5.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 5) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga6.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 6) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/Fråga7.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnaccess.setBounds(275, 90, 132, 23);
		panelUppgift3.add(btnaccess);

		JButton btngetExcel = new JButton("Open Excel File");
		btngetExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = cmbexcel.getSelectedIndex();

				if (index == 0) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F1.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 1) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F2.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 2) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F3.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 3) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F4.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 4) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F5.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 5) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F6.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 6) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3F7.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btngetExcel.setBounds(275, 47, 132, 23);
		panelUppgift3.add(btngetExcel);

		JComboBox cmbAccessForm = new JComboBox();
		cmbAccessForm.setBounds(185, 217, 126, 20);
		panelUppgift3.add(cmbAccessForm);
		cmbAccessForm.addItem("All Employees");
		cmbAccessForm.addItem("All Customers");

		JComboBox cmbExcelForms = new JComboBox();
		cmbExcelForms.setBounds(185, 186, 126, 20);
		panelUppgift3.add(cmbExcelForms);
		cmbExcelForms.addItem("All Employees");
		cmbExcelForms.addItem("All Customers");

		JButton btnOpenAccessForms = new JButton("Open Access Form");
		btnOpenAccessForms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = cmbAccessForm.getSelectedIndex();

				if (index == 0) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/FrågaB1.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 1) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Access/FrågaB2.accdb"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnOpenAccessForms.setBounds(10, 216, 155, 23);
		panelUppgift3.add(btnOpenAccessForms);

		JComboBox cmbWordForm = new JComboBox();
		cmbWordForm.setBounds(185, 155, 126, 20);
		panelUppgift3.add(cmbWordForm);
		cmbWordForm.addItem("All Employees");
		cmbWordForm.addItem("All Customers");

		JButton btnOpenWordForms = new JButton("Open Word Form");
		btnOpenWordForms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = cmbWordForm.getSelectedIndex();

				if (index == 0) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Word/U3B1.docx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 1) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Word/U3B2.docx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnOpenWordForms.setBounds(10, 154, 155, 23);
		panelUppgift3.add(btnOpenWordForms);

		JButton btnOpenExcelForms = new JButton("Open Excel Form");
		btnOpenExcelForms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = cmbExcelForms.getSelectedIndex();

				if (index == 0) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3B1.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (index == 1) {
					try {
						desktop.open(new File("/Users/Gustav/Desktop/Excel/U3B2.xlsx"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnOpenExcelForms.setBounds(9, 185, 156, 23);
		panelUppgift3.add(btnOpenExcelForms);

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
		lblmsgcourse.setBounds(78, 97, 287, 14);
		panelUppgift1.add(lblmsgcourse);

		JLabel lblStudentsStudyingThis = new JLabel("Students studying this course");
		lblStudentsStudyingThis.setBounds(11, 278, 178, 14);
		panelUppgift1.add(lblStudentsStudyingThis);

		JLabel lblStudentsFinishedWith = new JLabel("Students finished with this course");
		lblStudentsFinishedWith.setBounds(210, 278, 196, 14);
		panelUppgift1.add(lblStudentsFinishedWith);

		JLabel lblPercentWi = new JLabel("Percent with highest grade");
		lblPercentWi.setBounds(174, 458, 155, 14);
		panelUppgift1.add(lblPercentWi);

		JButton btnCourseWithHighest = new JButton("Course with highest passed quota  ");
		btnCourseWithHighest.setBounds(33, 508, 239, 23);
		panelUppgift1.add(btnCourseWithHighest);

		JScrollPane scrollpanestudying = new JScrollPane();
		scrollpanestudying.setBounds(11, 303, 168, 137);
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
		scrollcourse.setBounds(46, 188, 308, 61);
		panelUppgift1.add(scrollcourse);

		tablecourse = new JTable(tablemodelcourse);
		scrollcourse.setViewportView(tablecourse);

		JLabel lblpercent = new JLabel("");
		lblpercent.setBounds(337, 458, 69, 14);
		panelUppgift1.add(lblpercent);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(449, 36, 95, 14);
		panelUppgift1.add(lblStudentName);

		JLabel lblStudentAddress = new JLabel("Student Address");
		lblStudentAddress.setBounds(449, 60, 95, 14);
		panelUppgift1.add(lblStudentAddress);

		JLabel lblmsgstudent = new JLabel("");
		lblmsgstudent.setBounds(527, 97, 144, 14);
		panelUppgift1.add(lblmsgstudent);
		JScrollPane scrollStudent = new JScrollPane();
		scrollStudent.setBounds(458, 188, 287, 57);
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

		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(454, 278, 108, 14);
		panelUppgift1.add(lblNewLabel_1);

		txtspnrreg = new JTextField();
		txtspnrreg.setBounds(554, 274, 159, 23);
		panelUppgift1.add(txtspnrreg);
		txtspnrreg.setColumns(10);

		JComboBox cmbgrade = new JComboBox();
		cmbgrade.setBounds(690, 365, 38, 20);
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
		rdbtnShowStudentsResult.setBounds(449, 390, 152, 23);
		panelUppgift1.add(rdbtnShowStudentsResult);
		buttongroup.add(rdbtnShowStudentsResult);

		JRadioButton rdbtnremovestudentfrcourse = new JRadioButton("Remove student from course");
		rdbtnremovestudentfrcourse.setBounds(449, 416, 209, 23);
		panelUppgift1.add(rdbtnremovestudentfrcourse);
		buttongroup.add(rdbtnremovestudentfrcourse);

		JLabel lblFillInGrade = new JLabel("Fill in grade");
		lblFillInGrade.setBounds(615, 368, 122, 14);
		panelUppgift1.add(lblFillInGrade);

		JLabel lblStudentsGrade = new JLabel("Grade:");
		lblStudentsGrade.setBounds(645, 396, 52, 14);
		panelUppgift1.add(lblStudentsGrade);

		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(447, 496, 97, 23);
		panelUppgift1.add(btnApply);

		JRadioButton rdbtnregstudied = new JRadioButton("Register studied");
		rdbtnregstudied.setBounds(449, 364, 188, 23);
		panelUppgift1.add(rdbtnregstudied);
		buttongroup.add(rdbtnregstudied);

		JLabel lblGrade = new JLabel("");
		lblGrade.setBounds(690, 396, 46, 14);
		panelUppgift1.add(lblGrade);

		JLabel lblMessage_2 = new JLabel("Message:");
		lblMessage_2.setBounds(449, 458, 80, 14);
		panelUppgift1.add(lblMessage_2);

		JLabel lblapplymsg = new JLabel("");
		lblapplymsg.setBounds(539, 458, 239, 14);
		panelUppgift1.add(lblapplymsg);

		JLabel lblThroughPut = new JLabel("");
		lblThroughPut.setBounds(92, 566, 287, 14);
		panelUppgift1.add(lblThroughPut);

		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(82, 541, 97, 14);
		panelUppgift1.add(lblCourseCode);

		JLabel lblPercent = new JLabel("Percent");
		lblPercent.setBounds(189, 542, 65, 14);
		panelUppgift1.add(lblPercent);

		JButton btnClearFieldsCourse = new JButton("Clear fields");
		btnClearFieldsCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblmsgcourse.setText("");
				txtcCode.setText("");
				txtcCredits.setText("");
				txtcName.setText("");
			}
		});
		btnClearFieldsCourse.setBounds(210, 154, 144, 23);
		panelUppgift1.add(btnClearFieldsCourse);

		JButton btnClearFieldsStudent = new JButton("Clear fields");
		btnClearFieldsStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblmsgstudent.setText("");
				txtspnr.setText("");
				txtsname.setText("");
				txtsaddress.setText("");
			}
		});
		btnClearFieldsStudent.setBounds(615, 154, 130, 23);
		panelUppgift1.add(btnClearFieldsStudent);
		frame.getContentPane()
				.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { btnRegisterCourse, tabbedPane,
						panelUppgift1, cmbcourse, lblNewLabel, lblCourseName, lblCredits, btnSearchCourse,
						btnDeleteCourse, lblmsgcourse, lblStudentsStudyingThis, lblStudentsFinishedWith, lblPercentWi,
						btnCourseWithHighest, scrollpanestudying, txtcCode, tblstudying, txtcCredits,
						scrollpanelfinished, txtcName, tblfinished, lblMessage_1, scrollcourse, tablecourse, lblpercent,
						lblStudentName, lblStudentAddress, lblmsgstudent, scrollStudent, tabelstudent,
						btnSearchStudentn, btnRegisterStudent, lblStudentPnr, btnDeleteStudent, txtsaddress, txtspnr,
						txtsname, lblMessage, lblNewLabel_1, txtspnrreg, cmbgrade, rdbtnregstudent, lblSelectCourse,
						rdbtnShowStudentsResult, rdbtnremovestudentfrcourse, lblFillInGrade, lblStudentsGrade, btnApply,
						rdbtnregstudied, lblGrade, lblMessage_2, lblapplymsg, lblThroughPut, lblCourseCode, lblPercent,
						panelUppgift2, cmbupp2, btnupp2, scrollPane_2, tbluppgift2, btnKeys, btnIndexes, btnConstraints,
						btnMaxRows, cmbAllEmp, cmballTables, lblAllTablesIn, lblAllEmployeesColumn, btnSearchAllTables,
						btnSearchAllEmp, panelUppgift3, cmbaccess, cmbexcel, btnaccess, btngetExcel, cmbAccessForm,
						cmbExcelForms, btnOpenAccessForms, cmbWordForm, btnOpenWordForms, btnOpenExcelForms }));

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

				lblapplymsg.setText("");
				lblGrade.setText("");

				if (rdbtnregstudent.isSelected()) {
					int i = 0;
					int j = 0;
					try {
						for (Student s : StudentView.getAllStudents()) {
							if (spnr.equals(s.getSpnr())) {
								j = 1;
							}
						}
					} catch (StudentExceptions e1) {

					}
					if (j == 1) {
						try {

							i = SharedView.registerStudentOnCourse(spnr, ccode);

							if (i == 1) {
								lblapplymsg.setText("Student registered on course");
							} else if (i == 2) {
								lblapplymsg.setText("Student already registered on course");
							} else if (i == 0) {
								lblapplymsg.setText("Student has too many credits");
							}
						} catch (StudentExceptions e1) {

						}
					} else {
						lblapplymsg.setText("Couldn't find student");
					}
				}

				if (rdbtnremovestudentfrcourse.isSelected()) {
					int j = 0;
					try {
						for (Studying s : SharedView.readAllStudentsOnCourse(ccode)) {
							if (spnr.equals(s.getSpnr()) && ccode.equals(s.getcCode())) {
								j = 1;

							}
						}
					} catch (StudentExceptions e1) {
					}
					if (j == 1) {
						try {
							SharedView.deleteStudyingFromCourse(spnr, ccode);
							lblapplymsg.setText("Student deleted from course");
						} catch (StudentExceptions e6) {
							lblapplymsg.setText("Something happend.");
						}
					} else {
						lblapplymsg.setText("Couldn't find student on course");
					}
				}
				if (rdbtnregstudied.isSelected()) {
					int j = 0;
					int k = 0;
					try {
						for (Student s : StudentView.getAllStudents()) {
							if (spnr.equals(s.getSpnr())) {
								j = 1;
							}
						}
						for (Studied s1 : SharedView.readAllFinishedStudents(ccode)) {
							if (spnr.equals(s1.getsPnr())) {
								k = 1;
							}
						}

					} catch (StudentExceptions e1) {

					}

					if (j == 1 && k == 0) {
						try {
							SharedView.registerFinishedStudent(spnr, ccode, sgrade);
							lblapplymsg.setText("Student Registered");
							SharedView.deleteStudyingFromCourse(spnr, ccode);
						} catch (StudentExceptions e6) {
							lblapplymsg.setText("Something happened");
						}
					} else if (k == 1) {
						lblapplymsg.setText("Student already registered on course");
					} else {
						lblapplymsg.setText("Couldn't find student");
					}

				}

				if (rdbtnShowStudentsResult.isSelected()) {
					int i = 0;
					Studied studied1;
					try {
						for (Studied s1 : SharedView.readAllFinishedStudents(ccode)) {
							if (spnr.equals(s1.getsPnr())) {
								i = 1;
							}
						}
					} catch (StudentExceptions e1) {

					}

					if (i == 1) {
						try {
							studied1 = SharedView.readResult(spnr, ccode);

							if (studied1 != null) {
								lblGrade.setText(studied1.getsGrade());
							}
						} catch (StudentExceptions e7) {
							lblapplymsg.setText(msg);
						}
					} else {
						lblapplymsg.setText("Found no result");
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
				lblmsgstudent.setText("");
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

				lblmsgstudent.setText("");
				String spnr = txtspnr.getText();
				String sname = txtsname.getText();
				String saddress = txtsaddress.getText();
				String msg = "";
				while (tablemodelstudents.getRowCount() > 0) {
					tablemodelstudents.removeRow(0);
				}
				if (txtsname.getText().isEmpty() || txtspnr.getText().isEmpty() || txtsaddress.getText().isEmpty()) {
					lblmsgstudent.setText("Fill in fields");
				} else {
					try {
						msg = StudentView.addStudent(spnr, sname, saddress);
					} catch (StudentExceptions e1) {
						msg = e1.getMessage();
						lblmsgstudent.setText(msg);
					}

					lblmsgstudent.setText(msg);

				}

			}
		});
		btnSearchStudentn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblmsgstudent.setText("");
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

				String msg = "";
				try {
					msg = CourseView.getHighestThroughput();
					lblThroughPut.setText(msg);
				} catch (CourseExceptions e2) {
					lblThroughPut.setText(msg);
				}

			}
		});
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblmsgcourse.setText("");
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
				lblmsgcourse.setText("");

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
				lblmsgcourse.setText("");

				String ccode = txtcCode.getText();
				String cname = txtcName.getText();
				String creditsString = txtcCredits.getText();

				String msg = "";
				while (tablemodelcourse.getRowCount() > 0) {
					tablemodelcourse.removeRow(0);
				}

				if (txtcCode.getText().isEmpty() || txtcName.getText().isEmpty() || creditsString.isEmpty()) {
					lblmsgcourse.setText("Fill in fields");
				} else {
					int credits = Integer.parseInt(creditsString);
					try {
						msg = CourseView.addCourse(ccode, cname, credits);
					} catch (CourseExceptions e4) {
						msg = e4.getMessage();
						lblmsgcourse.setText(msg);
					}
					lblmsgcourse.setText(msg);

				}

			}

		});

		String[] headerStudentStudying = { "Course Code", "Credits" };
		tablemodelstudentstudying = new DefaultTableModel(headerStudentStudying, 0);

	}
}
