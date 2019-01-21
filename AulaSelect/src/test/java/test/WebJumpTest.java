package test;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebJumpPage;

public class WebJumpTest {

	static WebDriver driver;
	static WebJumpPage webjumpPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/danilo.barbosa/Documents/Softwares/API/chromedriver.exe");
		driver = new ChromeDriver();
		webjumpPage = new WebJumpPage(driver);

	}

	@Test
	public void testCN01() {
		webjumpPage.abreNavegador();
		webjumpPage.validarClickBotao();
		webjumpPage.validarClickBotaoFrame();
		

	}

	@Test
	public void testCN02() {
		webjumpPage.abreNavegador();
		webjumpPage.validarEscrita();

	}

}
