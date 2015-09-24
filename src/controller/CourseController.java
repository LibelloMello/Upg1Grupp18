package controller;

import java.util.List;

import DAL.CourseAccess;
import exceptions.CourseExceptions;
import model.Course;

public class CourseController {
		
		public static void Create(Course course) throws CourseExceptions{
			CourseAccess.registerCourse(course);
		}
		
		public static Course Read(String cCode) throws CourseExceptions{
			return CourseAccess.getCourse(cCode);
		}
		
		public static List<Course> ReadAll() throws CourseExceptions{
			return CourseAccess.getAllCourses();
		}
		
		public static void Delete(String cCode) throws CourseExceptions{
			CourseAccess.deleteCourse(cCode);
		}
	

}


