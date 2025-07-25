package rahlshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	 
	 public LandingPage(WebDriver driver) 
	 {
		 super(driver);
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	 
	 
	//pagefactory
	 
	 @FindBy(id="userEmail")
	 WebElement userEmail;
	                                    
	 @FindBy(id="userPassword")
	 WebElement passwordEle;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 @FindBy(css="[class*='flyInOut']")
	 WebElement errorMessage;
	 
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public String getErroMessage()
	{
		waitForElementToAppear(errorMessage);
		return  errorMessage.getText();
	}
	public void goTo()
	{
		 driver.get("https://rahulshettyacademy.com/client");
	}
}

