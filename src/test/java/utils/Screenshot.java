package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public String CaptureScrenshot(WebDriver driver, String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFilePath = System.getProperty("user.dir") + "//target/"+filename+ ".png";
		File destination = new File(destFilePath);
		try {
			FileUtils.copyFile(source, destination);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return destFilePath;
	}

}
