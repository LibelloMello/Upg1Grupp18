package controller;

import java.util.List;

import DAL.ShareAccess;
import DAL.StudentAccess;
import exceptions.StudentExceptions;
import model.Student;
import model.Studied;
import model.Studying;

public class SharedController {
/*
	public static void CreateStudied(Studied s) throws StudentExceptions {
		ShareAccess.registerStudent(s);
	}
	public static void CreateStudying (Studying s) throws StudentExceptions {
		ShareAccess.registerStudentOnCourse(sPnr, cCode);
	}
*/
	public static List<Studied> ReadAllStudied(String ccode) throws StudentExceptions {
		return ShareAccess.getAllStudied(ccode);
	}

	public static void DeleteStudying(String sPnr) throws StudentExceptions {
		StudentAccess.deleteStudent(sPnr);
	}
	public static Studied ReadResult (String sPnr, String cCode) throws StudentExceptions {
		return ShareAccess.getResult(sPnr, cCode);
	}
	
	public static List<Studying> ReadAllStudying(String ccode) throws StudentExceptions {
		return ShareAccess.getAllStudying(ccode);
	}

}
