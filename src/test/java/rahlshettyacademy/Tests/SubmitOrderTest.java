package rahlshettyacademy.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahlshettyacademy.pageobject.CartPage;
import rahlshettyacademy.pageobject.CheckoutPage;
import rahlshettyacademy.pageobject.ConfirmationPage;
import rahlshettyacademy.pageobject.LandingPage;
import rahlshettyacademy.pageobject.OrderPage;
import rahlshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacadmey.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String productName ="ZARA COAT 3";
		
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException
	{
		
       ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"),input.get("password"));
        
        // step->2 .searching the product adding to the cart
       List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

       
       Boolean match = cartPage.VerifyProductDisplay(productName);  
       Assert.assertTrue(match);
      CheckoutPage checkoutPage= cartPage.goToCheckout();
      checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//ZARA COAT 3
		ProductCatalogue productCatalogue =landingPage.loginApplication("rajuautomatio@gmail.com","Raju@143");
		OrderPage ordersPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	// taking screenshot and storing the project 
	
	
    
	// providing the data using hashmap through file Purchaseorder.json storing all the details throuing
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rajujason//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1) }};		
	}


	/*HashMap<String,String> map=new HashMap<String,String>();
	map.put("email,","rajuautomatio@gmail.com");
	map.put("password","Raju@143");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String,String> map1=new HashMap<String,String>();
	map1.put("email,","jeevanna@gmail.com");
	map1.put("password","Jeevanna@143");
	map1.put("product", "ADIDAS ORIGINAL");*/

	}


