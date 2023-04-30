package jdbc_handson_session_1_telusko;

//step 1: importing java.sql package.
import java.sql.*;

public class DB_connectivity {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * JDBC connectivity
		 * 
		 * we need to follow below steps: 1.import java.sql package 
		 *  2.load and register driver
		 *  3.create connection(Connection) 
		 *  4.create statement (Statement)
		 *  5.execute statement(executeQuery,executeQueryUpdate)
		 *  6.process results(resultSet)
		 *  7.close connection
		 */

//		step2: load and register driver using Class.forName

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/dummydb";
		String uName = "arun";
		String uPass = "root";
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		
//		step3 : creating connection (Connection) . Connection is a interface. we will use getConnection

		dbConnection = DriverManager.getConnection(url, uName, uPass);

//		step 4:Creating Statement 

		statement = dbConnection.createStatement();

		String query = "select * from student";

//		step 5: executing query using excuteQuery and storing in ResultSet object
		result = statement.executeQuery(query);

//		step 6: processing results
		while(result.next())
		{
			System.out.println(result.getInt(1)+" "+result.getString(2));
		}
		
//		step 7: closing connection
		statement.close();
		dbConnection.close();

	}

}
