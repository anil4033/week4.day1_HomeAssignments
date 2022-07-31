package week4.day1HomeAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		 /* //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
         */
		
		//to call WDM for driver
		WebDriverManager.chromedriver().setup();
				
		//Launch browser			
		ChromeDriver driver = new ChromeDriver();
				
		//Load URL
		driver.get("http://leaftaps.com/opentaps/control/login");
				
		//Maximize browser
				
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		//Enter Username and Password
				
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
				
		//Click Login button
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//Click on CRMSFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
        
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		String windowHandle = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("how many handels" + windowHandles.size());
		
		List<String> lstWindowsHandles = new ArrayList<String>(windowHandles);
		
		String secondWindowHandel = lstWindowsHandles.get(1);
		
		driver.switchTo().window(secondWindowHandel);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		driver.switchTo().window(windowHandle);
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println("how many handels" + windowHandles1.size());
		
		List<String> lstWindowsHandles1 = new ArrayList<String>(windowHandles1);
		
		String secondWindowHandel1 = lstWindowsHandles1.get(1);
		
		driver.switchTo().window(secondWindowHandel1);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		
		driver.switchTo().window(windowHandle);
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Merge Contacts | opentaps CRM")) {
			System.out.println("We are in expected page");			
		}else {
			System.out.println("We are not in expected page");		
		}
		
	}

}
