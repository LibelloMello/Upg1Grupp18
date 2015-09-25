package view;

import controller.StudentController;
import exceptions.StudentExceptions;
import model.Student;

public class StudentView {
	public static String addStudent(String spnr, String sname, String saddress) throws StudentExceptions {
		String msg = "";

		Student s = new Student();
		s.setsPnr(spnr);
		s.setsName(sname);
		s.setsAddress(saddress);

		try {
			controller.StudentController.Create(s);
			msg = "Student registered";

		} catch (StudentExceptions e) {
			msg = "Student already exists";
		}
	
		return msg;
	}

	public static String deleteStudent(String spnr) {
		String msg = "";
		Student student;
		try {
			student = StudentController.ReadStudent(spnr);

			StudentController.Delete(spnr);
			msg = "Student was deleted";	
			
			
		} catch (StudentExceptions e) {
			msg = "No student found";
		}
		

		
		return msg;
	}

}
