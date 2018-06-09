package testcase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import categorias.Smoke;
import framework.drivers;
import framework.report;
import framework.screenshot;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import tasks.conectarTask;
import verificationpoints.verificacaoLoginComReturnPoint;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class loginTestComParamCase {

	private WebDriver driver;
	private conectarTask conectar;
	private verificacaoLoginComReturnPoint verificacaoPoint;
	
	@BeforeClass
	public static void initTest() {
		report.create("Moodle QA Testing Site", "Suite de Regressao");
	}

	@Before
	public void setUp() {
		report.startTest("Login");
		driver = drivers.getFirefoxDriver();
		conectar = new conectarTask(driver);
		verificacaoPoint = new verificacaoLoginComReturnPoint(driver);
	}
	@Test
	@Category(Smoke.class)//negativo 
	@FileParameters("./resources/testAccounts.csv")//falha intencional dentro do arquivo de testes .csv
	public void testWithParams(String login, String senha, String mensagem) {
		driver.get("https://qa.moodle.net/");
		driver.manage().window().maximize();
		report.log(Status.INFO, "O website foi carregado.", screenshot.capture(driver));
		conectar.login(login,senha); //CONECTANDO...
		assertEquals(mensagem,verificacaoPoint.verificarMensagemDeLogin()); //VERIFICA SE CONECTOU
		report.log(Status.INFO, "Usuario conectado.", screenshot.capture(driver));
		conectar.logout();//DESLOGAR
		report.log(Status.INFO, "Usuario desconectado.", screenshot.capture(driver));
	}	
	@After
	public void tearDown() {
		driver.quit();
	}
	@AfterClass
	public static void endTest() {
		report.close();
	}
}