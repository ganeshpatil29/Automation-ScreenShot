package SS;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot 
{

	public static void main(String[] args) throws Exception
	{
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Login
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		wd.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Take Screenshot.
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot)wd;
		FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("./scr.png"));
		//here the ("./")this will save your screenshop in your project. there is one another way to do this
		//FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\GANESH PATIL\\OneDrive\\Pictures\\Screenshots\\scr.png"));
		// the above line is for the saving your screenshot into the directory present in tour system.
		
		//Logout.
		Thread.sleep(2000);
		wd.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		wd.findElement(By.xpath("//a[.='Logout']")).click();
		
		wd.quit();
		
	}

}
