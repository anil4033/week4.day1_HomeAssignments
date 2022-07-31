package week4.day1HomeAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class leafgroundWindow {

	public static void main(String[] args) throws InterruptedException {
		//to call WDM for driver
				WebDriverManager.chromedriver().setup();
						
				//Launch browser			
				ChromeDriver driver = new ChromeDriver();
						
				//Load URL
				driver.get("http://www.leafground.com/pages/Window.html");
						
				//Maximize browser
						
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Click button to open home page in New Window
				String windowHandle = driver.getWindowHandle();
				
				driver.findElement(By.xpath("//button[@id='home']")).click();
				
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println("how many handels" + windowHandles.size());
				
				List<String> lstWindowsHandles = new ArrayList<String>(windowHandles);
				
				String secondWindowHandel = lstWindowsHandles.get(1);
				
				driver.switchTo().window(secondWindowHandel);
				
				String titleSecondWindow = driver.getTitle();
				
				if(titleSecondWindow.equalsIgnoreCase("TestLeaf - Selenium Playground")) {
					System.out.println("Second Window Launched sucessfully");
				}else {
					System.out.println("Second Window is not Launched sucessfully");
				}
                driver.close();
                
                driver.switchTo().window(windowHandle);
                
                //Find the Number of Opened Windows
                
                driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
                
                Set<String> WindowsHandels1 = driver.getWindowHandles();
                List<String> lstWindowsHandles1 = new ArrayList<String>(WindowsHandels1);
                int size = WindowsHandels1.size()-1;
                System.out.println("Number of number of windows opened are "+ size);
                
                //Close all except this window
                driver.switchTo().window(lstWindowsHandles1.get(1));
                driver.close();
                driver.switchTo().window(lstWindowsHandles1.get(2));
                driver.close();
                
                driver.switchTo().window(windowHandle);
                String title = driver.getTitle();
                //Verify whether all windows except the first window
                
                if(title.equalsIgnoreCase("Merge Contacts | opentaps CRM")) {
        			System.out.println("All opened windows closed other than this window");			
        		}else {
        			System.out.println("All opened windows are not closed");		
        		}
                
                //Wait for 2 new Windows to open
                driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
                
                Thread.sleep(5000);
                
                Set<String> WindowsHandels2= driver.getWindowHandles();
                List<String> lstWindowsHandles2 = new ArrayList<String>(WindowsHandels2);
                
                //Verifying whether two windows are opened
                driver.switchTo().window(lstWindowsHandles2.get(1));
                String title2 = driver.getTitle();
                if(title2.equalsIgnoreCase("TestLeaf - Interact with Buttons")) {
        			System.out.println("First Window displayed correct");			
        		}else {
        			System.out.println("First Window displayed correct");		
        		}
                
                driver.switchTo().window(lstWindowsHandles2.get(2));
                String title3 = driver.getTitle();
                if(title3.equalsIgnoreCase("TestLeaf - Interact with HyperLinks")) {
        			System.out.println("Second Window displayed correct");			
        		}else {
        			System.out.println("Second Window displayed correct");		
        		}
                
                //closing all windows
                driver.quit();
                
                System.out.println("All Actions performed successfully");
	}

}
