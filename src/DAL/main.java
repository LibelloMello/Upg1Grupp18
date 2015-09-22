package DAL;
import java.sql.SQLException;

import exceptions.CourseExceptions;

import java.sql.Connection;

public class main {
	
	public static void main(String[] args) {
		

		StudentAccess.getAllStudents();
		CourseAccess.getCourse("bla");
		
		try {
			System.out.println(CourseAccess.getAllCourses().size());
		} catch (CourseExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	

