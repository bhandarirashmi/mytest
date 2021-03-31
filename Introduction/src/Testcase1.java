import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Set the path for Driver
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
		//create object for chromedriver
		WebDriver cd= new ChromeDriver();
		cd.get("http://www.google.com");
		

		
	}

}
