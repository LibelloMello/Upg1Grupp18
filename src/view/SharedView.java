package view;

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

}
