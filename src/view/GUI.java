package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class GUI {

	private JFrame frame;
	private JTextField txtspnr;
	private JTextField txtsname;
	private JTextField txtsaddress;
	private JTextField txtcCode;
	private JTextField txtcName;
	private JTextField txtcCredits;
	private JTextField txtspnrreg;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentPnr = new JLabel("Student ID");
		lblStudentPnr.setBounds(10, 11, 97, 14);
		frame.getContentPane().add(lblStudentPnr);
		
		txtspnr = new JTextField();
		txtspnr.setBounds(117, 8, 159, 20);
		frame.getContentPane().add(txtspnr);
		txtspnr.setColumns(10);
		
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
		btnRegisterStudent.setBounds(10, 103, 133, 23);
		frame.getContentPane().add(btnRegisterStudent);
		
		JButton btnSearchStudentn = new JButton("Search Student");
		btnSearchStudentn.setBounds(153, 103, 133, 23);
		frame.getContentPane().add(btnSearchStudentn);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(75, 137, 123, 23);
		frame.getContentPane().add(btnDeleteStudent);
		
		txtcCode = new JTextField();
		txtcCode.setBounds(446, 8, 178, 20);
		frame.getContentPane().add(txtcCode);
		txtcCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Course Code");
		lblNewLabel.setBounds(349, 11, 87, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(349, 36, 87, 14);
		frame.getContentPane().add(lblCourseName);
		
		txtcName = new JTextField();
		txtcName.setBounds(446, 33, 178, 20);
		frame.getContentPane().add(txtcName);
		txtcName.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(349, 61, 77, 14);
		frame.getContentPane().add(lblCredits);
		
		txtcCredits = new JTextField();
		txtcCredits.setBounds(446, 58, 178, 20);
		frame.getContentPane().add(txtcCredits);
		txtcCredits.setColumns(10);
		
		JButton btnRegisterCourse = new JButton("Register Course");
		btnRegisterCourse.setBounds(389, 103, 144, 23);
		frame.getContentPane().add(btnRegisterCourse);
		
		JButton btnSearchCourse = new JButton("Search Course");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchCourse.setBounds(543, 103, 133, 23);
		frame.getContentPane().add(btnSearchCourse);
		
		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setBounds(472, 137, 123, 23);
		frame.getContentPane().add(btnDeleteCourse);
		
		JLabel lblmsgcourse = new JLabel("Message:");
		lblmsgcourse.setBounds(428, 171, 232, 14);
		frame.getContentPane().add(lblmsgcourse);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(10, 282, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtspnrreg = new JTextField();
		txtspnrreg.setBounds(117, 279, 230, 20);
		frame.getContentPane().add(txtspnrreg);
		txtspnrreg.setColumns(10);
		
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setBounds(10, 307, 87, 14);
		frame.getContentPane().add(lblSelectCourse);
		
		table = new JTable();
		table.setBounds(25, 171, 322, 72);
		frame.getContentPane().add(table);
		
		JComboBox cmbcourse = new JComboBox();
		cmbcourse.setBounds(117, 304, 230, 17);
		frame.getContentPane().add(cmbcourse);
		
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
		
		table_1 = new JTable();
		table_1.setBounds(270, 421, 77, 23);
		frame.getContentPane().add(table_1);
		
		JLabel lblStudentsGrade = new JLabel("Grade:");
		lblStudentsGrade.setBounds(225, 426, 80, 14);
		frame.getContentPane().add(lblStudentsGrade);
	}
}
