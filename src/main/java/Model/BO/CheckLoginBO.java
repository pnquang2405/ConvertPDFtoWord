package Model.BO;

import DAO.CheckLoginDAO;
import Model.Bean.Account;

public class CheckLoginBO {
	public static Account CheckLogin(String id, String pw) {
		return CheckLoginDAO.CheckLogin(id, pw);
	}
}
