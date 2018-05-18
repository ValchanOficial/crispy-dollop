package testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import verification.LoginVerification;

public class LoginTestCase {
	private WebDriver driver;
	private LoginVerification verification;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();;//configura para o navegador
		this.driver = new FirefoxDriver();//ChromeDriver ou qualquer navegador
		this.driver.get("https://qa.moodle.net/");//referencia site a ser testado
		this.verification = new LoginVerification(driver);
	}
	@Test
	public void testMain() {
		WebElement usernameTextField = this.driver.findElement(By.id("login_username"));
		WebElement passwordTextField = this.driver.findElement(By.id("login_password"));
		usernameTextField.sendKeys("student7");
		passwordTextField.sendKeys("test");
		//conectar o user
		this.driver.findElement(By.cssSelector("#login > div:nth-child(4) > input")).click();
		this.verification.checkLogin();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dropdown-1")));//esperando elemento da p�gina carregar
		//desconectar user
		this.driver.findElement(By.id("dropdown-1")).click();
		this.driver.findElement(By.id("actionmenuaction-6")).click();
	}
	
	@After
	public void tearDown() {
		this.driver.quit();
	}
}