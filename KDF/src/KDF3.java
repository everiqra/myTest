import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class KDF3 {
	WebDriver myD;

	@Ignore @Test
	public void myTest ()throws Exception {


		openBrowser("Chrome");
		navigateBrowser("https://www.youtube.com/");
		typeText("All about automation frameworks","//*[@id='search']");
		clickElement("//*[@id='search-icon-legacy']");
		Thread.sleep(2000);
		verifyText("http://www.itelearn.com/ All About Automation Frameworks A free session by ITeLearn.com 0. What is Test automation. Why do we ...", "//*[@id='description-text']");
		closeBrowser( );


	}

	@Test
	public void myTest2 ()throws Exception {
		try{
			openBrowser("Chrome");
			navigateBrowser("https://www.youtube.com/");
			typeText("All about automation frameworks","//*[@id='search']");
			clickElement("//*[@id='search-icon-legacy']");
			Thread.sleep(2000);
			verifyText("bbbbbbb", "//*[@id='description-text']");
			Thread.sleep(2000);
			verifyText("bbbbbbb","(//*[@id='description-text'])[2]");
			Thread.sleep(2000);
			verifyText("bbbbbbb","(//*[@id='description-text'])[3]");
			closeBrowser( );
			System.out.println("Test Ran without issue");

		}catch( Exception e){
			System.out.println("Error is "+ e);
		}
	}



// Keyword function 
	public void openBrowser(String fTD){
		if (fTD.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
			//Open Browser	chrome	-
			myD = new ChromeDriver();
		}else if (fTD.equals("edge")){
			//System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
			myD = new EdgeDriver();
		}else if (fTD.equals("IE")){
			//System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
			myD = new InternetExplorerDriver();
		}else if (fTD.equals("FF")){
			//System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
			myD = new FirefoxDriver();
		}
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myD.manage().window().maximize();
	}
	public void navigateBrowser(String fTD){
		//Go to AUT
		//I/P: TD (Browser Name)
		// O/P: Nil
		myD.navigate().to(fTD);
	}
	public void typeText(String fTD, String fEID){
		// Type into Text Field 
		// I/P: TD (what to type), EID(where to type)
		// O/p: Nil
		myD.findElement(By.xpath(fEID)).sendKeys(fTD);
	}
	public void clickElement( String fEID){
		// Type into Text Field 
		// I/P: TD (what to type), EID(where to type)
		// O/p: Nil
		myD.findElement(By.xpath(fEID)).click();
	} 

	public void verifyText(String fTD, String fEID){
		// Verify Text in an element 
		// I/P: TD (what to type), EID(where to type)
		// O/p: Nil
		String fActualText;
		fActualText= myD.findElement(By.xpath(fEID)).getText();
		System.out.println("Actual Text is "+ fActualText);
		System.out.println("Expected Text is "+ fTD);


		if (fActualText.equals(fTD)){
			System.out.println("Test matched");
		}else {
			System.out.println("Text did not match");
		}
	} 
	//closeBrowser
	public void closeBrowser( ){
		myD.close();

	}


}
