package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class cheapOAir {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		// Launch CheapOAir website
		driver.get("https://www.cheapoair.com/");
		
		//Close that extra window that pops up
		driver.findElement(By.cssSelector(".signupClose.icon.ic-cancel-fill")).click();
		
		//Click on ONE WAY radio button
		driver.findElement(By.cssSelector("label[id='owFlight']")).click();
		
		//Check if RETURN DATE exists or not and print boolean value on console
		System.out.println("RETURN DATE in code : "+driver.findElement(By.cssSelector("label[class='col-xs-5 col-sm-4 col-md-6 control-label icon ic-date-thin']")).isDisplayed());
		
		//driver.findElement(By.cssSelector("input[id='ember612']")).sendKeys("San Diego");
		
	
		//Clear the FROM field under ONE WAY
		WebElement from = driver.findElement(By.cssSelector("input[id='ember612']"));
		
		if(from != null)
		{
			from.clear();
			from.sendKeys("San Diego");
			Thread.sleep(2000);
		}
		driver.findElement(By.cssSelector("li[class='suggestion-box__menu icon ic-flight focused']")).click();
		
		// Enter a destination in TO field using EXPLICIT WAIT 
		driver.findElement(By.xpath(".//*[@id='ember622']")).click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		driver.findElement(By.xpath(".//*[@id='ember622']")).sendKeys("Atlanta");
		wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(".//*[@id='ember621']/div[2]/div/section/div/ul")));
		driver.findElement(By.xpath(".//*[@id='ember621']/div[2]/div/section/div/ul/li[2]")).click();
		
		
		/*
		 * // Enter a destination in TO field using MANUAL METHOD
		WebElement to = driver.findElement(By.cssSelector("input[id='ember622'"));
		
		if(to != null)
			{
			    to.clear();
			    to.sendKeys("Atlanta");
			    Thread.sleep(3000);
			} 
		driver.findElement(By.cssSelector("li[class='suggestion-box__menu icon ic-flight focused']")).click(); */
		
		//Click on Depart Calendar 
		driver.findElement(By.cssSelector("input[id='departCalendar_0']")).click();
		
		//Click on 30th
		driver.findElement(By.cssSelector("li[data-date='1448870400']")).click();
		
		//Click on number of ADULTS (Static Dropdown) 
		Select adult=new Select(driver.findElement(By.cssSelector("select[id='ember639']")));
		adult.selectByValue("5");
		
		//Click on number of SENIORS
		Select senior = new Select(driver.findElement(By.cssSelector("select[id='ember640']")));
		senior.selectByIndex(3);
		
		//Number of links in Footer section 
		WebElement col1 = driver.findElement(By.cssSelector("nav[class='footer-info__links row hidden-sm hidden-xs']"));
		System.out.println("Number of links in Footer : "+col1.findElements(By.tagName("a")).size());
					
		// Number of links inside FOOTER in first Column
		WebElement fcol = driver.findElement(By.cssSelector("ul[class='footer-info__nav col-xs-3 nav nav-tabs']"));
		System.out.println("Column 1 link number : "+fcol.findElements(By.tagName("a")).size());
		int i;
		for (i=0;i<fcol.findElements(By.tagName("a")).size();i++)
		{
			System.out.println("Name of link in Column 1: "+fcol.findElements(By.tagName("a")).get(i).getText());
		}
		
		
		//Number of links in Second Column
		WebElement col2 = driver.findElement(By.xpath(".//*[@id='link-section__01']/li[1]"));
		System.out.println("Col 2 links Number :"+col2.findElements(By.tagName("a")).size());
		int i1;
		for(i1=0;i1<col2.findElements(By.tagName("a")).size();i1++)
				{
					System.out.println("Names of links in Column 2 : "+col2.findElements(By.tagName("a")).get(i1).getText());
				}
		
		//Number of links in Third Column 
		WebElement col3 = driver.findElement(By.xpath(".//*[@id='link-section__01']/li[2]"));
		System.out.println("Column 3 link number : "+col3.findElements(By.tagName("a")).size());
		int i2=0;
		for(i2=0;i2<col3.findElements(By.tagName("a")).size();i2++)
		{
			System.out.println("Name of links in Column 3 :"+col3.findElements(By.tagName("a")).get(i2).getText());
			
			//Validate if a link is present in the 3rd column. If YES, click on it, else return FALSE
			if(col3.findElements(By.tagName("a")).get(i2).getText().contains("Gift Cards"))
			{
				System.out.println("Gift Cards is present :: PASS");
				col3.findElements(By.tagName("a")).get(i2).click();
				Thread.sleep(3000L);
				driver.navigate().back();
				
			}
			else 
			{
				System.out.println("Gift Cards is NOT present :: FAIL");
			}
		}
		
		
		
		//Click on SEARCH NOW 
		driver.findElement(By.cssSelector("input[class='cta-1st clrboth primary']")).click();
		
		//Navigate back to main page
		driver.navigate().back();
		
		//Quit the browser
		driver.quit();
		
			
			
		
	}

}
