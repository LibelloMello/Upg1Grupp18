package view;

import java.util.List;

import controller.SharedController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Studying;
import model.Course;
import model.Studied;

public class SharedView {

	public static Studied readResult(String sPnr, String cCode) throws StudentExceptions {
		String msg = "";
		Studied s = new Studied();

		try {
			
			s = controller.SharedController.ReadResult(sPnr, cCode);
			msg = "Found student";
		} catch (StudentExceptions e) {
			msg = "Found no student";
		}

		return s;
	}
	public static List<Studying> readAllStudentsOnCourse(String ccode) throws StudentExceptions {
		List<Studying> studyingList = null;
		try {
			studyingList = SharedController.ReadAllStudying(ccode);
		}catch (StudentExceptions e) {
			
		}
		return studyingList;
	}
	public static List<Studied> readAllFinishedStudents(String ccode) throws StudentExceptions {
		List<Studied> studiedList = null;
		try {
			studiedList = SharedController.ReadAllStudied(ccode);
		}catch (StudentExceptions e) {
			
		}
		return studiedList;
	}
	public static int readPercentAonCourse(String ccode) throws StudentExceptions {
		int percentA = 0;
		try {
			percentA = SharedController.readPercentA(ccode);
		}catch (StudentExceptions e) {
			
		}
		return percentA;
	}
	public static int registerStudentOnCourse(String spnr, String ccode) throws StudentExceptions {
		int i = 0;
		try {
			i = SharedController.registerStudentOnCourse(spnr, ccode);
		}catch(StudentExceptions e) {
			
		}
		return i;
	}
	public static void deleteStudyingFromCourse(String spnr, String ccode)throws StudentExceptions {
		try{
			SharedController.DeleteStudying(spnr, ccode);
		}catch (StudentExceptions e) {
			
		}
	}
	public static void registerFinishedStudent(String spnr, String ccode, String grade) throws StudentExceptions {
		try{
			SharedController.registerFinishedStudent(spnr, ccode, grade);
		} catch (StudentExceptions e) {
			
		}
	}

}
