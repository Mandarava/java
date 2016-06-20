package junit;

import org.junit.Test;

import entity.Users;
import junit.framework.Assert;
import service.UsersService;
import service.impl.UsersServiceImpl;

public class TestUsersServiceImpl {

	@Test
	public void testUsersLogin() {
		Users user = new Users(1, "zhangsan", "123456");
		UsersService userService = new UsersServiceImpl();
		Assert.assertEquals(true, userService.usersLogin(user));
	}

}
