package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tables1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.w3schools.com/html/html_tables.asp");
		// We have to send the Table object into a variable so that our code will read rows only from that table
		WebElement table = driver.findElement(By.cssSelector("table[class='w3-table-all']"));
		
		//Since we want to find multiple Rows in the table, we have to send the value into a list
		List<WebElement>numberOfRows = table.findElements(By.tagName("tr"));
		System.out.println("Number of ROWS :: "+numberOfRows.size());
		int i=0; 
		//Finding Number of <TD> (columns)  inside each <TR> (rows) 
		for(WebElement col : numberOfRows)
		{
				List<WebElement>numberOfColumns = col.findElements(By.tagName("td"));
				i++;
				System.out.println("Number of Columns in row number "+i+" is ::"+numberOfColumns.size());
				for(WebElement text:numberOfColumns)
				{
					System.out.println("Content of column in Row "+i+" is : "+text.getText()); 
					
				}
				
			
		}
		
		
		
	}

}
