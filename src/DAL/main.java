package DAL;

import java.sql.SQLException;

import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;

import java.sql.Connection;

public class main {

	public static void main(String[] args) {


		StudentAccess.getStudent("111");
		
		ShareAccess.registerStudied("111", "k1", "A");

	}
}

// .size()