package Linkcode.shop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopDb {
	
		public static Connection getConnection() {
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
				System.out.println("connection is"+con);
			}catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("database connected");
			return con;
		}
		

	}



