package com.ggf.designPattern;

public class test {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();

		((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
		userService.getUser();
	}

}
