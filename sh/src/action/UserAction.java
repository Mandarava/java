package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersService;
import service.impl.UsersServiceImpl;

public class UserAction extends BaseAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户信息
	 */
	private Users user = new Users();

	private UsersService usersService = new UsersServiceImpl();

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login() {
		if (usersService.usersLogin(user)) {
			session.put("loginUserName", user.getUsername());
			return "success";
		} else {
			return "fail";
		}
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@SkipValidation
	public String logout() {
		if (null != session.get("loginUserName")) {
			session.remove("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("uesrnameError", "用户名不能为空！");
		}
		if (user.getPassword().trim().length() < 6) {
			this.addFieldError("passwordError", "密码长度不少于6位！");
		}
	}

	@Override
	public Users getModel() {
		return this.user;
	}

}
