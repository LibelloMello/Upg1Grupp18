package DALuppgift2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import DALuppgift2.DbUtil;



public class CronusAccess {
	
	
	public static Vector<Vector<String>> getAllData(String tablename) throws Exception{
		Connection con = DbUtil.getConn();
		String SQLquery = "SELECT * FROM [" + tablename + "]";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQLquery);
		
		Vector<Vector<String>> outerList = new Vector<Vector<String>>();
		int col = 5;
		
		while(rs.next()){
			Vector<String> innerList = new Vector<String>();
			for(int i = 1; i <= col; i++){
				innerList.add(rs.getString(i));
			}
			outerList.add(innerList);
		}
		return outerList;
	}
}
