package view;

import controller.CourseController;
import controller.StudentController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;

public class CourseView {

	public static String addCourse(String ccode, String cname, int credits) throws CourseExceptions {
		String msg = "";

		Course c = new Course();
		c.setCcode(ccode);
		c.setCname(cname);
		c.setCredits(credits);

		try {
			controller.CourseController.CreateCourse(c);
			msg = "Course registered";

		} catch (CourseExceptions e) {
			msg = "Course already exists";
		}

		return msg;
	}

	public static String deleteCourse(String ccode) throws CourseExceptions {
		String msg = "";
		Course course;
		try {
			course = CourseController.ReadCourse(ccode);
			CourseController.DeleteCourse(ccode);
			msg = "Course was deleted";

		} catch (CourseExceptions e) {
			msg = "No course found";
		}

		return msg;
	}

	public static Course getCourse(String cCode) throws CourseExceptions {
		String msg = "";
		Course course = null;
		try {
			course = CourseController.ReadCourse(cCode);
			msg = "Course was found";

		} catch (CourseExceptions e) {
			msg = "Course was not found";

		}
		return course;

	}
	public static String getHighestThroughput () throws CourseExceptions {
		String msg = "";
		try {
			msg = CourseController.readThroughput();
		} catch (CourseExceptions e) {
			msg ="Couldn't find a course";
		} return msg;
	}
}
