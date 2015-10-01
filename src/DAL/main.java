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
				System.out.println(ShareAccess.getStudentsCourses("222"));
			} catch (StudentExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	}

}
