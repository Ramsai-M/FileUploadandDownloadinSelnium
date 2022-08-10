package AutoITPack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpandDown {
	public static void main(String[] args) throws IOException, InterruptedException {
		String downloadPath=System.getProperty("C:\\Users\\this pc\\Downloads");
		HashMap<String,Object> chromeprefs=new HashMap<String,Object>();
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromeprefs);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\this pc\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://pdftoimage.com/");
		driver.findElement(By.xpath("//label[@class='button files__button files__button_mr']")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\this pc\\Downloads\\FileUpload.exe");
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='button files__button button_dark']")));
		driver.findElement(By.cssSelector("button[class='button files__button button_dark']")).click();
		Thread.sleep(3000);
		File f=new File(downloadPath+"pdftoimage.zip");
		Thread.sleep(5000);
		if(f.exists()) {
			System.out.println("File Found in downloads.");
			if(f.delete()) {
				System.out.println("File was deleted.");
			}
		}
		}
}
