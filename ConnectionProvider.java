package admin;
import java.sql.*;
public class ConnectionProvider {
public static Connection getCon()
{
//Connection con;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false","root","root123");
return con;
}
catch(Exception e)
{
System.out.println("Here is exception" );
e.printStackTrace();
return null;
}
//return con;
}
}
