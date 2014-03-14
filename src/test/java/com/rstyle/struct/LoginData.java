package com.rstyle.struct;

import org.testng.annotations.DataProvider;

public class LoginData {

		
	//в этом провайдере будем хранить зависимость {Логин - Пароль} --> успешность входа в систему
		
	@DataProvider(name= "loginTestData")
	public static Object[][] getLoginTestData(){
		return new Object[][] {
				{new UserData("","all"),false},
				{new UserData("all",""),false},
				{new UserData("_all","all"),false},
				{new UserData(" all","all"),false},
				{new UserData("all ","all"),false},
				{new UserData("all","all"),true},
		};
	}
	
}
