package Sql;

import java.sql.*;

public class Sql {
 public static void main(String [] args)
 {
  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Shoms";
  String userName="sa";
  String userPwd="sasasa";
 try
{
	Class.forName(driverName);
	System.out.println("���������ɹ���");
}catch(Exception e){
	e.printStackTrace();
	System.out.println("��������ʧ�ܣ�");
}
try{
	Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		System.out.println("�������ݿ�ɹ���");
}catch(Exception e)
{
	e.printStackTrace();
	System.out.print("SQL Server����ʧ�ܣ�");
}		
}
}
