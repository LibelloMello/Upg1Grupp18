package DAL;
import java.sql.SQLException;

import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;

import java.sql.Connection;

public class main {
	
	public static void main(String[] args) {
		
//		try {
//			for (Student s : StudentAccess.getAllStudents()){
//				System.out.println(s.getsName() + s.getSpnr() + s.getsAddress());
//			}
//		} catch (StudentExceptions e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			System.out.print(CourseAccess.getAllCourses());
//		} catch (CourseExceptions e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.print(StudentAccess.getAllStudents());
//		} catch (StudentExceptions e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		StudentAccess.getStudent("111");
		
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