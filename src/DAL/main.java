package DAL;

import java.sql.SQLException;

import controller.SharedController;
import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;
import model.Studied;
import view.CourseView;
import view.SharedView;
import view.StudentView;

import java.sql.Connection;

public class main {

	public static void main(String[] args) {
	
	

			
		try {
			System.out.print(SharedView.readResult("111", "k1").getsGrade());
		} catch (StudentExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//	try {
//		CourseAccess.deleteCourse("ccode");
//	} catch (CourseExceptions e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
//		 try {
//		 ShareAccess.registerStudentOnCourse("777", "bla");
//		 } catch (StudentExceptions e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
	}

}
