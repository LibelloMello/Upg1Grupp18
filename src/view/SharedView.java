package view;

import controller.SharedController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Studying;
import model.Course;
import model.Studied;

public class SharedView {

	public static String readResult(String sPnr, String cCode) {
		String msg = "";
		Studied s = new Studied();

		try {

			controller.SharedController.ReadResult(sPnr, cCode);
			msg = "Found student";
		} catch (StudentExceptions e) {
			msg = "Found no student";
		}

		return msg;
	}

}
