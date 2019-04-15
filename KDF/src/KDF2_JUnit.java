import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class KDF2_JUnit {
	static WebDriver myD;
	@Before
	public  void Before() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		//Open Browser	chrome	-
		myD = new ChromeDriver();
		myD.manage().window().maximize();
	}

	

	@Test
	public void YT_search_001_Basic() throws Exception {
		
		System.out.println("~~~~~~~~~~~~~Test Started~~~~~~~~~~~~~~~~");
		
				//Go to AUT	https://www.youtube.com/	-
				myD.navigate().to("https://www.youtube.com/");
				
				//Type into Search Field	All about automation frameworks	//input[@ id=’search’]
				myD.findElement(By.xpath("//*[@id='search']")).sendKeys("All about automation frameworks");
				
				//Click search icon	-	//*[@id=’search-icon-legacy’]
				myD.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
				Thread.sleep(1000);
				//Verify 1st Result	-	//*[@id='description-text']
				System.out.println("Test are"+myD.findElement(By.xpath("//*[@id='description-text']")).getText());
				System.out.println("~~~~~~~~~~~~~Test ended~~~~~~~~~~~~~~~~");
	
	}
	@Test
	public void YT_Search_002_ViewResults ()throws Exception {
		
		System.out.println("~~~~~~~~~~~~~Test Started~~~~~~~~~~~~~~~~");
		
				//Go to AUT	https://www.youtube.com/	-
				myD.navigate().to("https://www.youtube.com/");
				
				//Type into Search Field	All about automation frameworks	//input[@ id=’search’]
				myD.findElement(By.xpath("//*[@id='search']")).sendKeys("All about automation frameworks");
				
				//Click search icon	-	//*[@id=’search-icon-legacy’]
				myD.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
				Thread.sleep(1000);
				
				//Verify 1st Result	-	//*[@id='description-text']
				System.out.println(myD.findElement(By.xpath("//*[@id='description-text']")).getText());
				System.out.println(myD.findElement(By.xpath("(//*[@id='description-text'])[2]")).getText());
				System.out.println(myD.findElement(By.xpath("(//*[@id='description-text'])[3]")).getText());
				System.out.println("~~~~~~~~~~~~~Test ended~~~~~~~~~~~~~~~~");
	
		
		
	}
	
	
	@After
	public  void After() throws Exception {
		myD.close();
	}

}
