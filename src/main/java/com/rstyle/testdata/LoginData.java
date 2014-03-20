package com.rstyle.testdata;

import org.testng.annotations.DataProvider;

import com.rstyle.struct.UserData;

public class LoginData {

		
	//в этом провайдере будем хранить зависимость {Логин - Пароль} --> успешность входа в систему
		
	@DataProvider(name= "loginTestData")
	public static Object[][] getLoginTestData(){
		return new Object[][] {
				{new UserData("","oper1"),false},
				{new UserData("oper1",""),false},
				{new UserData("_oper1","oper1"),false},
				{new UserData(" oper1","oper1"),false},
				{new UserData("oper1 ","oper1"),false},
				{new UserData("oper1","oper1"),true},
		};
	}
	
}
