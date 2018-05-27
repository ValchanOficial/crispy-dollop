package testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import framework.drivers;
import framework.report;
import framework.screenshot;
import tasks.conectarTask;

public class loginSenhaErradaTestCase {
	
	private WebDriver driver;
	private conectarTask conectar;
	
	@Before
	public void setUp() {
		report.startTest("Registrando Falhas");
		driver = drivers.getFirefoxDriver();
		conectar = new conectarTask(driver);
	}
	@Test
	public void testMain() {
		driver.get("https://qa.moodle.net/");
		driver.manage().window().maximize();
		report.log(Status.INFO, "O website foi carregado.", screenshot.capture(driver));
		conectar.login("student","aaaaaaa");//erro intencional
		report.log(Status.INFO, "Falha ao conectar. Realizando login com senha inválida.", screenshot.capture(driver));
	}	
	@After
	public void tearDown() {
		driver.quit();
	}
}