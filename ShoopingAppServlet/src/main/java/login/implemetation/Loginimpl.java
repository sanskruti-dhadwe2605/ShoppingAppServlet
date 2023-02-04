package login.implemetation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Register.model.Registerentry;
import login.connection.DBConnection;
import login.sourcesDao.LoginDao;



public class Loginimpl implements LoginDao {

	@Override
	
	public int create(List<Registerentry> lst) {
		int i=0;
		
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pst=con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?)");
			Registerentry u=lst.get(0);
			pst.setInt(1, u.getRno());
			pst.setString(2, u.getFname());
			pst.setString(3, u.getLname());
			pst.setString(4, u.getUname());
			pst.setString(5, u.getMobno());
			pst.setString(6, u.getSpass());
			pst.setString(7, u.getRepass());
			pst.setDouble(8, u.getAmount());
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return i;
	}

}
