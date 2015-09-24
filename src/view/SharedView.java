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

			msg = controller.SharedController.ReadResult(sPnr, cCode).getsGrade();

		} catch (StudentExceptions e) {
			msg = "Gick inte";
		}

		return msg;
	}

}
