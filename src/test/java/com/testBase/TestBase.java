package com.testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public Properties p;
	public Logger logger; 
	 

	 public void setup() throws IOException
	    {
		    //Open browser & Url launched
	    	driver=new ChromeDriver();
		    driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    	driver.get("https://tutorialsninja.com/demo");//getting url from properties file
	    	
	    	//Loading config.properties file
	 		FileReader filep=new FileReader("./src//test//resources//config.properties");
	 		p=new Properties();
	 		p.load(filep);
	 		
	 		//Generate the logs
			logger=LogManager.getLogger(this.getClass());//******log4j2
	 		
	    }
	 
	
	 public void teardown()
		{
		 
			driver.quit();
		}
	 
	//RanodomString
		public String randomstring()
		{
			 RandomStringGenerator generator = new RandomStringGenerator.Builder()
		                .withinRange('a', 'z')
		                .build();
		        return generator.generate(5);
		}
		
		public String randomnumber()
		{
			Random random = new Random();  // create instance
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < 10; i++) {
		        sb.append(random.nextInt(10)); // generates digits 0–9
		    }
		    return sb.toString();
		}
		
		public String alphanumeric()
		{
			  String number = randomnumber();
		        String letters = randomstring();
		        return number + "@" + letters;
		}
		
		/*public String CaptureScreen(String tname) {
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);

			String Targepathtfile = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timestamp + ".png";
			File Targetfile = new File(Targepathtfile);

			try {

				Targetfile.getParentFile().mkdirs();

				// Copy file using FileUtils (more reliable)
				FileUtils.copyFile(sourcefile, Targetfile);

				System.out.println("Screenshot saved: " + Targepathtfile);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return Targepathtfile;
		}*/
}

