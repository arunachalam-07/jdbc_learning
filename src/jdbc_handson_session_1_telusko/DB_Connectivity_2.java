package jdbc_handson_session_1_telusko;
//step 1: import java.sql package

import java.sql.*;

public class DB_Connectivity_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// step 2: load and register drivers
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		step3: creating connection using Connection interface
		String url="jdbc:mysql://localhost:3306/dummydb";
		String uName="arun";
		String uPass="root";
		
		Connection connection=DriverManager.getConnection(url,uName,uPass);
		
//		step4: preparing statement
//		we are using preparedStatement for inserting dynamic values and we need to pass query in prepareStatement
		String query="insert into student values(?,?)";
		int id=11;
		String name="masha";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2, name);
//		step5 : executing query
		int count=statement.executeUpdate();
		
//		executeUpdate returns number of rows affected
		
		System.out.println("no of rows affected "+count);
		
//	 step6: processing results by fetching all records
		Statement retrieveStatement=connection.createStatement();
		String retrieveQuery="select * from student";
		ResultSet result=retrieveStatement.executeQuery(retrieveQuery);
		while(result.next())
		{
			System.out.println(result.getInt(1)+" "+result.getString(2));
		}
		
//		step7: closing connection
		statement.close();
		retrieveStatement.close();
		connection.close();
	}

}
