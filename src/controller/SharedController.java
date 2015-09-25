package controller;

import java.util.List;

import DAL.ShareAccess;
import DAL.StudentAccess;
import exceptions.StudentExceptions;
import model.Student;
import model.Studied;

public class SharedController {

	public static void CreateStudied(Studied s) throws StudentExceptions {
		ShareAccess.registerStudent(s);
	}

	public static List<Student> ReadAllStudied() throws StudentExceptions {
		return StudentAccess.getAllStudents();
	}

	public static void DeleteStudying(String sPnr) throws StudentExceptions {
		StudentAccess.deleteStudent(sPnr);
	}
	public static Studied ReadResult (String sPnr, String cCode) throws StudentExceptions {
		return ShareAccess.getResult(sPnr, cCode);
	}

}