package controller;
	import java.util.ArrayList;
	import java.util.List;

import DAL.StudentAccess;
import exceptions.StudentExceptions;
import model.Student;
	
public class StudentController {

		
		public static void Create(Student student) throws StudentExceptions{
			StudentAccess.registerStudent(spnr, sname, saddress);(student);
		}
		
		public static Student Read(String heroName) throws StudentExceptions{
			return HeroAccess.Read(heroName);
		}
		
		public static List<Hero> ReadAll() throws StudentExceptions{
			return HeroAccess.ReadAll();
		}
		
		public static void Delete(String heroName) throws StudentExceptions{
			HeroAccess.Delete(heroName);
		}
	}

}
