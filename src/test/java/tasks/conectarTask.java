package tasks;

import org.openqa.selenium.WebDriver;
import appobjects.acessoAppObject;

public class conectarTask {
	private acessoAppObject home;
	
	public conectarTask(WebDriver driver){
		this.home = new acessoAppObject(driver);
	}
	public void login(String username, String password) {
		home.userLogin().sendKeys(username);
		home.userPassword().sendKeys(password);
		home.loginButton().click();
	}
	public void logout() {
		home.logoutButton().click();
	}
}