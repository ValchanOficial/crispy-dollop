package verificationpoints;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import framework.report;
import framework.screenshot;

public class verificacaoLoginComReturnPoint {
	private WebDriver driver;
	//FALHA AO CONECTAR
	private static final String INVALID_LOGIN_MESSAGE = "Nome de usuário ou senha errados. Por favor tente outra vez.";
	//CONECTADO
	private static final String LOGIN_MESSAGE = "You are logged in as";	
	
	public verificacaoLoginComReturnPoint(WebDriver driver) {
		this.driver = driver;
	}
	//CONECTADO
	public String verificarMensagemDeLogin() {
		String resultado;
		if(this.pageContains(LOGIN_MESSAGE)) {
			report.log(Status.PASS, "Mensagem exibida corretamente",screenshot.capture(driver));
			resultado = LOGIN_MESSAGE;
		} else {
			report.log(Status.FAIL, "Mensagem nao exibida conforme esperado.", screenshot.capture(driver));
			resultado = INVALID_LOGIN_MESSAGE;
		}
		return resultado;
	}
	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
}