package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import genericLibrary.IpathConstants.IPathConstants;

public class DatabaseUtility {
	/**
	 * This method is used to get the connection for the database
	 * @author kavya
	 */
	Connection con = null;
	
	public void connectionToDB()throws Throwable
	{
	
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection(IPathConstants.dbUrl, IPathConstants.dbUsername, IPathConstants.dbPassword);
	}
	
	/**
	 * This method is used to execute query and get the data for user
	 * @param query
	 * @param ColumnIndex
	 * @param expdate
	 * @param data
	 * @return
	 * @throws throwable
	 */
	public String executeQueryAndgetData(String query, int ColumnIndex,String expdata, String data) throws SQLException
	{	
	boolean flag = false;
	
	ResultSet result =con.createStatement().executeQuery(query);
	while(result.next())
	{
		data = result.getString(ColumnIndex);
		if(data.equalsIgnoreCase(expdata))
		{
			flag = true;
			break;
		}
	}
	if (flag)
	{
		System.out.println(data+".....>data verified");
		return expdata;
		}
	else
	{
		System.out.println(data+".....>data not verified");
		return"";
	}
	}
	public void closeDB() throws SQLException
	{
		con.close();
	}
	}


