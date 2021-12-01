package Model.BO;

import DAO.SignupDAO;

public class SignupBO {
	public static void signup(String id, String pw) {
		SignupDAO.signup(id,pw);
		
	}
}
