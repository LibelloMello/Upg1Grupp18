package _DALuppgift2;

import java.sql.SQLException;

public class test2 {

	public static void main(String[] args) {
		
		try {
			System.out.println(CronusAccess.getConstraintsMetaData());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
