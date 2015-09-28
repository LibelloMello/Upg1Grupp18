package controller;

import java.util.ArrayList;
import java.util.List;

import DAL.StudentAccess;
import exceptions.StudentExceptions;
import model.Student;

public class StudentController {

	public static void Create(Student student) throws StudentExceptions {
		StudentAccess.registerStudent(student);
	}

	public static Student ReadStudent(String sPnr) throws StudentExceptions {
		return StudentAccess.getStudent(sPnr);
	}

	public static List<Student> ReadAll() throws StudentExceptions {
		return StudentAccess.getAllStudents();
	}

	public static void Delete(String sPnr) throws StudentExceptions {
		StudentAccess.deleteStudent(sPnr);
	}

}
