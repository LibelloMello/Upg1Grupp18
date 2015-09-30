package controller;

import java.util.List;

import DAL.ShareAccess;
import DAL.StudentAccess;
import exceptions.StudentExceptions;
import model.Student;
import model.Studied;
import model.Studying;

public class SharedController {

	public static List<Studied> ReadAllStudied(String ccode) throws StudentExceptions {
		return ShareAccess.getAllStudied(ccode);
	}

	public static void DeleteStudying(String sPnr, String ccode) throws StudentExceptions {
		ShareAccess.deleteFromStudying(sPnr, ccode);
	}

	public static Studied ReadResult(String sPnr, String cCode) throws StudentExceptions {
		return ShareAccess.getResult(sPnr, cCode);
	}

	public static List<Studying> ReadAllStudying(String ccode) throws StudentExceptions {
		return ShareAccess.getAllStudying(ccode);
	}

	public static int readPercentA(String ccode) throws StudentExceptions {
		return ShareAccess.getPercentA(ccode);
	}

	public static int registerStudentOnCourse(String spnr, String ccode) throws StudentExceptions {
		return ShareAccess.registerStudentToCourse(spnr, ccode);
	}

	public static void registerFinishedStudent(String spnr, String ccode, String grade) throws StudentExceptions {
		ShareAccess.registerStudied(spnr, ccode, grade);
	}

}
