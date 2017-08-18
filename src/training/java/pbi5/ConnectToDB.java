package training.java.pbi5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectToDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectToDB connServer = new ConnectToDB();
		connServer.DBConnect("jdbc:sqlserver://jptrainingsql", "wolverine", "j4lakbaLi");
	}
	
	public void DBConnect(String cn, String username, String pass){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(cn,username,pass);
			System.out.println("Connected");
			Statement statement = conn.createStatement();
			String queryString = "Select * From Trainee";
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()){
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
		}
		catch(Exception ex){
			System.out.print(ex);
		}
		
	}

}
