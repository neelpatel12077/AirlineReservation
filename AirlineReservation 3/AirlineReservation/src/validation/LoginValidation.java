package validation;
import dao.*;
public class LoginValidation {
	
//	public boolean checkMobile(long user_mobile)
//	{
//		if(user_mobile<0 && user_mobile>999999999)
//		{ //access user mobile number from database
//			return false;
//		}
//		return true;
//	}
//	public boolean checkPassword(String user_password)
//	{//access password from database 
//		if(user_password.length()==0)
//		{ //access user mobile number from database
//			return false;
//		}
//		return true;
//	}
//	public boolean checkAll(long user_mobile, String user_password) {
//		if(checkMobile(user_mobile))  
//			return true;
//		else if(checkPassword(user_password))
//			return true;
//		else
//			return false;
//	}
	public boolean checkAll()
	{
		LoginDao logindao = new LoginDao();
		if(logindao.checkLogin())
		{
			System.out.println();
			return true;
		}
		return false;
	}
}
