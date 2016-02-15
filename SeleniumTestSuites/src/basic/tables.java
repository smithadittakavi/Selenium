package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/smitha/Desktop/LearningSelenium/DownloadsForSelenium/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://espn.go.com/nba/statistics/player/_/stat/scoring-per-game/sort/avgPoints/year/2015/seasontype/3/qualified/false/position/point-guards/split/439");
		// place table id into a variable 
		WebElement table = driver.findElement(By.cssSelector("table[class='tablehead']"));
		
		//Look for number of Rows in the above table
		List<WebElement>numberOfRows = table.findElements(By.tagName("tr"));
		System.out.println("Number of Rows in table :: "+numberOfRows.size());
		int i=0;
		// Find number of Columns in each of the above Rows 
		for(WebElement col : numberOfRows)
		{
			List<WebElement>numberOfColumns = col.findElements(By.tagName("td"));
			i++;
			System.out.println("Number of columns in row "+i+" is"+numberOfColumns.size());
			
			// Get Contents of each Column in Each Row
			for(WebElement text:numberOfColumns)
			{
				System.out.println("Content of column in Row "+i+" is : "+text.getText()); 
				
			}
		}
	}

}
