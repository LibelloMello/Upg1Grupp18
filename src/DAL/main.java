package DAL;
import java.sql.SQLException;

import exceptions.CourseExceptions;
import model.Course;

import java.sql.Connection;

public class main {
	
	public static void main(String[] args) {
		
		ShareAccess.getFinishedStudents("k1");
		
//try {
//	for (Course c : CourseAccess.getAllCourses()) {
//		System.out.println(c.getCcode() + " " + c.getCname() + " " + (c.getCredits()));
//
//	}
//} catch (CourseExceptions e1) {
//	e1.printStackTrace();
//}
//		
//		try {
//			System.out.println(CourseAccess.getAllCourses());
//		} catch (CourseExceptions e) {
//			e.printStackTrace();
//		}
		
	}
}
	

//.size()