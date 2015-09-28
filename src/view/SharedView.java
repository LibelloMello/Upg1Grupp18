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

}
