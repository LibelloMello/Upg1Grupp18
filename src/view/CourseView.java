package view;

import DAL.CourseAccess;
import controller.CourseController;
import exceptions.CourseExceptions;
import model.Course;

public class CourseView {

	public void addCourse() {
		String cCode;
		String cName;
		int cCredits;
		
		cCode =
		cName = (I controller/Jtable)
		cCredits
		
		Course course = new Course();
		course.setCcode(cCode);
		course.setCname(cName);
		course.setCredits(cCredits);
		
		try {
			CourseController.Create(course);
			
			
		} catch (CourseExceptions e) {
			
		}
		
	}
	
	}


