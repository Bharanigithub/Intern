package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class RegisterAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		int id = Integer.parseInt(request.getParameter("uid"));
		int flag = 0;
		Properties prop = (Properties) request.getServletContext().getAttribute("properties");

		LoginService loginService = LoginServiceImpl.getLoginServiceImpl(prop);
		UserDTO userDTO = null;
		try {
			userDTO = UserDTO.createObject();
		} catch (Exception e) {
		}
		userDTO.setUid(id);
		userDTO.setFlag(flag);
		userDTO.setUname(uname);
		userDTO.setUpass(upass);
		loginService.registerUser(userDTO);
		return "register.success";
	}
}
