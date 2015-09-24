package controller;

import java.util.List;

import DAL.CourseAccess;
import exceptions.CourseExceptions;
import model.Course;

public class CourseController {
		
		public static void CreateCourse(Course course) throws CourseExceptions{
			CourseAccess.registerCourse(course);
		}
		
		public static Course ReadCourse(String cCode) throws CourseExceptions{
			return CourseAccess.getCourse(cCode);
		}
		
		public static List<Course> ReadAllCourses() throws CourseExceptions{
			return CourseAccess.getAllCourses();
		}
		
		public static void DeleteCourse(String cCode) throws CourseExceptions{
			CourseAccess.deleteCourse(cCode);
		}
	

}


