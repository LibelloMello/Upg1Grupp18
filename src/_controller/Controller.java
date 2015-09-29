package _controller;

import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

import _DALuppgift2.CronusAccess;

public class Controller {
	
	public static Vector<String> getStandardMetaData(String tablename) throws SQLException{
		return CronusAccess.getStandardMetaData(tablename);
	}
	
	public static Vector<Vector<String>> getStandardData(String tablename)throws SQLException{
		return CronusAccess.getAllData(tablename);
	}
	public static Vector<Vector<String>> getKeys()throws SQLException{
		return CronusAccess.getKeys();
		}
	public static Vector<String> getKeysMetaData()throws SQLException{
		return CronusAccess.getKeysMetaData();
	}
	public static Vector<Vector<String>> getIndexes()throws SQLException{
		return CronusAccess.getIndexes();
		}
	public static Vector<String> getIndexesMetaData()throws SQLException{
		return CronusAccess.getIndexesMetaData();
		}
	public static Vector<Vector<String>> getConstraints()throws SQLException{
		return CronusAccess.getConstraints();
		}
	public static Vector<String> getConstraintsMetaData()throws SQLException{
		return CronusAccess.getConstraintsMetaData();
		}

	

}
