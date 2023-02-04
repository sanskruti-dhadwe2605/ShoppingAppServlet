package login.sourcesDao;

import java.util.List;

import Register.model.Registerentry;
import login.model.Login;

public interface LoginSerives {
	public String validateUser(List<Login> lst);
	
}
