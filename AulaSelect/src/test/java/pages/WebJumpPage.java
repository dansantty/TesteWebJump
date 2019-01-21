package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebJumpPage {

	static WebDriver driver;
	static WebDriverWait wait;

	public WebJumpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void abreNavegador(){
		driver.get("https://webjump-user.github.io/testqa/");
		driver.manage().window().maximize();
	}

	public void validarClickBotao() {
		wait = new WebDriverWait(driver, 10);

		WebElement botao1 = driver.findElement(By.id("btn_one"));
		botao1.click();
		WebElement botao2 = driver.findElement(By.id("btn_two"));
		botao2.click();
		WebElement botaofour = driver.findElement(By.id("btn_link"));
		botaofour.click();

		if (wait.until(ExpectedConditions.invisibilityOf(botao1))) {
			System.out.println(
					"Bot�o One Invisivel"); /*
											 * Se o elemento estiver visivel na
											 * tela o codigo falha ap�s o tempo
											 * de exce��o da variavel wait, pois
											 * dentro da clausula
											 * ExpectedCondition, � v�lido
											 * somente se o elemento estiver de
											 * acordo com as condi��es.
											 */
		}

		if (wait.until(ExpectedConditions.invisibilityOf(botao2))) {
			System.out.println("Bot�o Two Invisivel");
		}

		if (wait.until(ExpectedConditions.invisibilityOf(botaofour))) {
			System.out.println("Bot�o Four Invisivel");
		}
	}

	public void validarClickBotaoFrame() {
		wait = new WebDriverWait(driver, 10);

		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframe_panel_body > iframe:nth-child(1)")));

		WebElement botao1 = driver.findElement(By.xpath("//*[@id='btn_one']"));
		botao1.click();
		WebElement botao2 = driver.findElement(By.xpath("//*[@id='btn_two']"));
		botao2.click();
		WebElement botaofour = driver.findElement(By.xpath("//*[@id='btn_link']"));
		botaofour.click();

		if (wait.until(ExpectedConditions.invisibilityOf(botao1))) {
			System.out.println("Bot�o One IFrame Invisivel");
		}

		if (wait.until(ExpectedConditions.invisibilityOf(botao2))) {
			System.out.println("Bot�o Two IFrame Invisivel");
		}

		if (wait.until(ExpectedConditions.invisibilityOf(botaofour))) {
			System.out.println("Bot�o Four IFrame Invisivel");
		}
	}

	public void validarEscrita() {
		wait = new WebDriverWait(driver, 10);

		driver.findElement(By.id("btn_one")).click();

		driver.findElement(By.id("first_name")).sendKeys("Teste Web Jump");

		Select example = new Select(driver.findElement(By.id("select_box")));
		example.selectByValue("option_two");

		driver.findElement(By.id("opt_three")).click();

		if (wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/img[4]")))
				.isDisplayed()) {
			System.out.println("Imagem Selenium WebDriver est� presente na DOM");
		} else {
			System.out.println("Imagem Selenium WebDriver n�o est� presente na DOM");
		}

	}

}
