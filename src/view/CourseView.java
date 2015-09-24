package view;

import controller.CourseController;
import controller.StudentController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;

public class CourseView {

	public static String addCourse(String ccode, String cname, int credits) {
		String msg = "";

		Course c = new Course();
		c.setCcode(ccode);
		c.setCname(cname);
		c.setCredits(credits);

		try {
			controller.CourseController.CreateCourse(c);
			msg = "gick";

		} catch (CourseExceptions e) {
			msg = "Gick inte";
		}

		return msg;
	}
	public static String deleteCourse(String ccode) {
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
	
	




}
