package DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import DOM.GetAnswerValue;

public class CanvasValidation {
	
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
	}
	
	
  @Test(priority=0)
  public void buttonValueValidate() {
		
		
	 GetAnswerValue dom = new GetAnswerValue(driver);
	 dom.value();
	 System.out.println("Initial Value: "+dom.answer);
	 String oldValue= dom.answer;		
	 driver.findElement(By.className("button")).click();
	 dom.value();
	 System.out.println("After clicking on Button: " +dom.answer);
	 String newValue = dom.answer;
	 Assert.assertNotEquals(oldValue, newValue);
		
  }
  @Test(priority=1)
  public void buttonAlertValueValidate() {
		
		
	 GetAnswerValue dom = new GetAnswerValue(driver);
	
	 System.out.println("Initial Value"+dom.answer);
	 String oldValue= dom.answer;		
     driver.findElement(By.xpath("//a[@class='button alert']")).click();
	 dom.value();
	 System.out.println("After clicking on Button Alert" +dom.answer);
	 String newValue = dom.answer;
	 Assert.assertNotEquals(oldValue, newValue);
		
  }
  @Test(priority=2)
  public void buttonSuccessValueValidate() {
		
		
	 GetAnswerValue dom = new GetAnswerValue(driver);
	 System.out.println("Initial Value"+dom.answer);
	 String oldValue= dom.answer;		
	 driver.findElement(By.xpath("//a[@class='button success']")).click();
	 dom.value();
	 System.out.println("After clicking on Button Success" +dom.answer);
	 String newValue = dom.answer;
	 Assert.assertNotEquals(oldValue, newValue);
		
  }
}
