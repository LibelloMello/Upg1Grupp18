package view;

import controller.CourseController;
import exceptions.CourseExceptions;
import model.Course;

public class CourseView {

	public String addCourse(String ccode, String cname, int credits) {
		String msg = "";
		
		Course c = new Course();
		c.setCcode(ccode);
		c.setCname(cname);
		c.setCredits(credits);

		try {
			controller.CourseController.Create(c);
			msg = "gick";
			
		} catch (CourseExceptions e) {
			msg = "Gick inte";
		}
		
		return msg;
	}
	
	}


