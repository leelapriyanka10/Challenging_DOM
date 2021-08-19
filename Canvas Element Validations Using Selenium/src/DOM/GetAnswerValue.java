package DOM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAnswerValue {
	WebDriver driver;
	public GetAnswerValue(WebDriver driver) {
		this.driver=driver;
	}
static	String answer = new String();
	public  void  value() {
		ArrayList<WebElement>scripts = new ArrayList<WebElement>((ArrayList<WebElement>) driver.findElements(By.tagName("script")));
	    for(int i = 0; i < scripts.size(); i++) {
		    String focusText = scripts.get(i).getAttribute("innerHTML");
		        
		        if(focusText.contains("canvas.strokeText")) {

		                answer = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
		                
		                break;
		                
		        }
		    }
		
} 
	
}

