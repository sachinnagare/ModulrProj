package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.*;



public class StepDefs {

	WebDriver driver=null;

	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		System.out.println("user is on login page");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); 
		driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://secure-sandbox.modulrfinance.com/"); 
	}

	@When("^user do not enter any value into username and password and click on login button$")
	public void user_do_not_enter_any_value_into_username_and_password_and_click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@id='signInSubmitButton']")).click();
		System.out.println("user do not enter any value into username and password and click on login button");
	}

	@When("^user enters password however do not enter username$")
	public void user_enters_password_however_do_not_enter_username() throws Throwable {
		driver.findElement(By.xpath("//input[@id='password-inp']")).sendKeys("12345");

		System.out.println("user enters password however do not enter username");

	}

	@Then("^an adequate error message should be shown$")
	public void an_adequate_error_message_should_be_shown() throws Throwable {

		String errorMessage=	driver.findElement(By.xpath("//div[@data-qa='error-message-div-display']")).getText();
		System.out.println("an adequate error message should be shown as :  "+errorMessage);
	}

	@And("^click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@id='signInSubmitButton']")).click();
		System.out.println("click on login button");

	}

	@When("^user enter incorrect username and password$")
	public void user_enter_incorrect_username() throws Throwable {
		driver.findElement(By.xpath("//input[@id='username-inp']")).sendKeys("sachin.nagare");
    	driver.findElement(By.xpath("//input[@id='password-inp']")).sendKeys("Flash@2345");
	}

	@Then("^an adequate warning message should be displayed$")
	public void an_adequate_warning_message_should_be_displayed() throws Throwable {
		Thread.sleep(5000);
		String alertMessage=driver.findElement(By.xpath("//div[@data-qa='signin-div-error-display']")).getText();
		System.out.println("an adequate error message should be shown as : " +alertMessage);
	}


    @When("^user enter valid username and password$")
    public void user_enter_valid_username_and_password() throws Throwable {
    	
    	driver.findElement(By.xpath("//input[@id='username-inp']")).sendKeys("sachin.nagare74");
    	driver.findElement(By.xpath("//input[@id='password-inp']")).sendKeys("Flash@234567");
    	
        System.out.println("entered valid username and passord");
    }

    @Then("^user redirect to Account page$")
    public void user_redirect_to_account_page() throws Throwable {
    	System.out.println("Account page after Login");
    	
    String act_title=	driver.getTitle();
    System.out.println(act_title);
    
    	String exp_Title="Modulr Payments";
       Assert.assertEquals(exp_Title, act_title);
        
 }


    @When("^click on Forgotten password link$")
    public void click_on_forgotten_password_link() throws Throwable {
    	System.out.println("click on Forgotten password link");
    	driver.findElement(By.xpath("//a[@id='forgotPasswordHref']")).click();
    }

    

    @And("^enter username to reset password$")
    public void enter_username_to_reset_password() throws Throwable {
    	System.out.println("enter username to reset password");
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys("sachin.nagare3@gmail.com");
    }

    @And("^click on Request a reset button$")
    public void click_on_request_a_reset_button() throws Throwable {
    	System.out.println("click on Request a reset button");
    	driver.findElement(By.xpath("//button[@id='signInSubmitButton']")).click();
    	Thread.sleep(5000);
        
    }

    @Then("^Email Sent popup should be displayed$")
    public void email_sent_popup_should_be_displayed() throws Throwable {
        System.out.println("Email Sent popup should be displayed");
      boolean popup=  driver.findElement(By.xpath("//p[@id='emailSentHeading']")).isDisplayed();
      if (popup=true) {
    	  System.out.println("pop up displayed");
      }
      else {
    	  System.out.println("pop up error");
      }
    }



	@After
	public void afterScenario(){
		driver.close();
		System.out.println("This will run after the Scenario");
	}


}
