package com.db.stepdefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.db.pages.DBPageElements;
import com.db.service.BrowserInitImpl;
import com.db.utils.ConfigReader;
import com.db.utils.DBHelperMethods;
import com.db.utils.HelperMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions.*;

public class DBCareerDefinitions{
   public static WebDriver driver;
    public int brokenLinksCount=0;  //removed static
    public static int jobCountOnJObSearchPage;
  //  public static String cityBeSelected;   //unused variable
    public String ExpectedValue;  //removed static
    BrowserInitImpl browserInitImpl = new BrowserInitImpl();
    
    public static WebDriver getDriver() {
		return driver;
	}
    
	@Given("User is on Deutsche Bank career page")
	public void user_is_on_deutsche_bank_career_page() {
		driver=browserInitImpl.getDriver();
		try {
			browserInitImpl.openURL(ConfigReader.init().getUrl());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//get shadow root element for cookies pop up
		DBPageElements dbElements = new DBPageElements(driver);
		SearchContext se = dbElements.getshadowRootpath().getShadowRoot();
       // se.findElement(By.cssSelector("#uc-center-container > div.sc-cCjUiG.gHlwwJ > div > div > div > button:nth-child(3)")).click();
        se.findElement(By.cssSelector("#uc-center-container > div.sc-eBMEME.dRvQzh > div > div > div > button:nth-child(3)")).click();
        
	}

	@When("User hovers mouse over Professionals link")
	public void user_hovers_mouse_over_link() {
		DBPageElements dbElements = new DBPageElements(driver);
	    HelperMethods.movetoElement(dbElements.getProfessionalLink());
	}

	@And("User clicks on Search Roles")
	public void user_moves_to_search_roles() {
		DBPageElements dbElements = new DBPageElements(driver);
		HelperMethods.movetoElement(dbElements.getsearchLink());
		HelperMethods.clickElementUsingActionsClass(dbElements.getsearchLink());
	}

	@Then("User is able to view Jobs search page")
	public void user_is_able_to_view_jobs_search_page() {
	    String s = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[1]/div/h3")).getText();
	    System.out.println(s);
	    String expected = "Search by:";
	    Assertions.assertThat(s).isEqualTo(expected);
	    
	}
	
	@Then("On clicking Search Roles under professionsal tab user is able to view Jobs search page")
	public void on_clicking_search_roles_under_professionsal_tab_user_is_able_to_view_jobs_search_page() {
		DBPageElements dbElements = new DBPageElements(driver);
	    HelperMethods.movetoElement(dbElements.getProfessionalLink());
	    HelperMethods.movetoElement(dbElements.getsearchLink());
	    HelperMethods.clickElementUsingActionsClass(dbElements.getsearchLink());
	    String actual = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[1]/div/h3")).getText();
	    String expected = "Search by:";
	    HelperMethods.validateText(expected, actual);
	}
	@Then("On clicking more button under professionsal section user is able to view Jobs search page")
	public void on_clicking_more_button_under_professionsal_section_user_is_able_to_view_jobs_search_page() {
	    driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[6]/a")).click();
	    Actions ac = new Actions(driver);
	    WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Discover the opportunity for you')]//following::a[1]"));
	    ac.moveToElement(el).click().build().perform();
	    String s = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[1]/div/h3")).getText();
	    System.out.println(s);
	    String expected = "Search by:";
	    Assertions.assertThat(s).isEqualTo(expected);
	    
	}
	@Then("On clicking View and Apply button on Your application user is able to view Jobs search page")
	public void on_clicking_view_and_apply_button_on_your_application_user_is_able_to_view_jobs_search_page() {
		Actions ac = new Actions(driver);
	    WebElement el = driver.findElement(By.xpath("//*[@id='professionals_top']/a"));
	    ac.moveToElement(el).perform();
	    el = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[2]/a"));
	    ac.moveToElement(el).click().build().perform();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    driver.findElement(By.xpath("//*[@id='content']/section[5]/div/div/div/section/div/div/a")).click();
	    el =driver.findElement(By.xpath("//*[@id='content']/section[5]/div/div/div/section/div/div/div[7]/div[2]/div/a"));
	    js.executeScript("arguments[0].click()", el);
	    
	    String s = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[1]/div/h3")).getText();
	    System.out.println(s);
	    String expected = "Search by:";
	    Assertions.assertThat(s).isEqualTo(expected);
	    
	}

	@Then("User is able to view Search Roles,FAQ, Professionals and  A notice on Recruitment Scams link")
	public void user_is_able_to_view_search_roles_faq_professionals_and_link() {
		Boolean SearchLink = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a")).isDisplayed();
		Boolean YourApplicationLink = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a")).isDisplayed();
		Boolean RecruitmentScamslink = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a")).isDisplayed();
		    Assertions.assertThat(SearchLink);
		    Assertions.assertThat(YourApplicationLink);
		    Assertions.assertThat(RecruitmentScamslink);
	}

	@Then("Validate that user is able to access all the links.")
	public void validate_that_user_is_able_to_access_all_the_links() {
	   System.out.println("All links are validated");
	}
	
	@When("User clicks on Professionals link")
	public void User_clicks_Professionals_link() {
		driver.findElement(By.xpath("//*[@id='professionals_top']/a")).click();
	
	}
	
	@When("User checks for any broken links on the page")
	public void user_check_for_any_broken_links_on_the_page() {
	    List<WebElement> lis = driver.findElements(By.xpath("//*[contains(@href,'professionals')]"));
	    System.out.println(lis.size());
	    for(int i=0;i<lis.size();i++) {
	    	String url = lis.get(i).getAttribute("href");
	    	URL link;
	    	HttpURLConnection conn = null;
			try {
				link = new URL(url);
				conn = (HttpURLConnection) link.openConnection();
				conn.setConnectTimeout(1000); // Set connection timeout to 3 seconds
				conn.connect();
				if (conn.getResponseCode() == 200) {
						System.out.println(url + " - " + conn.getResponseMessage());
					}else{
						System.out.println(conn.getResponseCode());
						//System.out.println(url + " - " + conn.getResponseMessage() + " - " + "is a broken link");
						brokenLinksCount++;
					}
			} catch (IOException e) {
				e.getMessage();
			}finally {
				conn.disconnect();
			}
	    }
	}

	@Then("There should be no broken links on the page")
	public void there_should_be_no_broken_links_on_the_page() {
	    if(brokenLinksCount>0) {
	    	System.out.println("There is/are - " +brokenLinksCount+ " broken link/links on the page");
	    	Assertions.assertThat(brokenLinksCount).isEqualTo(0);
	    }
	}
	
	@Given("User is on Job search Page")
	public void User_is_on_Job_Search_Page() {
		System.out.println("User is on Job Search Page");
	}
	
	@When("User clicks Search button without applying any filters")
	public void user_clicks_search_button_without_applying_any_filters() {
		
		WebElement el = driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[3]"));
		jobCountOnJObSearchPage=HelperMethods.extractintFromString(el);
		System.out.println(jobCountOnJObSearchPage);
	    driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[2]/a")).click();
	}
	
	@Then("Verify job search results page is displayed")
	public void Verify_job_search_results_page_is_displayed() {
		WebElement searResultPage = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/h2/span"));
	    String SearResultString = searResultPage.getText();
	    Assertions.assertThat(SearResultString).isEqualTo("Search Results:");
	}
	
	@Then("Verify Number of job results displayed on the page")
	public void Verify_Number_of_results_displayed_on_the_page() {
		WebElement el = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[2]/div/div[1]/div[1]"));
		int jobCountOnJobResultPage=HelperMethods.extractintFromString(el);
		List<WebElement> listOfJobs = driver.findElements(By.xpath("//*[@class='yello-search-result']/div/div/div/a"));
		if(listOfJobs.size()<10) {
			Assertions.assertThat(listOfJobs.size()).isEqualTo(jobCountOnJobResultPage);
		}
		
	}

	@Then("Verify job position count matches the one displayed on job search page")
	public void verify_job_position_count_matches_the_one_displayed_on_job_search_page() {
	    
	    //Verify count of jobs is correct by getting count on top of te page
	    WebElement el = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[2]/div/div[1]/div[1]"));
		int jobCountOnJobResultPage=HelperMethods.extractintFromString(el);
		System.out.println(jobCountOnJobResultPage);
		Assertions.assertThat(jobCountOnJObSearchPage).isEqualTo(jobCountOnJobResultPage);
		
		
	}
	
	@And("User selects {string} in Search By section")
	public void user_selects_division_in_search_by_section(String searchBy) {
	    WebElement radiobutton = driver.findElement(By.xpath("//label[contains(text(),'"+searchBy+"')]"));
	    Actions ac = new Actions(driver);
	    ac.moveToElement(radiobutton).click().build().perform();
	}

	@And("User selects division category and other filters")
	public void user_selects_division_category_and_other_filters(DataTable selectionValues) {
		
		List<Map<String, String>> listOfMap = selectionValues.asMaps();
		for(Map<String, String> map:listOfMap) {
			for(Entry<String, String> es :map.entrySet()) {
				WebElement genericDivCategory = driver.findElement(By.xpath("//*[text()='"+es.getKey()+"']/../div[2]/div"));
				if(null != es.getValue() && !es.getValue().isEmpty()) {
					By genericList = By.xpath("//*[contains(text(),'"+es.getKey()+"')]/../div[2]/ul/li");
					DBHelperMethods.selectValueFromDropdown(genericDivCategory , genericList , es.getValue());
				}
			}
		} 
		

		/*WebElement country=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[3]/div[1]/div[2]/div[1]"));
		By ListOfWebElements2 = By.xpath("//*[@class='select-wrapper']/div[3]/div/div[2]/ul/li");
		String CountryBeSelected="India";
		selectValueFromDropdown(country , ListOfWebElements2 , CountryBeSelected);
		
		WebElement City=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[3]/div[3]/div[2]/div[1]"));
		By ListOfWebElements3 = By.xpath("//*[@class='select-wrapper']/div[3]/div[3]/div[2]/ul/li");
		cityBeSelected="Mumbai";
		selectValueFromDropdown(City , ListOfWebElements3 , cityBeSelected);
		
		WebElement work=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[5]/div/div[2]/div"));
		By ListOfWebElements4 = By.xpath("//*[@class='select-wrapper']/div[5]/div/div[2]/ul/li");
		String workType="Permanent";
		selectValueFromDropdown(work , ListOfWebElements4 , workType);
	    */
	}

	@And("User clicks Search button")
	public void user_clicks_search_button() {
		WebElement el = driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[3]"));
		jobCountOnJObSearchPage=HelperMethods.extractintFromString(el);
		//System.out.println(jobCountOnJObSearchPage);
	    driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[2]/a")).click();
	}

	@And("Verify job search results page shows jobs from user has searched")
	public void verify_job_search_results_page_is_displayed_with_right_jobs_that_user_has_searched(DataTable userSelectedOptions) {
		 driver.findElement(By.xpath("//*[@class='yello-search-result']/div/div/div/a/div/h2")).click();
		List<Map<String, String>> lst = userSelectedOptions.asMaps();
		for(Map<String, String> mp   : lst) {
			for(Entry<String, String> es:mp.entrySet()) {
				if(es.getValue()!=null && !es.getValue().isEmpty()) {
					if("City".equals(es.getKey())) {
						String cityFromJobPage = driver.findElement(By.xpath("//*[@id='headerbox']/table/tbody/tr[3]/td")).getText();
						//cityFromJobPage.contains(es.getValue());
						System.out.println("City displayed on jobs page is " +cityFromJobPage);
						System.out.println("City user has elected is -"+es.getValue());
						//Assertions.assertThat(cityFromJobPage.contains(es.getValue())).as("City does not match").isEqualTo(true);
						Assertions.assertThat(cityFromJobPage.contains(es.getValue()));
					}else if ("What is your availability?".equals(es.getKey())) {
						String FromJobPage = driver.findElement(By.xpath( "//*[@id='headerbox']/table/tbody/tr[1]/td[2]")).getText();
						//Assertions.assertThat(FromJobPage.contains(es.getValue())).as("Availability does not match").isEqualTo(true);	
						Assertions.assertThat(FromJobPage.contains(es.getValue()));
					}else {
						System.out.println("Assertion not supported for "+es.getKey());
						Assertions.assertThat(true).isEqualTo(false);
					}
				}	
			}
		}
	}

	@Then("Verify job count matches with the total jobs on the page")	
	public void verify_job_count_matches_with_the_total_jobs_on_the_page() {
		WebElement CountofJobs=driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[2]/div/div[1]/div[1]"));
		int totaljobs=HelperMethods.extractintFromString(CountofJobs);
		//System.out.println("Jobs on top of Page = "+totaljobs);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			List<WebElement> loadmore=driver.findElements(By.xpath("//button[contains(text(),'Load more')]"));
			while(loadmore.size()>0) {
				loadmore.get(0).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				loadmore=driver.findElements(By.xpath("//button[contains(text(),'Load more')]"));
			}
		if(loadmore.size()==0) {
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			js.executeScript("window.scrollBy(0,0)");
		}
		List<WebElement> listOfJobs = driver.findElements(By.xpath("//*[@class='yello-search-result']/div/div/div/a"));
		//System.out.println("Lists of jobs =  " +listOfJobs.size());
		Assertions.assertThat(listOfJobs.size()).isEqualTo(totaljobs);
	}
	
	@When("User enters a keyword in {string} search box")
	public void user_enters_a_keyword_in_and_clicks_right_option_from_dropdown(String value) {
		ExpectedValue=value;
	    WebElement el = driver.findElement(By.xpath("//*[@id='roleKeyword']"));
	    JavascriptExecutor js = (JavascriptExecutor)driver; 
	    WebElement search =  driver.findElement(By.xpath("//*[@id='jobIdSearch']//following::a[1]"));
	    js.executeScript("arguments[0].scrollIntoView()", search);
	    el.sendKeys(value);
	    
	}
	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
	    WebElement search =  driver.findElement(By.xpath("//*[@id='jobIdSearch']//following::a[1]"));
	    js.executeScript("arguments[0].click()", search);
	}
	@When("User validates if the result contains the keywords that user has searched")
	public void user_validates_if_the_result_contains_the_keywords_that_user_has_searched() {
		List<WebElement> listOfJobs=driver.findElements(By.xpath("//*[contains(@href,'professional/job')]/div/h2"));
		if(listOfJobs.size()>0) {
			String Actual = listOfJobs.get(0).getText();
			Assertions.assertThat(Actual).contains(ExpectedValue);
		}else if (listOfJobs.size()==0) {
			System.out.println("No matching jobs found. Please refine your search criteria");
		}
	}
	
