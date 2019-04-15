import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class KDF1 {
	
 static WebDriver myD;
	public static void main(String[] args) {

		//Open Browser	chrome	-
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		myD = new ChromeDriver();
		myD.manage().window().maximize();
		
		//Go to AUT	https://www.youtube.com/	-
		myD.navigate().to("https://www.youtube.com/");
		
		//Type into Search Field	All about automation frameworks	//input[@ id=’search’]
		myD.findElement(By.xpath("//*[@id='search']")).sendKeys("All about automation frameworks");
		
		//Click search icon	-	//*[@id=’search-icon-legacy’]
		myD.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
		
		//Verify 1st Result	-	//*[@id='description-text']
		System.out.println(myD.findElement(By.xpath("//*[@id='description-text']")).getText());

		
		myD.close();
	}

}
