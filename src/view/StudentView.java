package view;

import java.util.List;

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

	public static String deleteStudent(String spnr) throws StudentExceptions {
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

	public static Student getStudent(String spnr) throws StudentExceptions {
		String msg = "";
		Student student = null;
		try {
			student = StudentController.ReadStudent(spnr);
			msg = "Student was found";

		} catch (StudentExceptions e) {
			msg = "Student was not found";
			
		}
		return student;

	}
	public static List<Student> getAllStudents() throws StudentExceptions {
		List<Student> list = null;
		try {
			list = StudentController.ReadAll();
		}catch (StudentExceptions e) {
			
		}
		return list;
	}

}