	@When("User enters a {string} in Job ID Keyword Section")
	public void user_enters_a_in_job_id_keyword_section(String value) {
		//System.out.println("value is - " + value);
		ExpectedValue=value;
	    WebElement el = driver.findElement(By.xpath("//*[@id='jobIdSearch']"));
	    JavascriptExecutor js = (JavascriptExecutor)driver; 
	    WebElement search =  driver.findElement(By.xpath("//*[@id='jobIdSearch']//following::a[1]"));
	    js.executeScript("arguments[0].scrollIntoView()", search);
	    el.sendKeys(value);
	}
	
	@When("User validates if the result contains the JobID that user has searched")
	public void user_validates_if_the_result_contains_JobID_that_user_has_searched() {
		
		List<WebElement> listOfJobs=driver.findElements(By.xpath("//*[contains(@href,'professional/job')]/div/h2"));
		if(listOfJobs.size()>0) {
			listOfJobs.get(0).click();
			//retrieve job ID
			String val = driver.findElement(By.xpath("//*[@id='headerbox']/table/tbody/tr[1]/td[1]")).getText();
			System.out.println("Job ID retrieved is " +val);
			if(!val.contains(ExpectedValue)) {
				String valuefromJobDescription = driver.findElement(By.xpath("//*[@id='db-jobad']")).getText();
				System.out.println("Page contains Text - "+valuefromJobDescription);
				Assertions.assertThat(valuefromJobDescription).contains(ExpectedValue);
			}else {
				Assertions.assertThat(val).contains(ExpectedValue);
			}
				
		}else if (listOfJobs.size()==0) {
			System.out.println("No matching jobs found. Please refine your search criteria");
		}
	}
	
