package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Classe para mapeamento dos objetos para login e logout.
public class acessoAppObject {
	private WebDriver driver;
	
	public acessoAppObject(WebDriver driver) {
		this.driver = driver;
	}	
	public WebElement userLogin() {
		return this.driver.findElement(By.id("login_username"));
	}
	public WebElement userPassword() {
		return this.driver.findElement(By.id("login_password"));
	}
	public WebElement loginButton() {
		return this.driver.findElement(By.xpath("//input[@value='Acessar']"));
	}
	public WebElement logoutButton() {
		this.driver.findElement(By.cssSelector("#dropdown-1")).click();//ABRIR MENU PARA DESLOGAR
		return this.driver.findElement(By.id("actionmenuaction-6"));
	}
}