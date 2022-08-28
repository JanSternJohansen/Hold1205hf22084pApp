package dk.tec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBTools 
{
	private Connection con;
	private Statement stmt;
	private String connectionString = "jdbc:sqlserver://localhost;databaseName=ApiDB;encrypt=true;trustServerCertificate=true";
	
	
	//"jdbc:sqlserver://localhost\\JansSqlServer:1433;databaseName=ApiDB";
	
	private void connect()
	{	
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionString, "sa", "1234");
				stmt = con.createStatement();
				
			} catch (ClassNotFoundException e) 
			{				
				e.printStackTrace();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}		
	}
	
	public Elev getElevById(int id)
	{
		Elev theElev = null;
		connect();
		ResultSet result;
		String selectStr = String.format("Select * from Elev where id = %d", id);
		
		try 
		{
			result = stmt.executeQuery(selectStr);
			if(result.next())
			{
				theElev = new Elev();
				theElev.setId(result.getInt("id"));
				theElev.setName(result.getString("name"));
				theElev.setJob(result.getString("job"));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return theElev;		
	}

	public List<Elev> getAllElev(){ return null;}
	public void insertNewElev(Elev e) {}
	public void updateElev(Elev e) {}
	public void deleteElev(int id) {}
}
