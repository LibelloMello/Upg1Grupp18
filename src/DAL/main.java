package DAL;

import java.sql.SQLException;

import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;

import java.sql.Connection;

public class main {

	public static void main(String[] args) {
		
	
		try {
			System.out.print(ShareAccess.getAllStudying("k1"));
		} catch (StudentExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	


	}
}
