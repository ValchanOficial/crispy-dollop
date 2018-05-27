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
import verificationpoints.verificacaoLoginPoint;

public class loginTestCase {
	
	private WebDriver driver;
	private conectarTask conectar;
	private verificacaoLoginPoint verificacaoPoint;
	
	@Before
	public void setUp() {
		report.startTest("Login");
		driver = drivers.getFirefoxDriver();
		conectar = new conectarTask(driver);
		verificacaoPoint = new verificacaoLoginPoint(driver);
	}
	@Test
	public void testMain() {
		driver.get("https://qa.moodle.net/");
		driver.manage().window().maximize();
		report.log(Status.INFO, "O website foi carregado.", screenshot.capture(driver));
		conectar.login("student10", "test");
		verificacaoPoint.verificarMensagemDeLogin();//VERIFICAR SE USUARIO SE CONECTOU
		report.log(Status.INFO, "Usuario conectado.", screenshot.capture(driver));
		conectar.logout();//DESLOGAR
		report.log(Status.INFO, "Usuario desconectado.", screenshot.capture(driver));
	}	
	@After
	public void tearDown() {
		driver.quit();
	}
}