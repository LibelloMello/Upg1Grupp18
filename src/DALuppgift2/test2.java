package DALuppgift2;

import java.sql.SQLException;

public class test2 {

	public static void main(String[] args) {
		
		try {
			System.out.println(CronusAccess.getAllData("CRONUS Sverige AB$Employee"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
