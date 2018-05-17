package verification;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

public class LoginVerification {
	private WebDriver driver;
	public LoginVerification(WebDriver driver) {
		this.driver = driver;
	}
		//verificationPoint
		public void checkLogin() {
			//verificaçãoComAssertTrue
			assertTrue(this.driver.getPageSource().contains("You are logged in as"));
		}
}