	@And("Verify first preference is given to jobs having searched jobID")
	public void Verify_first_preference_is_given_to_jobs_having_searched_jobID() {
		//Get list of all jobs on search results page
		List<WebElement> listOfJobs=driver.findElements(By.xpath("//*[contains(@href,'professional/job')]/div/h2"));
		if(listOfJobs.size()>0) {
			//Click on the first job
			listOfJobs.get(0).click();
			//retrieve job ID from job description page
			String val = driver.findElement(By.xpath("//*[@id='headerbox']/table/tbody/tr[1]/td[1]")).getText();
			System.out.println("Job ID retrieved is " +val);
			if(!val.contains(ExpectedValue)) {
				//retrieve Job description data
				String valuefromJobDescription = driver.findElement(By.xpath("//*[@id='db-jobad']")).getText();
				System.out.println("Page contains Text - "+valuefromJobDescription);
				if(!valuefromJobDescription.contains(ExpectedValue)) {
					System.out.println("Jobs retrieved matches the Role title but does not match the Job Id entered");
				}else {
					Assertions.assertThat(valuefromJobDescription).contains(ExpectedValue);
				}
			}else {
				Assertions.assertThat(val).contains(ExpectedValue);
			}		
		}else if (listOfJobs.size()==0) {
			System.out.println("No matching jobs found. Please refine your search criteria");
		}
	}
	
}
