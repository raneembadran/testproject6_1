import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	WebDriver driver = new ChromeDriver();  

	@BeforeTest

	public void setup()  {
		 
		driver.get("https://www.saucedemo.com/"); 
		driver.manage().window().fullscreen();  
	
	}
	@Test(priority=1)
	public void Log_in() throws InterruptedException {   
      WebElement UserName=	driver.findElement(By.id("user-name"));
       UserName  .sendKeys("standard_user");
       WebElement PasswordInputField=	driver.findElement(By.id("password"));
       PasswordInputField.sendKeys("secret_sauce");
       WebElement LoginButton=	driver.findElement(By.id("login-button"));
       LoginButton .click(); 
	 
	}
	@Test(priority=2) 
	public void VarifyThatTHewordProductsIsThere()  {  
		
        WebElement theMainNamaOnTheWebsite=	driver.findElement(By.xpath("//span[@data-test='title']"));
        boolean expectedResult=true;
        boolean ActualifTheElementThere= theMainNamaOnTheWebsite.isDisplayed();
        Assert.assertEquals(ActualifTheElementThere, expectedResult);
		
		
	} 
	
	@Test(priority=3) 
	public void SortingItems() throws InterruptedException {
		Thread.sleep(1000);
	    WebElement Raneem= driver.findElement(By.className("product_sort_container"));  
		Select myselector = new Select(Raneem);
		myselector.selectByVisibleText("Price (low to high)");
		
	 
	         
	  
	   List<WebElement> thePrices= driver.findElements(By.className("inventory_item_price"));
	   String HighestPriceAsText=thePrices.getLast().getText().replace("$", "");
	   String LowestPriceAsText=thePrices.getFirst().getText().replace("$", "");
	   System.out.println(HighestPriceAsText);
	   System.out.println(LowestPriceAsText);
	   double theHighestPrice= Double.parseDouble(HighestPriceAsText);  
	   double theLowestPrice=Double.parseDouble(LowestPriceAsText);
	   
	   boolean expectedValue =true;
	   Assert.assertEquals(theHighestPrice> theLowestPrice,expectedValue,"if the highest price higher then the lowest price this should return true");
	   
	  
	   
	 
	   
		  
			  
	   
		
		
		
		
		
	}
	
	
}
