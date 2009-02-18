/**
 * 
 */
package fr.slcms.rdf4lom;

import java.sql.*;
/**
 * @author Radu
 *
 */
public class SaveToDB {

	public String SaveCommentsToDB(ComAndVisits passCoViObj) {
		 try {
		      Statement stmt;

		      //Register the JDBC driver for MySQL.
		      Class.forName("com.mysql.jdbc.Driver");

		      //Define URL of database server for
		      // database named JunkDB on the localhost
		      // with the default port number 3306.
		      String url = "jdbc:mysql://localhost:3306/rdf4lom";

		      //Get a connection to the database for a
		      // user named auser with the password
		      // drowssap, which is password spelled
		      // backwards.
		      Connection con = DriverManager.getConnection(url,"root", "slcms32cd2501");

		      //Display URL and connection information
		      //System.out.println("URL: " + url);
		      //System.out.println("Connection: " + con);

		      //Get a Statement object
		      stmt = con.createStatement();

		      //Insert some values into the table
		      stmt.executeUpdate("INSERT INTO comments(comment) VALUES ('"+ passCoViObj.comments +"')");

		      con.close();
		    }catch( Exception e ) {
		      e.printStackTrace();
		    }//end catch
		return "OK";
	}
	
	public String SaveVisitsToDB(ComAndVisits passCoViObj) {
		 try {
		      Statement stmt;

		      //Register the JDBC driver for MySQL.
		      Class.forName("com.mysql.jdbc.Driver");

		      //Define URL of database server for
		      // database named JunkDB on the localhost
		      // with the default port number 3306.
		      String url = "jdbc:mysql://localhost:3306/rdf4lom";

		      //Get a connection to the database for a
		      // user named auser with the password
		      // drowssap, which is password spelled
		      // backwards.
		      Connection con = DriverManager.getConnection(url, "root", "slcms32cd2501");

		      //Display URL and connection information
		      //System.out.println("URL: " + url);
		      //System.out.println("Connection: " + con);

		      //Get a Statement object
		      stmt = con.createStatement();

		      //Insert some values into the table
		      stmt.executeUpdate("INSERT INTO visits(name, organisation, email) VALUES ('"+ passCoViObj.name +"', '"+ passCoViObj.organisation +"', '"+ passCoViObj.email +"')");

		      con.close();
		    }catch( Exception e ) {
		      e.printStackTrace();
		    }//end catch
		return "OK";
	}
}
