package login.sourcesDao;

import java.beans.Statement;
import java.util.List;
import java.sql.*;

import Register.model.Registerentry;
import login.connection.DBConnection;
import login.model.Login;

public class LoginServiesImp implements LoginSerives{

	public String validateUser(List<Login> lst) {
		int i=0;

		DBConnection db=new DBConnection();
		Login log=lst.get(0);
		String msg=null;
		String str="select uname,spass from userinfo";
		try {
			Connection con=db.getConnection();			
			java.sql.Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(str);
			while(rs.next()) {
				if(rs.getString(1).equals(log.getUsername())){
					if(rs.getString(2).equals(log.getPassword())) {
					msg="valid";	
					}
					
				}
				else {
					msg="try again";
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
		
		


	}






}
