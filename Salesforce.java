package week4.day1HomeAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		/*1.Launch the browser
          2.Load the url as " https://login.salesforce.com/ "
          3.Enter the username as " ramkumar.ramaiah@testleaf.com "
          4. Enter the password as " Password$123 "
          5.click on the login button
          6.click on the learn more option in the Mobile publisher
          7.Switch to the next window using Windowhandles.
          8.click on the confirm button in the redirecting page
          9.Get the title
         10.Get back to the parent window
         11.close the browser*/

		//to call WDM for driver
		WebDriverManager.chromedriver().setup();
				
		//Launch browser			
		ChromeDriver driver = new ChromeDriver();
				
		//Load URL
		driver.get("https://login.salesforce.com/");
				
		//Maximize browser
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter the username as " ramkumar.ramaiah@testleaf.com 
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		//Enter the password as " Password$123 "
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password$123");
		//click on the login button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		//Switch to the next window using Windowhandles.
		String windowHandle = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindowHandles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(lstwindowHandles.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		System.out.println("The Window Title is " + driver.getTitle());
		
		driver.switchTo().window(windowHandle);		
		
		//Alert alert = driver.switchTo().alert();
		//System.out.println(alert.getText());
		//alert.dismiss();
		
		driver.quit();
					
	}

}
